package com.wangwei.java8.localdata;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;

/**
 * @auther wangwei
 * @date 2019-05-31 11:27
 */
public class Demo2 {
    public static void main(String[] args) {/*
        LocalDate date = LocalDate.now();
        String date2 = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(date2);
        System.out.println(date2.replaceAll("-", "").replaceAll(" ", "").replaceAll(":", ""));

        System.out.println("year:" + date.get(ChronoField.YEAR));

        System.out.println(date.get(ChronoField.DAY_OF_YEAR));



        System.out.println(date.get(ChronoField.DAY_OF_WEEK));

        System.out.println(date.get(ChronoField.HOUR_OF_DAY));*/
        BigDecimal amt = new BigDecimal("900000").divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_UP);
        System.out.println(amt);
        System.out.println(amt.multiply(new BigDecimal("100")).setScale(0, BigDecimal.ROUND_DOWN).toString());
    }
}
