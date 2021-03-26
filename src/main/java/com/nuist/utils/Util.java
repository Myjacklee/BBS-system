package com.nuist.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiZonggen
 * @date 2021-03-09 17:48
 * @description:分解合数
 * @version:
 */
public class Util {


    public static void main(String[] args) {
        List<Integer> a =new ArrayList<>();
        serch(20);
    }
    public static void serch(int n){
        List<Integer> list = new ArrayList<>();
        double sqrt = Math.sqrt(n);
        int i = 2;
        while (n >= 2) {
            if (n % i == 0) {
                list.add(i);
                n /= i;
                i = 2;
            }else {
                i++;
            }
        }
        int s = 1;
        for (Integer l : list){
            System.out.println(l);
            s *= l;
        }
        System.out.println(s);

    }
}
