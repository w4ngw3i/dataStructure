package com.wangwei.java8.localdata;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

/**
 * @Author wangwei
 * @Date 2020/4/21 2:11 下午
 * @Version 1.0
 */
public class Demo3 {
    public static void main(String[] args) {
        // 获取上个月的最后一天
        LocalDate localDate = LocalDate.now().minusMonths(1).with(TemporalAdjusters.lastDayOfMonth());
        String date = localDate.format(DateTimeFormatter.ISO_LOCAL_DATE);

        LocalDate localDate1 = LocalDate.now().minusMonths(1).withDayOfMonth(21);
        System.out.println(localDate1.format(DateTimeFormatter.ISO_LOCAL_DATE));
        System.out.println(date);

        LocalDate localDate2 = LocalDate.parse("20181113");
        String date2 = localDate2.plusMonths(1).withDayOfMonth(localDate2.getDayOfMonth()).format(DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println("date2 => " + date2);
    }
}
