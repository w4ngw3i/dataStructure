package com.wangwei.leetcode.digui;

/**
 * @Auther wangwei
 * @Date 2018/5/27 下午8:10
 */
public class ArraySum {

    public static int sum(int[] arr) {
        return sum(arr, 0);

    }

    private static int sum(int[] arr, int l) {
        if (arr.length == l)
            return 0;
        int res = sum(arr, l + 1);
        return res;
    }
}
