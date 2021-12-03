package com.lujun61.javase.io.buffer;

import java.io.*;

public class BufferedWriterTest02 {
    public static void main(String[] args) {
        BufferedWriter buff = null;
        try {
            /*
                转换流派上用场：
                    ‘BufferedWriter’构造方法的参数类型为：‘Writer’；所以‘FileOutputStream’类型参数若想传入，则必须经过转化流转换
             */
            buff = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("常用流\\src\\com\\lujun61\\javase\\io\\buffer\\test.txt", true)));
            //buff = new BufferedWriter(new FileWriter("常用流\\src\\com\\lujun61\\javase\\io\\buffer\\test.txt"));

            buff.write("Hello, World!");
            buff.write("\n");
            buff.write("Hello, World!");


            buff.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (buff != null) {
                try {
                    buff.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}