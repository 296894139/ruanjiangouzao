import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
/*
  圆：黄色
  正方形：绿色
  长方形：红色
  三角形：蓝色
 */
public class HuiTu extends JFrame {
    static Graphics Pen;
    static  ArrayList<ArrayList<Integer>> list;
    ArrayList<Integer> tem;
    static int strokes=0;
    public HuiTu() {
        tem=new ArrayList<Integer>();
        list=new ArrayList<ArrayList<Integer>>();
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        final JPanel p = new JPanel();
        add(p, BorderLayout.CENTER);
        JMenuBar bar = new JMenuBar();
        setJMenuBar(bar);
        JMenu menu = new JMenu("文件");
        JMenu menu2 = new JMenu("操作");
        JMenuItem clear = new JMenuItem("清屏");
        clear.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.Event.CTRL_MASK));
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearAll();
            }
        });
        JMenuItem save=new JMenuItem("保存");
        save.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.Event.CTRL_MASK));
        JMenuItem open = new JMenuItem("打开");
        JMenuItem draw=new JMenuItem("开始");
        final JMenuItem distinguish=new JMenuItem("分辨");
        distinguish.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.Event.CTRL_MASK));
        menu2.add(distinguish);
        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Object> tem=R_W.getFileNames();
                int i=tem.size();
                Object[] selectionValues = new Object[i];
                for(int u=0;u<i;u++){
                    selectionValues[u]=tem.get(u);
                }

                // 显示输入对话框, 返回选择的内容, 点击取消或关闭, 则返回null
                Object inputContent = JOptionPane.showInputDialog(
                        p,
                        "选择要打开的文件: ",
                        "标题",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        selectionValues,
                        selectionValues[0]
                );
                System.out.println("输入的内容: " + inputContent);

                 InitializationFile(inputContent+"");
            }
        });
        distinguish.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                  distinguish();
            }
        });
        menu2.add(clear);
        menu.add(open);
        menu.add(save);

        save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                 ArrayList<ArrayList<Integer>> tem0=Save_Access.access("num");
                 System.out.println(tem0.size());
                 int tem_num=tem0.get(0).get(0)+1;
                 System.out.println(tem_num);
                 R_W.overwrite("C:\\Users\\T5\\_xjh\\src\\main\\File\\num",tem_num+"");
                 R_W.write("C:\\Users\\T5\\_xjh\\src\\main\\File\\num",",");
                 Save_Access.save(tem_num+"",list);
            }
        });
        draw.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Pen = p.getGraphics();
                Pen.setColor(Color.BLACK);

            }
        });


        menu2.add(draw);
        //JPoputMenu popupMenu = new JPopupMenu();设置弹出菜单
        menu.addMenuListener(null);
        bar.add(menu2);
        bar.add(menu);

        p.setBorder(BorderFactory.createTitledBorder("小型几何画板"));

        addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {


                if (Pen == null) return;
                 tem.add(e.getX());
                 tem.add(e.getY());

                if(tem.size()>=4){
                    Pen.drawLine(tem.get(tem.size()-4),tem.get(tem.size()-3),e.getX(), e.getY());
                }

            }
        });
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                list.add(tem);
                tem=new ArrayList<Integer>();
                strokes++;


            }
        });

        setVisible(true);
    }
    public  void InitializationFile(String FileName){
        ArrayList<ArrayList<Integer>> list0=Save_Access.access(FileName);
          clearAll();
        list=list0;
       for(int i=0;i<list0.size();i++){
            if(list0.get(i).get(0)>0){
                int u=i;
                while(u<list0.size()&&list0.get(u).get(0)>0){
                    u++;
                }
                switch(list0.get(u).get(0)){
                    case -1:Pen.setColor(Color.yellow);
                             break;
                    case -2:Pen.setColor(Color.red);
                        break;
                    case -3:Pen.setColor(Color.blue);
                        break;
                    case -4:Pen.setColor(Color.green);
                        break;
                    case -5:Pen.setColor(Color.black);
                        break;

                }

                for(;i<u;i++){
                    for(int t=0;t<list0.get(i).size()-3;t=t+2){
                       // Pen.fillOval(list0.get(i).get(t),list0.get(i).get(t+1),3,3);
                        Pen.drawLine(list0.get(i).get(t), list0.get(i).get(t+1),list0.get(i).get(t+2), list0.get(i).get(t+3));
                    }
                }
                i=u;

                  Pen.setColor(Color.black);


            }
        }

     }
     public  void clearAll(){
        if(Pen==null) return;
         Pen.setColor(this.getBackground());
         for(int i=0;i<list.size();i++){
             for(int u=0;u<list.get(i).size()-3;u=u+2){
                   // Pen.fillOval(list.get(i).get(u),list.get(i).get(u+1),3,3);
                 Pen.drawLine(list.get(i).get(u), list.get(i).get(u+1),list.get(i).get(u+2), list.get(i).get(u+3));
             }
         }
         list=new ArrayList<ArrayList<Integer>>();
         Pen.setColor(Color.black);
     }
     public static void distinguish(){
         switch(strokes){
             case 1:
                 //圆
                 Pen.setColor(Color.YELLOW);
                 for(int i=0;i<list.get(list.size()-1).size()-3;i=i+2){
                     if(list.get(list.size()-1).size()>=4){
                         Pen.drawLine(list.get(list.size()-1).get(i), list.get(list.size()-1).get(i+1),list.get(list.size()-1).get(i+2), list.get(list.size()-1).get(i+3));
                     }
                 }
                 strokes=0;
                 Pen.setColor(Color.black);
                 ArrayList<Integer> tem1=new ArrayList<Integer>();
                 tem1.add(-1);
                 list.add(tem1);
                 break;
             case 2:
                 //长方形
                 Pen.setColor(Color.red);
                 for(int i=0;i<list.get(list.size()-1).size()-3;i=i+2){

                     if(list.get(list.size()-1).size()>=4){
                         Pen.drawLine(list.get(list.size()-1).get(i), list.get(list.size()-1).get(i+1),list.get(list.size()-1).get(i+2), list.get(list.size()-1).get(i+3));
                     }

                 }

                 for(int i=0;i<list.get(list.size()-2).size()-3;i=i+2){
                     if(list.get(list.size()-2).size()>=4){
                         Pen.drawLine(list.get(list.size()-2).get(i), list.get(list.size()-2).get(i+1),list.get(list.size()-2).get(i+2), list.get(list.size()-2).get(i+3));
                     }

                 }
                 strokes=0;
                 Pen.setColor(Color.black);
                 ArrayList<Integer> tem2=new ArrayList<Integer>();
                 tem2.add(-2);
                 list.add(tem2);
                 break;
             case 3:
                 //三角形



                 Pen.setColor(Color.blue);
                 for(int i=0;i<list.get(list.size()-1).size()-3;i=i+2){
                     if(list.get(list.size()-1).size()>=4){
                         Pen.drawLine(list.get(list.size()-1).get(i), list.get(list.size()-1).get(i+1),list.get(list.size()-1).get(i+2), list.get(list.size()-1).get(i+3));
                     }

                 }
                 for(int i=0;i<list.get(list.size()-2).size()-3;i=i+2){

                     if(list.get(list.size()-2).size()>=4){
                         Pen.drawLine(list.get(list.size()-2).get(i), list.get(list.size()-2).get(i+1),list.get(list.size()-2).get(i+2), list.get(list.size()-2).get(i+3));
                     }

                 }
                 for(int i=0;i<list.get(list.size()-3).size()-3;i=i+2){
                     if(list.get(list.size()-3).size()>=4){
                         Pen.drawLine(list.get(list.size()-3).get(i), list.get(list.size()-3).get(i+1),list.get(list.size()-3).get(i+2), list.get(list.size()-3).get(i+3));
                     }

                 }
                 strokes=0;
                 Pen.setColor(Color.black);
                 ArrayList<Integer> tem3=new ArrayList<Integer>();
                 tem3.add(-3);
                 list.add(tem3);
                 break;
             case 4:
                 //正方形
                 Pen.setColor(Color.green);
                 for(int i=0;i<list.get(list.size()-1).size()-3;i=i+2){
                     if(list.get(list.size()-1).size()>=4){
                         Pen.drawLine(list.get(list.size()-1).get(i), list.get(list.size()-1).get(i+1),list.get(list.size()-1).get(i+2), list.get(list.size()-1).get(i+3));
                     }

                 }
                 for(int i=0;i<list.get(list.size()-2).size()-3;i=i+2){
                     if(list.get(list.size()-2).size()>=4){
                         Pen.drawLine(list.get(list.size()-2).get(i), list.get(list.size()-2).get(i+1),list.get(list.size()-2).get(i+2), list.get(list.size()-2).get(i+3));
                     }

                 }
                 for(int i=0;i<list.get(list.size()-3).size()-3;i=i+2){
                     if(list.get(list.size()-3).size()>=4){
                         Pen.drawLine(list.get(list.size()-3).get(i), list.get(list.size()-3).get(i+1),list.get(list.size()-3).get(i+2), list.get(list.size()-3).get(i+3));
                     }

                 }
                 for(int i=0;i<list.get(list.size()-4).size()-3;i=i+2){
                     if(list.get(list.size()-4).size()>=4){
                         Pen.drawLine(list.get(list.size()-4).get(i), list.get(list.size()-4).get(i+1),list.get(list.size()-4).get(i+2), list.get(list.size()-4).get(i+3));
                     }

                 }

                 strokes=0;
                 Pen.setColor(Color.black);
                 ArrayList<Integer> tem4=new ArrayList<Integer>();
                 tem4.add(-4);
                 list.add(tem4);
                 break;
             default:
                 ArrayList<Integer> tem5=new ArrayList<Integer>();
                 tem5.add(-5);
                 list.add(tem5);
         }
     }
    public static void main(String[] args) {
        new HuiTu();
    }
}




