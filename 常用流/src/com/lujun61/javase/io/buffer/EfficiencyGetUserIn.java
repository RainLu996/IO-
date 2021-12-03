package com.lujun61.javase.io.buffer;

import java.io.*;

/**
 * @description 高效率接收用户输入
 * @author Jun Lu
 * @date 2021-12-03 15:42:07
 */
public class EfficiencyGetUserIn {
    public static void main(String[] args) {
        String get = null;

        /**
         * 使用BufferedReader而不是使用BufferedInputStream去接受输入，是因为：BufferedInputStream中没有readLine方法
         */
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        try {
            /**
             * 在缓冲区中一次读取一行
             */
            get = buffer.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (buffer != null) {
                try {
                    buffer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println(get);
        System.out.println(get.getClass());//java.lang.String
    }
}
