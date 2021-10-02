package com.lujun61.javase.io.reader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {
    public static void main(String[] args) {
        FileReader reader = null;

        try {
            reader = new FileReader("常用流\\src\\com\\lujun61\\javase\\io\\input\\FileInputStreamTest02.java");

           //FileReader中，需要创建一个char数组来读取文档内容
            char[] c = new char[100];

            int readCount= 0;
            while ((readCount = reader.read(c)) != -1) {
                System.out.println(new String(c, 0, readCount));//打印信息于控制台上
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
