package cn.dsq.customer.util;

import java.io.*;

/**
 * 文件操作，添加管理员信息
 */
public class SetManager {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\86135\\Desktop\\Java课设\\manager.txt");
        Writer writer = new FileWriter(file);
        writer.write("dsq\t");
        writer.write("12345678");
        writer.close();
    }

    public static boolean addManager(String name,String passwords) throws IOException {

        File file = new File("C:\\Users\\86135\\Desktop\\Java课设\\manager.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String row = null;
        while((row=reader.readLine())!=null){
            String[] n=row.split("\t");
            if(n[0].equals(name)){
                return false;
            }
        }
        FileWriter writer= new FileWriter("C:\\Users\\86135\\Desktop\\Java" +
                "课设\\manager.txt",true);
        writer.write("\n"+name+"\t");
        writer.write(passwords);
        writer.close();
        return true;
    }
}
