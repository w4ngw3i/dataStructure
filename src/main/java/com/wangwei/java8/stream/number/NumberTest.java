package com.wangwei.java8.stream.number;

import java.util.stream.IntStream;

/**
 * @auther wangwei
 * @date 2019-05-21 16:46
 */
public class NumberTest {

    public static void main(String[] args) {
        long count = IntStream.rangeClosed(1, 100).filter(i -> i%2==0).count();
        System.out.println(count);
    }
}
