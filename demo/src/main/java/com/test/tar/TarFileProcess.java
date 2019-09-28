package com.test.tar;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorInputStream;

import java.io.*;
import java.nio.channels.FileChannel;
import java.util.zip.GZIPInputStream;

/**
 * @author: wangwei
 * @date: 2019-09-20 17:55
 */
@Slf4j
public class TarFileProcess {
    public static void main(String[] args)throws Exception {

        String sourcePath = "/Users/wangwei/opt/tmp/local/asset/JD/main/20190926/02-en.tar.gz";
        File file = new File(sourcePath);
//        String sourcePath = "/Users/wangwei/opt/test/tar/UnEncrypt_JT20190613.tar.gz";
        String targetPath = "/Users/wangwei/opt/tmp/local/asset/JD/main/20190926/02";
        File target = new File(targetPath);
        unTarGz(file, target);
//        extractTarGZ(new File(sourcePath), new File(targetPath));
    }


    private static void unTarGz(File file, File targetPath)throws Exception{
        try(
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);
            GzipCompressorInputStream gzipIn = new GzipCompressorInputStream(bis);
            TarArchiveInputStream tarIn = new TarArchiveInputStream(gzipIn)
        ){
            TarArchiveEntry entry;
            while ((entry = tarIn.getNextTarEntry()) != null){
                File target = new File(targetPath, entry.getName());
                if (entry.isDirectory()) {
                    target.mkdirs();
                }else{
                    target.getParentFile().mkdirs();
                    int length;
                    byte[] buffer = new byte[4096];
                    try (FileOutputStream fos = new FileOutputStream(target);
                         BufferedOutputStream bos = new BufferedOutputStream(fos)
                    ) {
                        while ((length = tarIn.read(buffer)) != -1) {
                            bos.write(buffer, 0, length);
                        }
                    }
                }
            }
        }
    }

    /**
     * 构建目录
     * @param outputDir
     * @param subDir
     */
    public static void createDirectory(String outputDir,String subDir){
        File file = new File(outputDir);
        if(!(subDir == null || subDir.trim().equals(""))){//子目录不为空
            file = new File(outputDir + "/" + subDir);
        }
        if(!file.exists()){
            if(!file.getParentFile().exists()){
                boolean isParentSuccess = file.getParentFile().mkdirs();
                if (isParentSuccess)
                    log.info("============ From unTarGz createDirectory create successs!!! ============");
            }
            boolean isSubDir = file.mkdirs();
            if (isSubDir){ log.info("============ From unTarGz createDirectory create successs!!! ============");            }
        }
    }

}
