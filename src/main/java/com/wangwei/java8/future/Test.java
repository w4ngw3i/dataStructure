package com.wangwei.java8.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @auther wangwei
 * @date 2019-05-30 14:01
 */
public class Test {
    public static void main(String[] args){
        Shop shop = new Shop("my favorite product");

        long start = System.nanoTime();


        Future<Double> future = shop.getPriceAsync("apple");


        long invocationTime= ((System.nanoTime() - start) / 1_000_000);


        System.out.println("Invocation returned after " + invocationTime);

        try {
            double price = future.get();
            System.out.printf("Price is %.2f%n", price);
        } catch (Exception e) {
            e.printStackTrace();
        }

        long retrievalTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Price returned after " + retrievalTime + " msecs");
    }
}
