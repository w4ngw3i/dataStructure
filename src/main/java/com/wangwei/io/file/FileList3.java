package com.wangwei.io.file;

import java.io.File;

/**
 * @auther wangwei
 * @date 2019-06-02 17:18
 */
public class FileList3 {
    public static void main(String[] args) {

        File file = new File("/Users/wangwei/Documents");

        showDir(file, 0);

    }


    public static void  showDir(File dir, int depth){

        System.out.println(generateDepthString(depth)+dir.getName());

        depth++;


        File[] files = dir.listFiles();

        for (int i = 0; i < files.length; i++) {
            if (!files[i].isHidden() && files[i].isDirectory())
                showDir(files[i], depth);
            System.out.println(generateDepthString(depth)+files[i]);
        }
    }


    public static String generateDepthString(int depth){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            builder.append("--");
        }

        return builder.toString();
    }
}
