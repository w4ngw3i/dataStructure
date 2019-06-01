package com.wangwei.java8.localdata;

import java.time.LocalDate;
import java.time.Month;

/**
 * @auther wangwei
 * @date 2019-05-31 11:19
 */
public class Demo {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2019, 12, 4);

        int year = date.getYear();

        System.out.println("year:"+ year);

        System.out.println("这个月的第几天:" + date.getDayOfMonth());

        System.out.println("一年的第几天:" + date.getDayOfYear());

        int monthValue = date.getMonthValue();

        System.out.println("monthValue:"+monthValue);

        Month month = date.getMonth();

        int value = month.getValue();

        System.out.println("value:"+value);

        boolean leapYear = date.isLeapYear();

        System.out.println("leapYear:" + leapYear);

    }
}
