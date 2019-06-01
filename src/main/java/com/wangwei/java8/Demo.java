package com.wangwei.java8;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalField;
import java.util.Calendar;
import java.util.Date;

/**
 * @auther wangwei
 * @date 2019-05-31 15:31
 */
public class Demo {
    public static String getDateYMD() {
        return LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE);
    }

    public static String getDateY_M_D() {
        return LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    public static String getTime() {
        return LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

    public static String getDateTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }


    public static void main(String[] args) {

        Date date = new Date();

        Instant instant = date.toInstant();

        ZoneId zoneId = ZoneId.systemDefault();

        System.out.println(LocalDateTime.ofInstant(instant, zoneId).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

//        Date date1 = new Date();
//
//        LocalDate d = LocalDate.now();
//
//        System.out.println(LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE));
//        System.out.println(LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE));
//
//        System.out.println(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
//
//        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
//
//        System.out.println(d.toString());
//
//        LocalDate with = d.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
//        LocalDate with2 = d.with(TemporalAdjusters.firstDayOfNextYear());
//
//        System.out.println(with2.toString());
//
//        System.out.println(with.toString());

        System.out.println(getDateTime());

        System.out.println(getDateY_M_D());

        System.out.println(getDateYMD());

        System.out.println(getTime());


    }

}


