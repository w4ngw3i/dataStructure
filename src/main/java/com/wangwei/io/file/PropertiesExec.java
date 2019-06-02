package com.wangwei.io.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @auther wangwei
 * @date 2019-06-02 18:18
 */
public class PropertiesExec {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();

        File file = new File("count.ini");
        if (!file.exists())
            file.createNewFile();

        FileInputStream fis = new FileInputStream(file);

        properties.load(fis);

        int count = 0;

        String value = properties.getProperty("time");

        if (value != null){
            count = Integer.parseInt(value);

            if (count >= 3){
                System.out.println("试用次数已达到上限！！！");
                return;
            }
        }

        count++;

        properties.setProperty("time", count+"");

        FileOutputStream fos = new FileOutputStream(file);

        properties.store(fos, "");

        fos.close();

        fis.close();


    }
}
