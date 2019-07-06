package com.wangwei.io.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * @author: wangwei
 * @date: 2019-07-06 23:32
 */
public class CopyPic {
    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream("/Users/wangwei/Pictures/WechatIMG76.jpeg");

        FileOutputStream fos = new FileOutputStream("/Users/wangwei/Pictures/copy.jpeg");

        byte[] buf = new byte[1024];

        int len = 0;

        while ((len = fis.read(buf)) != -1){
            fos.write(buf, 0, len);
        }


        System.out.println("success");
    }
}
