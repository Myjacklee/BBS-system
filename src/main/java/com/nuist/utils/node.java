package com.nuist.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author LiZonggen
 * @date 2021-03-10 18:03
 * @description:
 * @version:
 */
public class node {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String input=scanner.nextLine();
        input=input.substring(1,input.length()-1);
        System.out.println(input);
        String[]a=input.split(",");
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<a.length;i++){
            list.add(Integer.valueOf(a[i]));
        }
        boolean begin=true;
        for(int i=1;i<=list.size();i=i+2){
            if(begin){
                System.out.print("{"+list.get(i-1));
                begin=false;
            }else{
                System.out.print(","+list.get(i-1));
            }
        }
        for(int i=2;i<=list.size();i=i+2){
            System.out.print(","+list.get(i-1));
        }
        System.out.print("}");
    }
}
