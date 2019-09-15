package com.wangwei.java8.timer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Timer;

/**
 * @author: wangwei
 * @date: 2019-09-08 11:02
 */
public class MyTimer {
    public static void main(String[] args) throws ParseException {
        Timer timer = new Timer();

        MyTimerTask task = new MyTimerTask("Demo1");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(dateTimeFormatter.format(LocalDateTime.now()));
        System.out.println();

//        timer.schedule(task, 5000, 2000);

        String format = dateTimeFormatter.format(LocalDateTime.now().plusMinutes(1));

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date date = simpleDateFormat.parse(format);

//        timer.scheduleAtFixedRate(task, date, 2000);
        timer.schedule(task, 3000);

        timer.cancel();

        System.out.println("scheduledExecutionTime :"+simpleDateFormat.format(task.scheduledExecutionTime()));
    }
}
