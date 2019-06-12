package main.java.com.wangwei.java8.localdata;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @auther wangwei
 * @date 2019-06-11 15:25
 */
public class InstantDemo {
    public static void main(String[] args) {

        System.out.println(LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE));

        System.out.println(LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE));

        Instant now = Instant.now();
        System.out.println(now.atZone(ZoneId.systemDefault()));

        Date date = new Date();

        System.out.println(date.toString());


    }
}
