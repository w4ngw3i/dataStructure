package com.wangwei.java8.localdata;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author: wangwei
 * @date: 2019-09-08 11:59
 */
public class LocalDateTime2Date {
    public static void main(String[] args) {
 /*       LocalDateTime now = LocalDateTime.now();

        System.out.println(now.toString());

        ZoneId zoneId = ZoneId.systemDefault();

        ZonedDateTime zonedDateTime = now.atZone(zoneId);

        Date date = Date.from(zonedDateTime.toInstant());

        System.out.println(date.toString());

        new LocalDateTime2Date().date2LocalDate(new Date());*/
       /* String dateStr = LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(dateConverter(dateStr)); //19700101
*/
       String dateStr = "20181130";

        String year = dateStr.substring(0, 4);

        String month = dateStr.substring(4, 6);

        String day = dateStr.substring(6, 8);

        LocalDate date = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));

        System.out.println(date.minusDays(1).format(DateTimeFormatter.BASIC_ISO_DATE));





       /* long aLong = Long.parseLong(dateStr);
        Date date = new Date(aLong);
        LocalDate parse = LocalDate.parse(dateStr);*/
//        System.out.println(parse.toString());

    }

    public void date2LocalDate(Date date){

        Instant instant = date.toInstant();//An instantaneous point on the time-line.(时间线上的一个瞬时点。)
        ZoneId zoneId = ZoneId.systemDefault();//A time-zone ID, such as {@code Europe/Paris}.(时区)
        LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();

        System.out.println(localDateTime.toString());//2018-03-27T14:07:32.668
        System.out.println(localDateTime.toLocalDate() + " " +localDateTime.toLocalTime());//2018-03-27 14:48:57.453

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");//This class is immutable and thread-safe.@since 1.8

        System.out.println(dateTimeFormatter.format(localDateTime));

    }

    private Date localDate2Date(LocalDateTime localDate) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = dateTimeFormatter.format(localDate);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return simpleDateFormat.parse(format);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String dateConverter(String dateStr){

        long of = Long.valueOf(dateStr);

        Date date = new Date(of);

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd ");

       return format.format(date);
    }
}