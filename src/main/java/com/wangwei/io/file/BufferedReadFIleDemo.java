package com.wangwei.io.file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: wangwei
 * @date: 2019-07-15 15:12
 */
public class BufferedReadFIleDemo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("lpqd_require_20190704.txt")));

        String line = "";

        List<String> list = new ArrayList<>();

        while ((line = br.readLine()) != null) {
            list.add(line);
        }

        if (list.size() > 0){
            list.remove(0);
            for (String s : list) {
                String[] fields = s.split(",");
                System.out.println(fields[20]);
            }
        }
    }
}
