package com.lujun61.javase.io.std;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/*
    标准输出流不需要手动close关闭
    可以改变标准输出流的方向
 */
public class PrintStreamTest {
    public static void main(String[] args) {
        PrintStream so = System.out;
        so.println(666);
        PrintStream print = null;
        try {
            //为标准输出流创建一个文件输出方向
            print = new PrintStream(new FileOutputStream("常用流\\src\\com\\lujun61\\javase\\io\\std\\test.txt"));

            //标准函数输出方向被修改为指定文件
            System.setOut(print);

            System.out.println(111);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (print != null) {
                print.close();
            }
        }
    }
}
