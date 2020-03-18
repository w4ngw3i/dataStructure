package com.wangwei.io.file;

import java.io.File;
import java.io.IOException;

/**
 * @auther wangwei
 * @date 2019-06-02 15:31
 */
public class FileDmeo {
    public static void main(String[] args) throws IOException {
        /**
         * file创建的三种方式
         * 将ile1.txt封装成file对象
         */
        File f1 = new File("file1.txt");

        /***创建文件：如果没有则创建，有则不创建 */
        boolean newFile = f1.createNewFile();
        System.out.println("创建文件是否成功:" + newFile);

        File f2 = new File("/Users/wangwei/opt/java/gitHub/dataStructure", "file2.txt");
        System.out.println("AbsolutePath: " + f2.getAbsolutePath());
        String parent = f2.getParent();
        System.out.println(parent);
        System.out.println("path: " + f2.getPath());

        File dir = new File(File.separator + "Users"+ File.separator+"wangwei" + File.separator + "opt"+ File.separator +"java"+ File.separator +"gitHub" +File.separator+ "dataStructure");

        File f3 = new File(dir, "file3.txt");

        System.out.println("f1: " +f1);
        System.out.println("f2: " +f2);
        System.out.println("f3: " +f3);
    }
}
