package com.wangwei.java8.localdata;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @auther wangwei
 * @date 2019-05-31 11:36
 */
public class LocalDateTimeDemo {
    public static void main(String[] args) {
        LocalDateTime of = LocalDateTime.of(LocalDate.now(), LocalTime.now());

        LocalDateTime now = LocalDateTime.now();

        System.out.println(of.getHour());
    }
}
