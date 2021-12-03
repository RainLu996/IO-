package com.lujun61.javase.io.output;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest01 {
    public static void main(String[] args) {
        FileOutputStream out = null;
        try {
            /**
             * append参数比较
             */
            /* 1、先清空文档，再写入数据
            out = new FileOutputStream("outputTest");
            */

            /* 2、直接在文档末尾追加数据 */
            out = new FileOutputStream("outputTest", true);

            byte[] bytes = {97, 98, 99};
            out.write(bytes);//将byte数组全部写入文件中
            out.write(bytes, 0, 2);//将byte数组的一部分写入文件中


            //若要写入字符串，则要将字符串转换为byte数组
            String s = "LJ yyds!";
            byte[] exchange = s.getBytes();
            out.write(exchange);

            out.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
