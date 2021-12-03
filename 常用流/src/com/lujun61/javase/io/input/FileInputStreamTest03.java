package com.lujun61.javase.io.input;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* 文件拷贝 */
public class FileInputStreamTest03 {
    public static void main(String[] args) {
        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            //读取的文件对象
            in = new FileInputStream("常用流\\src\\com\\lujun61\\javase\\io\\input\\FileInputStreamTest02.java");

            //拷贝被读取文件
            out = new FileOutputStream("常用流\\src\\com\\lujun61\\javase\\io\\input\\test.txt", true);

            //核心步骤：一边读，一边写
            byte[] bytes = new byte[1024 * 1024];//容量为1MB的数组

            int readCount = 0;
            while ((readCount = in.read(bytes)) != -1) {
                out.write(bytes, 0, readCount);//读到多少，就打印多少

                System.out.println(new String(bytes, 0, readCount));//在控制台上打印
            }

            out.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

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
