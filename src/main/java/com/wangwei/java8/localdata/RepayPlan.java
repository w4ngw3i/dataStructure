package com.wangwei.java8.localdata;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

/**
 * @author: wangwei
 * @date: 2019-08-22 16:54
 */
public class RepayPlan {
    public static void main(String[] args) {
        int currentDay = LocalDate.now().getDayOfMonth();
        LocalDate date = LocalDate.of(2019, 8, 29);
        currentDay = date.getDayOfMonth();
        for (int i = 1; i <= 12; i++) {
            if (currentDay > 28){
                /*获取下月的最后一天*/
//                int dayOfMonth = LocalDate.now().plusMonths(i).with(TemporalAdjusters.lastDayOfMonth()).getDayOfMonth();
                int dayOfMonth = date.plusMonths(i).with(TemporalAdjusters.lastDayOfMonth()).getDayOfMonth();
                switch (currentDay){
                    case 29:
                        if (dayOfMonth >= 29){
//                            System.out.println(LocalDate.now().plusMonths(i).format(DateTimeFormatter.ISO_LOCAL_DATE));
                            System.out.println(date.plusMonths(i).format(DateTimeFormatter.ISO_LOCAL_DATE));
                        }else {
//                            System.out.println(LocalDate.now().plusMonths(i).with(TemporalAdjusters.lastDayOfMonth()).format(DateTimeFormatter.ISO_LOCAL_DATE));
                            System.out.println(date.plusMonths(i).with(TemporalAdjusters.lastDayOfMonth()).format(DateTimeFormatter.ISO_LOCAL_DATE));
                        }
                        break;
                    case 30:
                        if (dayOfMonth >= 30){
//                            System.out.println(LocalDate.now().plusMonths(i).format(DateTimeFormatter.ISO_LOCAL_DATE));
                            System.out.println(date.plusMonths(i).format(DateTimeFormatter.ISO_LOCAL_DATE));
                        }else {
//                            System.out.println(LocalDate.now().plusMonths(i).with(TemporalAdjusters.lastDayOfMonth()).format(DateTimeFormatter.ISO_LOCAL_DATE));
                            System.out.println(date.plusMonths(i).with(TemporalAdjusters.lastDayOfMonth()).format(DateTimeFormatter.ISO_LOCAL_DATE));
                        }
                        break;
                    case 31:
                        if (dayOfMonth == 31){
//                            System.out.println(LocalDate.now().plusMonths(i).format(DateTimeFormatter.ISO_LOCAL_DATE));
                            System.out.println(date.plusMonths(i).format(DateTimeFormatter.ISO_LOCAL_DATE));
                        }else {
//                            System.out.println(LocalDate.now().plusMonths(i).with(TemporalAdjusters.lastDayOfMonth()).format(DateTimeFormatter.ISO_LOCAL_DATE));
                            System.out.println(date.plusMonths(i).with(TemporalAdjusters.lastDayOfMonth()).format(DateTimeFormatter.ISO_LOCAL_DATE));
                        }
                        break;
                    default:
                        break;
                }
            }else {
                System.out.println(LocalDate.now().plusMonths(i).format(DateTimeFormatter.ISO_LOCAL_DATE));
            }
        }
    }
}
