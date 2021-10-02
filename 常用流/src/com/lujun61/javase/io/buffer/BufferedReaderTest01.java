package com.lujun61.javase.io.buffer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
    BufferedReader:
        带有缓冲区的字符输入流；
        使用这个流时不需要自定义byte/char类型的数组；
 */
public class BufferedReaderTest01 {
    public static void main(String[] args) {
        BufferedReader buff = null;
        try {
            //当一个流的构造方法中需要另一个流时，这个被传进来的流称为：‘节点流’——————>（不需要自己关闭，底层已经关闭）
            //最外部的流叫做：‘包装流’/‘处理流’——————>需要自己关闭(close)
            buff = new BufferedReader(new FileReader("常用流\\src\\com\\lujun61\\javase\\io\\writer\\test.txt"));

            String s = null;
            while ((s = buff.readLine()) != null)  {//读取一行，且不会读取换行符：更加方便，但并没有快多少
                System.out.println(s);
            }

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
