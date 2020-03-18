package com.wangwei.io.file;

import java.io.File;
import java.util.*;

/**
 * @Author wangwei
 * @Date 2020/3/6 10:12 上午
 * @Version 1.0
 */
public class FileList5 {
    public static void main(String[] args) {
        File imgPath = new File("/Users/wangwei/credit");
        if (!imgPath.exists() && !imgPath.isDirectory()) {
            System.out.println("度小满 用信 影像件 初始化异常，未查到对应的目录！");
            return;
        }
        Map<String, File> jpgMap = new HashMap<>();
        imgByCredit(jpgMap, imgPath);
        Set<String> set = jpgMap.keySet();
        Set<Map.Entry<String, File>> entries = jpgMap.entrySet();
        Iterator<Map.Entry<String, File>> iterator = entries.iterator();
        while (iterator.hasNext()){
            Map.Entry<String, File> fileEntry = iterator.next();
            System.out.println(fileEntry.getKey() + ":" + fileEntry.getValue());
        }
    }

    private static void imgByCredit(Map<String, File> imgMap, File path){
        File[] listFiles = path.listFiles();
        if (Objects.isNull(listFiles)) {
            return;
        }
        for (File file : listFiles) {
            if (file.isDirectory()) {
                imgByCredit(imgMap, file);
            }
            String fileName = file.getName();
            if (!fileName.startsWith(".") && (fileName.toLowerCase().endsWith(".jpg"))) {
                imgMap.put(fileName, file);
            }
        }
    }
}
