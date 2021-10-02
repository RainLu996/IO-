package com.lujun61.javase.io.input;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* read(byte[] b);方法——————>返回读取到的字节数量，而不是字节本身 */
/* 未读取到数据（数据读取完毕）则返回“-1” */
public class FileInputStreamTest02 {
    public static void main(String[] args) {
        FileInputStream file = null;

        try {
            file = new FileInputStream("temp");

            //采用byte数组，一次读取多个字节。最多读取："数组.length"个字节
            byte[] bytes = new byte[4];//准备一个四个长度的byte数组，一次最多读取4个字节

            //read(byte[] b)：返回读取到的字节数量，而不是字节本身
            int readCount = 0;
            while ((readCount = file.read(bytes)) != -1) {
                System.out.print(new String(bytes, 0, readCount));
            }

            System.out.println(readCount);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
