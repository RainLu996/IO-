package com.lujun61.javase.io.input;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* read();方法——————>返回值——————>读取到的字节本身的ASCII码值 */
/* 未读取到数据（数据读取完毕）则返回“-1” */
public class FileInputStreamTest01 {
    public static void main(String[] args) {

        FileInputStream file = null;
        try {
            //创建文件字节流对象
            //文件路径：D:\Java Source File\TestTempFile（IDEA会自动将“\”转换成“\\”，“\”是转义字符）
            //绝对路径的方式
            //file = new FileInputStream("D:\\Java Source File\\TestTempFile\\temp");
            // 写成："D:/Java Source File/TestTempFile\temp"也可以

            //相对路径的方式：相对路径一定是从当前所在的位置开始找文件
            //IDEA默认的当前路径就是项目的根目录下
            file = new FileInputStream("temp");

            int i = 0;
            while ((i = file.read()) != -1) {   //read();方法的返回值是读取到的字节本身的ASCII码值
                System.out.println(i);
            }

            /*此种方式不行：每次循环执行了两次file.read()
            while (file.read() != -1)  {
                System.out.println(file.read());
            }
            */

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {               //在finally语句块中，确保流一定关闭
            if (file != null) {   //避免空指针异常，增强程序的健壮性
                try {
                    file.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
