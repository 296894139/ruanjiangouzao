import java.awt.*;
import java.util.ArrayList;

public class Identification {
    public static void distinguish0(int strokes,ArrayList<ArrayList<Integer>> list,Graphics Pen){
        switch(strokes){
            case 1:
                //圆
                Pen.setColor(Color.YELLOW);
                for(int i=0;i<list.get(list.size()-1).size()-3;i=i+2){
                    if(list.get(list.size()-1).size()>=4){
                        Pen.drawLine(list.get(list.size()-1).get(i), list.get(list.size()-1).get(i+1),list.get(list.size()-1).get(i+2), list.get(list.size()-1).get(i+3));
                    }
                }
                Drawing_board.strokes=0;
                Drawing_board. Pen.setColor(Color.black);
                ArrayList<Integer> tem1=new ArrayList<Integer>();
                tem1.add(-1);
                Drawing_board.list.add(tem1);
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
                Drawing_board.strokes=0;
                Drawing_board.Pen.setColor(Color.black);
                ArrayList<Integer> tem2=new ArrayList<Integer>();
                tem2.add(-2);
                Drawing_board.list.add(tem2);
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
                Drawing_board.strokes=0;
                Drawing_board.Pen.setColor(Color.black);
                ArrayList<Integer> tem3=new ArrayList<Integer>();
                tem3.add(-3);
                Drawing_board.list.add(tem3);
                break;
            case 4:
                //正方形
                Drawing_board.Pen.setColor(Color.green);
                for(int i=0;i<list.get(list.size()-1).size()-3;i=i+2){
                    if(list.get(list.size()-1).size()>=4){
                        Drawing_board.Pen.drawLine(list.get(list.size()-1).get(i), list.get(list.size()-1).get(i+1),list.get(list.size()-1).get(i+2), list.get(list.size()-1).get(i+3));
                    }
                }
                for(int i=0;i<list.get(list.size()-2).size()-3;i=i+2){
                    if(list.get(list.size()-2).size()>=4){
                        Drawing_board. Pen.drawLine(list.get(list.size()-2).get(i), list.get(list.size()-2).get(i+1),list.get(list.size()-2).get(i+2), list.get(list.size()-2).get(i+3));
                    }
                }
                for(int i=0;i<list.get(list.size()-3).size()-3;i=i+2){
                    if(list.get(list.size()-3).size()>=4){
                        Drawing_board.Pen.drawLine(list.get(list.size()-3).get(i), list.get(list.size()-3).get(i+1),list.get(list.size()-3).get(i+2), list.get(list.size()-3).get(i+3));
                    }
                }
                for(int i=0;i<list.get(list.size()-4).size()-3;i=i+2){
                    if(list.get(list.size()-4).size()>=4){
                        Drawing_board.Pen.drawLine(list.get(list.size()-4).get(i), list.get(list.size()-4).get(i+1),list.get(list.size()-4).get(i+2), list.get(list.size()-4).get(i+3));
                    }
                }
                Drawing_board.strokes=0;
                Drawing_board.Pen.setColor(Color.black);
                ArrayList<Integer> tem4=new ArrayList<Integer>();
                tem4.add(-4);
                Drawing_board.list.add(tem4);
                break;
            default:
                ArrayList<Integer> tem5=new ArrayList<Integer>();
                tem5.add(-5);
                Drawing_board. list.add(tem5);
        }
    }
    public static void Standardized_graphics(int strokes,ArrayList<ArrayList<Integer>> list,Graphics Pen,Color background_color){
        if(list.size()==0) return;
        System.out.print(strokes+"s");
        if(strokes!=0){
            distinguish0(strokes,list,Pen);
        }
                int signal=list.get(list.size()-1).get(0);
                switch(signal){
                    case -1:
                        //圆
                        ArrayList<Integer> tem_list=list.get(list.size()-2);

                        int x=(tem_list.get(0)+tem_list.get(tem_list.size()/2))/2;
                        int y=(tem_list.get(1)+tem_list.get(tem_list.size()/2+1))/2;
                        double r=Math.sqrt((x*1.0-tem_list.get(0))*(x*1.0-tem_list.get(0))+(y*1.0-tem_list.get(1))*(y*1.0-tem_list.get(1)));
                        int r2=(int)r;
                        Pen.setColor(background_color);

                       DrawAStroke(tem_list,Pen);
                        Pen.setColor(Color.yellow);
                        Pen.drawOval(x,y,r2*2,r2*2);
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Pen.setColor(background_color);
                        Pen.drawOval(x,y,r2*2,r2*2);
                        Pen.setColor(Color.yellow);

                       DrawAStroke(tem_list,Pen);
                        Drawing_board.Pen.setColor(Color.black);
                        break;
                    case -2:
                        //长方形
                        ArrayList<Integer> tem_list1=list.get(list.size()-2);
                        ArrayList<Integer> tem_list2=list.get(list.size()-3);
                        int x1=tem_list1.get(0);
                        int y1=tem_list1.get(1);
                        int x2=tem_list1.get(tem_list1.size()-2);
                        int y2=tem_list1.get(tem_list1.size()-1);
                        Pen.setColor(background_color);

                           DrawAStroke(tem_list1,Pen);

                       DrawAStroke(tem_list2,Pen);
                        Pen.setColor(Color.red);
                        int x3=x1;
                        int y3=y2;
                        int x4=x1+x2-x3;
                        int y4=y1+y2-y3;

                        Pen.drawLine(x1,y1,x3,y3);
                        Pen.drawLine(x3,y3,x2,y2);
                        Pen.drawLine(x2,y2,x4,y4);
                        Pen.drawLine(x4,y4,x1,y1);
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Pen.setColor(background_color);
                        Pen.drawLine(x1,y1,x3,y3);
                        Pen.drawLine(x3,y3,x2,y2);
                        Pen.drawLine(x2,y2,x4,y4);
                        Pen.drawLine(x4,y4,x1,y1);
                        Pen.setColor(Color.red);
                      DrawAStroke(tem_list1,Pen);
                      DrawAStroke(tem_list2,Pen);
                        Drawing_board.Pen.setColor(Color.black);
                        break;
                     case -3:
                        //三角形
                         ArrayList<Integer> tem_list3=list.get(list.size()-2);
                         ArrayList<Integer> tem_list4=list.get(list.size()-3);
                         ArrayList<Integer> tem_list5=list.get(list.size()-4);
                         Pen.setColor(background_color);
                      DrawAStroke(tem_list3,Pen);
                      DrawAStroke(tem_list4,Pen);
                      DrawAStroke(tem_list5,Pen);
                         int x01=tem_list3.get(0);
                         int y01=tem_list3.get(1);
                         int x02=tem_list4.get(0);
                         int y02=tem_list4.get(1);
                         int x03=tem_list5.get(0);
                         int y03=tem_list5.get(1);
                         Pen.setColor(Color.blue);
                         Pen.drawLine(x01,y01,x02,y02);
                         Pen.drawLine(x01,y01,x03,y03);
                         Pen.drawLine(x02,y02,x03,y03);
                         try {
                             Thread.sleep(5000);
                         } catch (InterruptedException e) {
                             e.printStackTrace();
                         }
                         Pen.setColor(background_color);
                         Pen.drawLine(x01,y01,x02,y02);
                         Pen.drawLine(x01,y01,x03,y03);
                         Pen.drawLine(x02,y02,x03,y03);
                         Pen.setColor(Color.blue);
                         DrawAStroke(tem_list3,Pen);
                         DrawAStroke(tem_list4,Pen);
                         DrawAStroke(tem_list5,Pen);
                         Pen.setColor(Color.black);
                         break;
                    case -4:
                         //正方形
                        ArrayList<Integer> tem_list001=list.get(list.size()-2);
                        ArrayList<Integer> tem_list002=list.get(list.size()-4);
                        ArrayList<Integer> tem_list003=list.get(list.size()-3);
                        ArrayList<Integer> tem_list004=list.get(list.size()-5);
                        int x001=tem_list001.get(0);
                        int y001=tem_list001.get(1);
                        int x003=tem_list002.get(0);
                        int y003=tem_list002.get(1);
                        int x002=(x001+y001+x003-y003)/2;
                        int y002=(-x001+y001+x003+y003)/2;
                        int x004=(x001-y001+x003+y003)/2;
                        int y004=(x001+y001-x003+y003)/2;
                        Pen.setColor(background_color);

                       DrawAStroke(tem_list001,Pen);
                       DrawAStroke(tem_list002,Pen);
                       DrawAStroke(tem_list003,Pen);
                       DrawAStroke(tem_list004,Pen);
                        Pen.setColor(Color.green);
                        Pen.drawLine(x001,y001,x002,y002);
                        Pen.drawLine(x002,y002,x003,y003);
                        Pen.drawLine(x003,y003,x004,y004);
                        Pen.drawLine(x004,y004,x001,y001);
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Pen.setColor(background_color);
                        Pen.drawLine(x001,y001,x002,y002);
                        Pen.drawLine(x002,y002,x003,y003);
                        Pen.drawLine(x003,y003,x004,y004);
                        Pen.drawLine(x004,y004,x001,y001);
                        Pen.setColor(Color.green);
                        DrawAStroke(tem_list001,Pen);
                        DrawAStroke(tem_list002,Pen);
                        DrawAStroke(tem_list003,Pen);
                        DrawAStroke(tem_list004,Pen);
                        Pen.setColor(Color.black);
                        break;
                }
    }
  public static void DrawAStroke(ArrayList<Integer> list,Graphics Pen){
        for(int i=0;i<list.size()-3;i=i+2){
            Pen.drawLine(list.get(i), list.get(i+1),list.get(i+2), list.get(i+3));
        }
    }
}
