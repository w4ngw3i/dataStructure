package com.wangwei.io.file;

import java.io.File;
import java.io.FilenameFilter;

/**
 * @auther wangwei
 * @date 2019-06-02 17:12
 */
public class FileList2 {
    public static void main(String[] args) {
        File file = new File("/Users/wangwei/opt/java/gitHub/dataStructure");

//        String[] list = file.list(new FilenameFilter() {
//            @Override
//            public boolean accept(File dir, String name) {
//
//                return name.endsWith(".txt");
//            }
//        });

        String[] list = file.list((dir, name) -> name.endsWith(".txt"));

        for (String s : list) {
            System.out.println(s);
        }


        File[] files = file.listFiles();

        for (File file1 : files) {
            System.out.println("name: " +file1.getName()+" len: " +file1.length());
        }
    }
}
