package com.wangwei.io.file;

import java.io.*;
import java.util.Properties;

/**
 * @auther wangwei
 * @date 2019-06-02 18:09
 */
public class PropertiesDemo {
    public static void main(String[] args) throws Exception {
//
//        try(BufferedWriter bw = new BufferedWriter(new FileWriter("properties.txt"))){
//            for (int i = 0; i < 5; i++) {
//                bw.write("name="+"wangwei"+i);
//                bw.newLine();
//                bw.flush();
//            }
//        }

        Properties p = new Properties();
        p.load(new FileInputStream(new File("properties.txt")));

        p.list(System.out);
    }
}
