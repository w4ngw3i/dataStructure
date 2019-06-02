package com.wangwei.io.file;

import java.io.*;

/**
 * @auther wangwei
 * @date 2019-06-02 18:30
 */
public class PrintStreamDemo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        PrintWriter pw = new PrintWriter(System.out);

        PrintWriter pw = new PrintWriter(new FileWriter("printStream.txt"), true);

        String line = null;

        while ((line = br.readLine()) != null){
            if (line.equals("over"))
                break;
            pw.println(line.toUpperCase());
//            pw.flush();
        }
    }
}
