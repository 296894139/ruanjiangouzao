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
        switch(strokes){
            case 0:
                int signal=list.get(list.size()-1).get(0);

                switch(signal){
                    case -1:
                        ArrayList<Integer> tem_list=list.get(list.size()-2);
                        int x=(tem_list.get(0)+tem_list.get(tem_list.size()/2))/2;
                        int y=(tem_list.get(1)+tem_list.get(tem_list.size()/2+1))/2;
                        double r=Math.sqrt((x*1.0-tem_list.get(0))*(x*1.0-tem_list.get(0))+(y*1.0-tem_list.get(1))*(y*1.0-tem_list.get(1)));
                        int r2=(int)r;
                        Pen.setColor(background_color);
                        for(int i=0;i<tem_list.size()-3;i=i+2){
                            Pen.drawLine(tem_list.get(i), tem_list.get(i+1),tem_list.get(i+2), tem_list.get(i+3));
                        }
                        Pen.setColor(Color.yellow);
                        Pen.drawOval(x,y,r2,r2);
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Pen.setColor(background_color);
                        Pen.drawOval(x,y,r2*2,r2*2);
                        Pen.setColor(Color.yellow);
                        for(int i=0;i<tem_list.size()-3;i=i+2){
                            Pen.drawLine(tem_list.get(i),tem_list.get(i+1),tem_list.get(i+2), tem_list.get(i+3));
                        }

                }
        }
    }





}
