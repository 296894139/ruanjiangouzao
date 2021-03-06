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
/**
 *@创建人 徐介晖
 *@创建时间 2018-9-15
 *@描述   画板界面
 */
public class Drawing_board extends JFrame {
    static Graphics Pen;
    static Color backColor;
    static  ArrayList<ArrayList<Integer>> list;
    ArrayList<Integer> tem;
    static int strokes=0;
    JMenuBar bar;
    JMenu menu;
    JMenu menu2;
    JMenuItem clear;
    JMenuItem save;
    JMenuItem open;
    JMenuItem draw;
     JMenuItem distinguish;
     JMenuItem  Standardized;
    JPanel p;

    public Drawing_board() {
        Initialization_interface();
        AddListenerToComponents();
    }
    public void AddListenerToComponents(){

        clear.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.Event.CTRL_MASK));
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearAll();
            }
        });
        save.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.Event.CTRL_MASK));
        distinguish.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.Event.CTRL_MASK));
        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ToOpenFile();
            }
        });
        Standardized.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Identification.Standardized_graphics(strokes,list,Pen,backColor);
            }
        });
        distinguish.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Identification.distinguish0(strokes,list,Pen);//distinguish();
            }
        });
        save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Save();
            }
        });
        draw.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Pen = p.getGraphics();
                Pen.setColor(Color.BLACK);
            }
        });
        addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                System.out.println(e.getX()+" "+e.getY());

                if (Pen == null) return;
                tem.add(e.getX()-10);
                tem.add(e.getY()-60);
                if(tem.size()>=4){
                    Pen.drawLine(tem.get(tem.size()-4),tem.get(tem.size()-3),e.getX()-10, e.getY()-60);
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
    }
    public void Initialization_interface(){
        tem=new ArrayList<Integer>();
        list=new ArrayList<ArrayList<Integer>>();

        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        p = new JPanel();
        backColor=this.getBackground();
        add(p, BorderLayout.CENTER);

        bar = new JMenuBar();
        setJMenuBar(bar);
        menu = new JMenu("文件");
        menu2 = new JMenu("操作");
        clear = new JMenuItem("清屏");
        save=new JMenuItem("保存");
        open = new JMenuItem("打开");
        draw=new JMenuItem("开始");
        distinguish=new JMenuItem("分辨");
        Standardized=new JMenuItem("标准化图形预览");
        menu2.add(clear);
        menu2.add(distinguish);
        menu2.add(Standardized);
        menu.add(open);
        menu.add(save);
        menu2.add(draw);
        menu.addMenuListener(null);
        bar.add(menu2);
        bar.add(menu);
        p.setBorder(BorderFactory.createTitledBorder("小型几何画板"));

        setVisible(true);
    }
    public  void InitializationFile(String FileName){
        if(Pen==null) return;
        ArrayList<ArrayList<Integer>> list0=Save_Access.access(FileName);
          clearAll();
        list=list0;
       for(int i=0;i<list0.size();i++){
            if(list0.get(i).get(0)>0){
                int u=i;
                while(u<list0.size()&&list0.get(u).size()>1){
                    u++;
                }
                if(u>=list0.size()){
                    Pen.setColor(Color.black);
                }else{
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
     public void Save(){
         if(Pen==null) return;
         if(strokes!=0){
             Identification.distinguish0(strokes,list,Pen);
         }
         ArrayList<ArrayList<Integer>> tem0=Save_Access.access("num");
         // System.out.println(tem0.size());
         int tem_num=tem0.get(0).get(0)+1;
        //  System.out.println(tem_num);
         String name=InputFileName();
         //C:\Users\T5\ruanjiangouzao\
         R_W.overwrite("src\\main\\File\\num",tem_num+"");
         //C:\Users\T5\ruanjiangouzao\
         R_W.write("src\\main\\File\\num",",");
         Save_Access.save(name,list);
     }
     public String InputFileName(){
         String result = (String) JOptionPane.showInputDialog(null, "请输入文件名：\n", "保存文件", JOptionPane.PLAIN_MESSAGE, null, null,
                 "请输入文件名");
          return result;
     }
     public void ToOpenFile(){
         if(Pen==null) return;
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
}




