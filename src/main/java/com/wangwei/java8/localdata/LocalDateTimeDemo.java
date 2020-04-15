package com.wangwei.java8.localdata;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @auther wangwei
 * @date 2019-05-31 11:36
 */
public class LocalDateTimeDemo {
    public static void main(String[] args) {

        int i = Integer.parseInt("0");
        System.out.println(i);
        LocalDateTime of = LocalDateTime.of(LocalDate.now(), LocalTime.now());

        LocalDateTime now = LocalDateTime.now();

        System.out.println(of.getHour());

        System.out.println(LocalDate.now().minusDays(1).format(DateTimeFormatter.BASIC_ISO_DATE));
    }
}
