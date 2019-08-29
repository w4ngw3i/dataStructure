package com.wangwei.java8.localdata;

import java.time.LocalDate;
import java.time.temporal.ChronoField;

/**
 * @auther wangwei
 * @date 2019-05-31 11:27
 */
public class Demo2 {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();


        System.out.println("year:" + date.get(ChronoField.YEAR));

        System.out.println(date.get(ChronoField.DAY_OF_YEAR));


        System.out.println(date.get(ChronoField.DAY_OF_WEEK));

        System.out.println(date.get(ChronoField.HOUR_OF_DAY));
    }
}
