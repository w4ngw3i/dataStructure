package com.wangwei.java8.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @auther wangwei
 * @date 2019-05-30 14:01
 */
public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Shop shop = new Shop("xuebing");

        long start = System.nanoTime();



        System.out.println(String.format("start:%d, start(seconds):%d",start ,TimeUnit.NANOSECONDS.toSeconds(start)));

        Future<Double> future = shop.getPriceAsync("apple");


        long invocationTime= System.nanoTime() - start;


        System.out.println(TimeUnit.NANOSECONDS.toSeconds(invocationTime));


    }
}
