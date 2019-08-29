package com.wangwei.test;

/**
 * @author: wangwei
 * @date: 2019-08-23 10:34
 */
public class StringUtils {
    public static void main(String[] args) {
        String endStr = "sitwecash20190819G00000000006B_".substring("sitwecash20190819G00000000006B_".lastIndexOf("_"));
        System.out.println(endStr);
    }
}
