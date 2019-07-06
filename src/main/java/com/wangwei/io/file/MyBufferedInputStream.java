package com.wangwei.io.file;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author: wangwei
 * @date: 2019-07-06 23:59
 */
public class MyBufferedInputStream {

    private InputStream inputStream;

    private byte[] buf = new byte[1024];

    private int pos = 0, count = 0;

    MyBufferedInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public int myRead() throws IOException {
        if (count == 0){

            count = inputStream.read(buf);

            if (count < 0)
                return -1;

            pos = 0;

            byte  b = buf[pos];

            count--;

            pos++;

            return b;
        }else if (count > 0){
            byte  b = buf[pos];

            count--;

            pos++;

            return b;
        }

        return -1;
    }

    public void myClose() throws IOException {
        inputStream.close();
    }
}
