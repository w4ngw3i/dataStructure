package com.wangwei.io;

import java.io.*;

/**
 * @auther wangwei
 * @date 2019-06-02 12:23
 */
public class FileTest {
    public static void main(String[] args) {

        try(
            FileWriter fw =new FileWriter("test.txt");
            BufferedWriter bufw = new BufferedWriter(fw);
            FileReader fr = new FileReader("test.txt");
            BufferedReader bufr = new BufferedReader(fr)
            )
        {
            for (int i = 0; i < 8; i++) {
                bufw.write("wangwei"+i);
                bufw.newLine();
                bufw.flush();
            }

            String line = null;

            while ((line = bufr.readLine()) != null){
                System.out.println(line);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
