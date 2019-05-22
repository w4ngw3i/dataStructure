package com.wangwei.java8.stream.functionstream;

import java.util.stream.Stream;

/**
 * @auther wangwei
 * @date 2019-05-21 17:03
 */
public class FSDemo {

    public static void main(String[] args) {
        Stream.iterate(0, n -> n+2)
                .limit(50)
                .forEach(System.out::println);

        /**
         * 斐波纳契数列是著名的经典编程练习。下面这个数列就是斐波纳契数列的一部分:0, 1, 1,
         * 2, 3, 5, 8, 13, 21, 34, 55...数列中开始的两个数字是0和1，后续的每个数字都是前两个数字之和。
         * 斐波纳契元组序列与此类似，是数列中数字和其后续数字组成的元组构成的序列:(0, 1),
         * (1, 1), (1, 2), (2, 3), (3, 5), (5, 8), (8, 13), (13, 21) ...
         */

        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0]+t[1]})
                .limit(20)
                .map(t -> t[0])
                .forEach(System.out::println);
    }



}
