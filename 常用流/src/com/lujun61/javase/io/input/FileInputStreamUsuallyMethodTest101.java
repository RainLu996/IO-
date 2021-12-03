package com.lujun61.javase.io.input;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* int available();——————>返回值：返回流当中剩余的没有读到的字节数量 */
/* 应用：可以用来一次性读取小体积文件 */

/* long	skip(long n);——————>跳过几个字节不读 */
public class FileInputStreamUsuallyMethodTest101 {
    public static void main(String[] args) {
        FileInputStream file = null;

        try {
            file = new FileInputStream("temp");

            byte[] bytes_All = new byte[file.available()];

            file.skip(0);//跳过几个字节不读

            int readCount = file.read(bytes_All);
            System.out.println(readCount);
            System.out.println(new String(bytes_All));//不太适合大文件，因为byte数组不能太大

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(file != null){
                try {
                    file.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
