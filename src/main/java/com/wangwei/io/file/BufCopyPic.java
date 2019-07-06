package com.wangwei.io.file;

import java.io.*;

/**
 * @author: wangwei
 * @date: 2019-07-06 23:53
 */
public class BufCopyPic {
    public static void main(String[] args) throws Exception {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("/Users/wangwei/Pictures/WechatIMG76.jpeg"));

        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("/Users/wangwei/Pictures/bufcopy.jpeg"));

        int len = 0;

        while ((len = bis.read()) != -1){
            bos.write(len);
        }

        System.out.println("success");

    }
}
