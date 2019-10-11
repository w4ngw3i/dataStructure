package com.wangwei.java8.localdata;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;

/**
 * @auther wangwei
 * @date 2019-05-31 11:31
 */
public class LocalTimeDemo {
    public static void main(String[] args) {

        LocalTime parse = LocalTime.parse("12:00:0");

        String format = parse.format(DateTimeFormatter.ISO_LOCAL_DATE);

        System.out.println(format);


        LocalTime time = LocalTime.of(12, 04, 8);

        System.out.println(time.getLong(ChronoField.HOUR_OF_DAY));

        System.out.println(time.getSecond());
    }
}
