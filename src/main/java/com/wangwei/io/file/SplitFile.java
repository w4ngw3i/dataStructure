package com.wangwei.io.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * @auther wangwei
 * @date 2019-06-02 18:41
 */
public class SplitFile {
    public static void main(String[] args) throws Exception {
        splitFile();

    }


    public static void merge(){

    }


    public static void splitFile() throws Exception{
        FileInputStream fis = new FileInputStream("/Users/wangwei/Downloads/chrome/Surface+Stusio+default+wallpaper.png");

        FileOutputStream fos = null;

       byte[] buf = new byte[1024 * 1024];

        int len = 0;

        int count = 1;

        while ((len = fis.read(buf)) != -1){
            fos = new FileOutputStream("/Users/wangwei/opt/test/spiltfiles/" + (count++) + ".part");
            fos.write(buf, 0, len);
            fos.close();
        }

    }
}
