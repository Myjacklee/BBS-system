package com.nuist.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author LiZonggen
 * @date 2021-03-07 22:13
 * @description:读取文件工具类
 * @version:
 */
public class FileReader {

    private List<String> a=new ArrayList<>();
    private HashMap<String,String> b= new HashMap<>();
    private Hashtable<String,String> d= new Hashtable<>();
    private Vector<String> c=new Vector<>();
    public static void readUtil(String filePath){
        try{
            String encoding="GBK";
            File file =new File(filePath);
            if(file.isFile()&&file.exists()){
                InputStreamReader reader=new InputStreamReader(new FileInputStream(file),encoding);
                BufferedReader bufferedReader =new BufferedReader(reader);
                HashMap<String,Integer> count=new HashMap<>();
                String line;
                while((line=bufferedReader.readLine())!=null){
                    String[] strings=line.split(" ");
                    for(int i=0;i<strings.length;i++){
                        if (count.get(strings[i])==null){
                            count.put(strings[i],1);
                        }else{
                            count.put(strings[i],count.get(strings[i])+1);
                        }
                    }
                }
                for(Map.Entry<String,Integer> entry:count.entrySet()){
                    System.out.println(entry.getKey() + " "+ entry.getValue());
                }
                reader.close();
            }else{
                System.out.println("找不到指定的文件...");
            }
        }catch ( Exception e){
            System.out.println("读取文件出错...");
            e.printStackTrace();
        }


    }
    public static void main(String[] args) {
        FileReader.readUtil("C:\\Users\\admin_2\\Desktop\\test.txt");
    }
}
