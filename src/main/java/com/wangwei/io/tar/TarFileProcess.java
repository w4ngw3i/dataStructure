package com.wangwei.io.tar;

import org.apache.tools.tar.TarEntry;
import org.apache.tools.tar.TarInputStream;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.GZIPInputStream;

/**
 * @author: wangwei
 * @date: 2019-09-20 17:55
 */
public class TarFileProcess {
    public static void main(String[] args) {

        String sourcePath = "/Users/wangwei/opt/test/java/UnEncrypt_JT20190613.tar.gz";
        String targetPath = "/Users/wangwei/opt/test/java/UnEncrypt_JT20190613";
        unGizFile(sourcePath, targetPath);
    }

    public static void unGizFile(String sourcePath, String targetPath){
        String name = sourcePath.substring(sourcePath.lastIndexOf("/") + 1);
        String tarName = targetPath + name.substring(0,name.lastIndexOf("."));
        try(GZIPInputStream inputStream = new GZIPInputStream(new FileInputStream(new File(sourcePath)));
            BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(new File(tarName)))){
            byte[] buffer = new byte[1024];
            int len;
            while((len = inputStream.read(buffer)) > 0){
                outputStream.write(buffer,0,len);
            }
            outputStream.flush();
            unTarFile(tarName,targetPath);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void unTarFile( String sourcePath,String targetPath){
        File targetFile = new File(targetPath);
        // 如果目录不存在，则创建
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        try(TarInputStream tarInputStream = new TarInputStream(new FileInputStream(new File(sourcePath)))){
            TarEntry entry = null;
            while ((entry = tarInputStream.getNextEntry()) != null){
                if(entry.isDirectory()){
                    continue;
                }
                String name = targetPath + "/" + entry.getName();
                // 需要判断文件所在的目录是否存在，处理压缩包里面有文件夹的情况
                File tempFile = new File(name.substring(0,name.lastIndexOf("/")));
                if (!tempFile.exists()){
                    tempFile.mkdirs();
                }
                try (BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(new File(name)))){
                    int len;
                    byte[] buffer = new byte[1024];
                    while((len = tarInputStream.read(buffer)) > 0){
                        outputStream.write(buffer,0,len);
                    }
                }

            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
