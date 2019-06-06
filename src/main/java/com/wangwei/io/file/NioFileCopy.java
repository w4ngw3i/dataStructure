package main.java.com.wangwei.io.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * @auther wangwei
 * @date 2019-06-06 13:53
 */
public class NioFileCopy {
    public static void main(String[] args) {
        try(FileChannel source = new FileInputStream("count.ini").getChannel();
            FileChannel dest = new FileOutputStream("nio.txt").getChannel()
        ) {
            for (long count = source.size(); count>0;){
                long transfer = source.transferTo(source.position(), count, dest);
                count -= transfer;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
