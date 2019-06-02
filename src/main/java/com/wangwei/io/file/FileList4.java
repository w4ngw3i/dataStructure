package com.wangwei.io.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @auther wangwei
 * @date 2019-06-02 17:49
 */
public class FileList4 {

    public static void main(String[] args) {
        File file = new File("/Users/wangwei/Documents");

        List<File> list = new ArrayList<>();

        fileToList(file, list);

        writeToFile(list, "javaListFile.txt");

        list.forEach(file1 -> System.out.println(file1.getName()));
    }


    public static void fileToList(File file, List<File> list){
        File[] files = file.listFiles();

        for (File f : files) {
            if (f.isDirectory())
                fileToList(f, list);
            else{
                if (f.getName().endsWith(".java"))
                    list.add(f);
            }
        }
    }


    public static void writeToFile(List<File> list, String javaListFile){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(javaListFile));
        ){
            for (File file : list) {
                String path = file.getAbsolutePath();
                bw.write(path);
                bw.newLine();
                bw.flush();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
