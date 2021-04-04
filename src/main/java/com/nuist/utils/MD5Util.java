package com.nuist.utils;

import org.springframework.util.DigestUtils;

/**
 * @author LiZonggen
 * @date 2021-04-03 10:17
 * @description:md5生成工具类
 * @version:
 */
public class MD5Util {
    //盐，用于混交md5
    private static final String slat = "&%5123***&&%%$$#@";
    public static String getMD5(String str) {
        String base = str +"/"+slat;
        String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
        return md5;
    }

}
