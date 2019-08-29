package com.wangwei.java8.lambda;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalField;
import java.util.Date;

/**
 * @auther wangwei
 * @date 2019-06-11 15:25
 */
public class InstantDemo {
    public static void main(String[] args) {

        System.out.println(new BigDecimal(16).setScale(2));
        System.out.println(BigDecimal.ZERO);
        System.out.println(new BigDecimal(192.77).setScale(2, BigDecimal.ROUND_DOWN));

        System.out.println(LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE));

        System.out.println(LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE));

        System.out.println("------------------还款计划-----------");
        for (int i = 1; i <= 12; i++) {
//            int day = LocalDate.now().getDayOfMonth();
            LocalDate date = LocalDate.of(2019, 8, 29);
            int day = date.getDayOfMonth();
            if (day > 28) {
                    switch (day){
                        case 29:
                            int dayOfMonth = date.plusMonths(i).with(TemporalAdjusters.lastDayOfMonth()).getDayOfMonth();
                            if (dayOfMonth >= 29){
                                System.out.println(date.plusMonths(i).format(DateTimeFormatter.ISO_LOCAL_DATE));
                            }else {
                                System.out.println(date.plusMonths(i).with(TemporalAdjusters.lastDayOfMonth()).format(DateTimeFormatter.ISO_LOCAL_DATE));
                            }
                            dateCheck(date, 29, i);
                            break;
                        case 30:
                            dateCheck(date, 30, i);
                            break;
                        case 31:
                            dateCheck(date, 31, i);
                            break;
                        default:
                            break;
                    }
//                System.out.println(LocalDate.now().plusMonths(i).withDayOfMonth(28).format(DateTimeFormatter.ISO_LOCAL_DATE));
//                System.out.println(LocalDate.now().plusMonths(i).with(TemporalAdjusters.lastDayOfMonth()).format(DateTimeFormatter.ISO_LOCAL_DATE));
//                System.out.println(date.plusMonths(i).with(TemporalAdjusters.lastDayOfMonth()).format(DateTimeFormatter.ISO_LOCAL_DATE));
            }else {
//                System.out.println(LocalDate.now().plusMonths(i).format(DateTimeFormatter.ISO_LOCAL_DATE));
                System.out.println(date.plusMonths(i).format(DateTimeFormatter.ISO_LOCAL_DATE));
            }
        }

        Instant now = Instant.now();
        System.out.println(now.atZone(ZoneId.systemDefault()));

        Date date = new Date();

        System.out.println(date.toString());


    }

    public static void dateCheck(LocalDate date, int day, int i){
        int dayOfMonth = date.plusMonths(i).with(TemporalAdjusters.lastDayOfMonth()).getDayOfMonth();
        if (dayOfMonth >= day){
            System.out.println(date.plusMonths(i).format(DateTimeFormatter.ISO_LOCAL_DATE));
        }else {
            System.out.println(date.plusMonths(i).with(TemporalAdjusters.lastDayOfMonth()).format(DateTimeFormatter.ISO_LOCAL_DATE));
        }
    }
}
