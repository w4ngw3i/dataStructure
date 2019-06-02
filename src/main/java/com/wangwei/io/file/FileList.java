package com.wangwei.io.file;

import java.io.File;

/**
 * @auther wangwei
 * @date 2019-06-02 16:57
 */
public class FileList {
    public static void main(String[] args) {
        File[] files = File.listRoots();

        for (File file : files) {
            System.out.println(file);
        }

        File file = new File("/Users/wangwei/opt");

        String[] list = file.list();

        for (String s : list) {
            System.out.println(s);
        }
    }
}
