package com.wangwei.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

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

            List<String> list = new ArrayList<>();

            while ((line = bufr.readLine()) != null){
                 list.add(line);
            }

            list.remove(0);
            for (String s : list) {
                System.out.println(s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
