package com.lujun61.javase.io.data;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DataInputStreamTest {
    public static void main(String[] args) {
        DataInputStream data = null;
        try {
            data =  new DataInputStream(new FileInputStream("常用流\\src\\com\\lujun61\\javase\\io\\data\\test.txt"));
            //按照顺序读数据——————>不按照顺序读，就会是错误的数据反馈
            System.out.println(data.readByte());
            System.out.println(data.readShort());
            System.out.println(data.readInt() + 100);//取出来之后还可以做些简单操作
            System.out.println(data.readLong());
            System.out.println(data.readFloat());
            System.out.println(data.readDouble());
            System.out.println(data.readBoolean());
            System.out.println(data.readChar());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (data != null) {
                try {
                    data.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}