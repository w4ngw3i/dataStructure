package com.wangwei.io.file;

import java.io.File;

/**
 * @auther wangwei
 * @date 2019-06-02 17:18
 */
public class FileList3 {
    public static void main(String[] args) {

        File file = new File("/Users/wangwei/Documents");

        showDir(file);

    }


    public static void  showDir(File dir){

        System.out.println(dir);

        File[] files = dir.listFiles();

        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory())
                showDir(files[i]);
            System.out.println(files[i]);
        }
    }
}
