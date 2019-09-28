package com.wangwei.test;

import java.io.File;
import java.util.*;

/**
 * @author: wangwei
 * @date: 2019-09-22 18:01
 */
public class TarFileDemo {
    public static void main(String[] args) {

        String srcPath = "/Users/wangwei/opt/tmp/local/asset/JD/main/download/credit/20190922/untar/";

        String fileName = "012601576728_1.jpg";

        String bankNo = "6259980063518912";

        ArrayList<String> cardBinList = new ArrayList<>();

        System.out.println(fileName.substring(0, fileName.length() - 6));

        String[] s = fileName.split("_");

        for (int i = 12; i > 1; i--) {
            if (i != 6 && i != 3){
                cardBinList.add(bankNo.substring(0, i));
            }
        }

        Map<String, String> cardBinMap = new HashMap<>();
        cardBinMap.put("625998006", "wangwei2");
        cardBinMap.put("62", "wangwei25");
        cardBinMap.put("6259980063", "wangwei52");
        cardBinMap.put("6259", "wangweiwt");
        cardBinMap.put("6259980", "wangweitw");
        cardBinMap.put("625998006351", "wangwei25");
        cardBinMap.put("62599800", "wangwei2");
        cardBinMap.put("62599", "wangwei25");
        cardBinMap.put("62599800635", "wangwei25");

        for (String str : cardBinList) {
            String value = cardBinMap.get(str);
  /*          if (Objects.nonNull(value)){
                break;
            }*/
        }




        System.out.println(s[0]);

        String str = "JD012601576728.pdf";
        System.out.println(str.substring(2, str.length() - 4));


/*
        File file = new File(srcPath);

        List<File> list = new ArrayList<>();

        fileToList(list, file);

        list.forEach(file1 -> System.out.println(file1.getAbsolutePath()));
*/


    }

    private static void fileToList(List<File> list, File file){

        File[] files = file.listFiles();

        for (File f : files) {
            if (f.isDirectory()){
                fileToList(list, f);
            }
            if (f.getName().contains("_1")){
                list.add(f);
            }
        }

    }
}
