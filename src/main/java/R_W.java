import java.io.*;
import java.util.ArrayList;

public class R_W {

    public static void write(String fileName, String content) {
        FileWriter writer = null;
        try {
            // 打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件
            writer = new FileWriter(fileName, true);
            writer.write(content);
            writer.write("\r\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(writer != null){
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void overwrite(String fileName, String content) {
        FileWriter writer = null;
        try {

            writer = new FileWriter(fileName);
            writer.write(content);
            writer.write("\r\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(writer != null){
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static ArrayList<ArrayList<Integer>> read(String fileName){
        String line="";

        ArrayList<ArrayList<Integer>> list=new ArrayList<ArrayList<Integer>>();
         try{
             BufferedReader in=new BufferedReader(new FileReader(fileName));
             line=in.readLine();

             ArrayList<Integer> tem=new ArrayList<Integer>();
             while(line!=null){

                 if(line.contains(",")){

                     list.add(tem);
                     tem=new ArrayList<Integer>();
                 }else{
                     int a=Integer.parseInt(line);
                     tem.add(a);
                 }
                 line=in.readLine();
             }
         }catch(Exception e){

         }
         return list;
    }
    public static ArrayList<Object> getFileNames(){
        File file = new File("C:\\Users\\T5\\ruanjiangouzao\\src\\main\\File");
        // 获得该文件夹内的所有文件
        File[] array = file.listFiles();
        ArrayList<Object> result=new ArrayList<Object>();
        for(int i=0;i<array.length;i++){
            if(!array[i].getName().equals("num")){
                result.add(array[i].getName());

            }

        }
        return result;
    }
    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> tem0=Save_Access.access("num");
        System.out.println(tem0.get(0).get(0));
    }
}
