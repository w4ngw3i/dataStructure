package com.wangwei.java8.timer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: wangwei
 * @date: 2019-09-08 11:01
 */
public class MyTimerTask extends TimerTask {

    private String taskName;

    private AtomicInteger count = new AtomicInteger(0);

    public MyTimerTask(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        if (count.get() < 3){
            System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

            System.out.println("current run task: " +taskName);

            System.out.println();

            count.getAndIncrement();
        }else {
            cancel();
            System.out.println("task cacel");
        }
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
}
