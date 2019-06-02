package com.wangwei.io;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Properties;

/**
 * @auther wangwei
 * @date 2019-06-02 15:22
 */
public class PropertiesDemo {
    public static void main(String[] args) throws FileNotFoundException {
        Properties properties = System.getProperties();

//        System.out.println(properties);

        properties.list(new PrintStream("sysinfo.txt"));
    }

}
