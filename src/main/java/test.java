
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.MenuListener;
/**
 * JFrame的应用，直接继承JFrame类能够直接使用其中对JFrame进行操作的方法
 *
 * 中间容器的使用
 * 对窗体、窗格、面板的理解。
 * 窗体Frame是包括放大、关闭按钮的整个可视化界面
 * 窗格Pane是一种对面的分割工具，能够将洁面按照不同的要求分割成各种形状
 * 面板Panel是一种用来储存空间的空间，向下放入控件，向上添加到已经分好的窗格当中
 *
 * 布局管理
 * FlowLayout		流式布局
 * BorderLayout		边界布局
 * GridLayout		网格布局
 * CardLayout		卡片布局
 * BoxLayout		盒式布局
 * GridBagLayout	网格包布局
 * 布局是对panel面板的操作因为它是直接存储控件的容器
 *
 * 事件处理机制
 * 与java.awt学习时的时间处理机制完全相同
 *
 * java.swing的菜单和表格
 * JMenebar菜单条
 * JMenu菜单
 * JMenuItem菜单项
 */

public class test extends JFrame{

    /**
     * 当前窗体的构造函数
     * 对当前窗体进行基本的设置。
     */
    public test(){
        super("MySecondJFrame");

        setSize(300, 300);
        setLocation(500, 400);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(NORMAL);

        init();

    }

    private void init(){
        Container con = getContentPane();//得到内部的无边界窗格
        JPanel panel = new JPanel();//创建一个面板对象
        JLabel jl=new JLabel("456");
        jl.setLocation(123,23);
        con.add(jl);
        FlowLayout fl = new FlowLayout(FlowLayout.LEFT,10,10);//组件的位置，组件之间的水平和垂直间距

        //属性gridx,gridy位置,gridwidth,gridheight占据网格数,anchor方位,fill充满方式
        GridBagConstraints gbc = new GridBagConstraints();
        GridBagLayout gbl = new GridBagLayout();

        BorderLayout bl1 = new BorderLayout(10,10);

        CardLayout layout1 = new CardLayout(10,10);//组件与容器边缘的间距

        Box b1 = Box.createHorizontalBox();//创建一个从左到右显示其组件的
        Box b2 = Box.createVerticalBox();//创建一个从上到下显示其组件的 Box

        //panel.setLayout(bl1);
        panel.setLayout(new GridLayout(2,4));
        //panel.setLayout(gbl);



        JButton butt1 = new JButton("Press Me1");//创建一个按钮对象
        panel.add(butt1,BorderLayout.CENTER);//添加对象
        con.add(panel);

        JButton butt2 = new JButton("Press Me2");//创建一个按钮对象
        panel.add(butt2,BorderLayout.EAST);//添加对象
        con.add(panel);

        JButton butt3 = new JButton("Press Me3");//创建一个按钮对象
        panel.add(butt3,BorderLayout.WEST);//添加对象
        con.add(panel);

        JButton butt4 = new JButton("Press Me4");//创建一个按钮对象
        panel.add(butt4,BorderLayout.NORTH);//添加对象
        con.add(panel);

        JButton butt5 = new JButton("Press Me5");//创建一个按钮对象
        panel.add(butt5,BorderLayout.SOUTH);//添加对象
        con.add(panel);

/*		JTextArea ta1 = new JTextArea(50,50);
		JScrollPane sp1 = new JScrollPane(ta1);
		con.add(sp1);

		JTextArea ta2 = new JTextArea(50,50);
		JSplitPane sp2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,ta2,panel);
		con.add(sp2);

		JTabbedPane tp = new JTabbedPane();
		tp.setTabPlacement(int);
		tp.addChangeListener();
*/


        //事件处理机制的使用

        //创建菜单
        JMenuBar bar = new JMenuBar();
        setJMenuBar(bar);
        JMenu menu = new JMenu("文件");
        JMenu menu2 = new JMenu("Edit");
        JMenuItem newf = new JMenuItem("新建");
        newf.setAccelerator(KeyStroke.getKeyStroke("ctrl N"));
        JMenuItem open = new JMenuItem("打开");

        open.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("123");
            }
        });



        menu.add(newf);
        menu.add(open);

        //JPoputMenu popupMenu = new JPopupMenu();设置弹出菜单
        menu.addMenuListener(null);

        bar.add(menu);

        //表格JTable

        //当所有的组件都添加以后，要重新设置一次可见性。
        setVisible(true);
        int rows = 3;
        int cols = 4;
        JTable table = new JTable(rows,cols);
        table.setShowGrid(true);
        table.setGridColor(Color.RED);
        table.setRowHeight(5);


    }
    public static void main(String[]args){
        test f=new test();
    }

}
