package com.wangwei.java8.localdata;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;

/**
 * @auther wangwei
 * @date 2019-05-31 11:27
 */
public class Demo2 {
    public static void main(String[] args) {
        //LocalDate date = LocalDate.now();
        //String date1 = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
        //System.out.println("date1: " + date1);
        //String date2 = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        //System.out.println("date2: " + date2);
        //System.out.println(date2.replaceAll("-", "").replaceAll(" ", "").replaceAll(":", ""));
        //
        //System.out.println("year:" + date.get(ChronoField.YEAR));
        //
        //System.out.println(date.get(ChronoField.DAY_OF_YEAR));
        //
        //System.out.println(date.get(ChronoField.DAY_OF_WEEK));

        String dateStr = "20181130";
        DateTimeFormatter yyyymmdd = DateTimeFormatter.ofPattern("yyyymmdd");
        LocalDate parse = LocalDate.parse(dateStr, yyyymmdd);
        ZoneId zone = ZoneId.systemDefault();
        //parse.zone
        System.out.println(parse.getYear());

    }
}
