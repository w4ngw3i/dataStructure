package com.wangwei.io.file;

import java.nio.charset.StandardCharsets;

import static java.nio.charset.StandardCharsets.*;

/**
 * @Author wangwei
 * @Date 2020/2/18 7:53 下午
 * @Version 1.0
 */
public class EncodeDemo {
    public static void main(String[] args)throws Exception {
        String s = "王伟ABC";
        // gbk编码中文占用两个字节， 英文一个字节
        byte[] bytes = s.getBytes("gbk");// 转换成字节序列用的是项目默认的编码utf-8
        for (byte b : bytes) {
            // 把字节以16进制的方式显示
            System.out.print(Integer.toHexString(b & 0xff)+" ");
        }

        System.out.println();

        byte[] bytes2 = s.getBytes(UTF_8);// 转换成字节序列用的是项目默认的编码utf-8
        for (byte b : bytes2) {
            // 把字节以16进制的方式显示
            System.out.print(Integer.toHexString(b & 0xff)+" ");
        }

        System.out.println();
        // UTF_16BE java是双字节编码 中文2个字节 英文两个字节
        byte[] b4 = s.getBytes(UTF_16BE);
        for (byte b : b4) {
            System.out.print(Integer.toHexString(b & 0xff)+" ");
        }

        /**
         * 当你的字节序列是某种编码时，这个时候想把字节转换成字符串
         * 也需要用这样的编码方式 否则会出现乱码
         */
        System.out.println(new String(b4, StandardCharsets.UTF_16BE));
    }
}
