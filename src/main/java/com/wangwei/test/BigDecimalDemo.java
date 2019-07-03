package com.wangwei.test;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: wangwei
 * @date: 2019-06-25 11:03
 */
public class BigDecimalDemo {
    public static void main(String[] args) {
        String x = "0.0";
        String y = "0.1";
        System.out.println(new BigDecimal(x).compareTo(new BigDecimal(y)));

        AtomicInteger atomicInteger = new AtomicInteger();


        System.out.println(atomicInteger.get());


        AtomicInteger count = new AtomicInteger();

        System.out.println(count);

        for (int i = 0; i < 5; i++) {
            count.getAndIncrement();
        }
        System.out.println(count);

        System.out.println(count.get()+1);
    }
}
