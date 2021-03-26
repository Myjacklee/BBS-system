package com.nuist.utils;

/**
 * @author LiZonggen
 * @date 2021-03-12 11:33
 * @description:
 * @version:
 */
public class TestString {
    public static void main(String[] args) {
        String a="aa";
        String b="aa";
        ThreadLocal<String> tl= new ThreadLocal<>();
        System.out.println(a==b);
    }
}
