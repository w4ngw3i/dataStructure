package com.wangwei.io;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @auther wangwei
 * @date 2019-06-02 15:06
 */
public class IOLog {
    public static void main(String[] args) throws FileNotFoundException {

        try {
            int[] arr = new int[2];
            System.out.println(arr[3]);
        }catch (Exception e){
//            e.printStackTrace();
//            e.printStackTrace(new PrintStream("exception.txt"));

            String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

            PrintStream ps = new PrintStream("exception.log");
            ps.println(date);

            System.setOut(ps);
            e.printStackTrace(System.out);
        }
    }
}
