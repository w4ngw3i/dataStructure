package com.wangwei.java8.stream.test;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;

/**
 * @Author wangwei
 * @Date 2020/5/7 1:11 下午
 * @Version 1.0
 * 给定两个数字列表，如何返回所有的数对呢?例如，给定列表[1, 2, 3]和列表[3, 4]，应 该返回[(1, 3), (1, 4), (2, 3), (2, 4), (3, 3), (3, 4)]。
 * 为简单起见，你可以用有两个元素的数组来代 表数对。
 */
public class Test3 {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3};
        int reduce = Arrays.stream(arr1).reduce(1, (x, y) -> x * y);
        OptionalInt reduce1 = Arrays.stream(arr1).reduce((x, y) -> x * y);
        System.out.println(reduce);
        //System.out.print("[");
        //for (int i = 0; i < arr1.length; i++) {
        //    if (i != arr1.length - 1){
        //        System.out.print(arr1[i] + ",");
        //    }else {
        //        System.out.print(arr1[i] + "]");
        //    }
        //}
        //int[] arr2 = {3,4};
        //Arrays.stream(arr1)
        //        .map( i -> i *i)
        //        .forEach(System.out::println);
        List<Integer> integers = Arrays.asList(1, 2, 3);
        List<Integer> integers1 = Arrays.asList(3, 4);
        List<int[]> collect = integers.stream()
                .flatMap(i -> integers1.stream().map(j -> new int[]{i, j}))
                .collect(Collectors.toList());
        collect.forEach(arr -> {
            System.out.print("[");
            for (int i = 0; i < arr.length; i++) {
                if (i != arr.length - 1){
                    System.out.print(arr[i] + ",");
                }else {
                    System.out.print(arr[i] + "]");
                }
            }
        });
    }
}
