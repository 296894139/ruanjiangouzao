import java.io.File;
import java.util.ArrayList;

public class Save_Access {
    public static void save(String name, ArrayList<ArrayList<Integer>> list){
          File file=new File("C:\\Users\\T5\\_xjh\\src\\main\\File",name);
          try{
              file.createNewFile();
              for(int i=0;i<list.size();i++) {
                  for (int u = 0; u < list.get(i).size(); u++) {
                      R_W.write("C:\\Users\\T5\\_xjh\\src\\main\\File\\" + name, list.get(i).get(u) + "");
                  }
                  R_W.write("C:\\Users\\T5\\_xjh\\src\\main\\File\\" + name, ",");
              }
          }catch (Exception e){

          }
    }
    public static ArrayList<ArrayList<Integer>> access(String name){
        String fileName="C:\\Users\\T5\\_xjh\\src\\main\\File\\" + name;
        ArrayList<ArrayList<Integer>> list=R_W.read(fileName);
        return list;
    }
    public static void main(String []args){
      /*  ArrayList<ArrayList<Integer>> t=new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> tem1=new ArrayList<Integer>();
        ArrayList<Integer> tem2=new ArrayList<Integer>();
        tem1.add(1);
        tem1.add(2);
        tem2.add(3);
        tem2.add(4);
        t.add(tem1);
        t.add(tem2);
        save("lalal2",t);*/
        ArrayList<ArrayList<Integer>> t=access("2");

        for(int i=0;i<t.size();i++){
            for(int u=0;u<t.get(i).size();u++){
                System.out.println(t.get(i).get(u));
            }
        }
    }
}
