package com.wangwei.java8.stream.test;

import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @Author wangwei
 * @Date 2020/5/7 2:30 下午
 * @Version 1.0
 */
public class ParalleDemo {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        System.out.println(rangedSUm(10000000));
        long endTime = System.nanoTime();
        System.out.println("非并行执行时间 -> " + (endTime - startTime));
        long startTime1 = System.nanoTime();
        System.out.println(parallelRangedSUm(10000000));
        long endTime1 = System.nanoTime();
        System.out.println("并行执行时间 -> " + (endTime1 - startTime1));
    }

    public static long rangedSUm(long n){
        return LongStream.rangeClosed(1, n)
                .reduce(0L, Long::sum);
    }

    public static long parallelRangedSUm(long n){
        return LongStream.rangeClosed(1, n)
                .parallel()
                .reduce(0L, Long::sum);
    }
}
