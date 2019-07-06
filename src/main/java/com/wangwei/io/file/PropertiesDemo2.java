package com.wangwei.io.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author: wangwei
 * @date: 2019-07-07 00:26
 */
public class PropertiesDemo2 {
    public static void main(String[] args) throws IOException {
        System.out.println(System.getProperties());

        Properties properties = new Properties();
        File file = new File("count.properties");
        if (!file.exists())
            file.createNewFile();
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getCanonicalPath());
        FileInputStream fis = new FileInputStream(file);
        properties.load(fis);
        String value = properties.getProperty("time");
        int count = 0;
        if (value != null){
            count = Integer.parseInt(value);
            if (count >= 5){
                System.out.println("您好！试用时间一到，如果想继续试用请付费。");
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
