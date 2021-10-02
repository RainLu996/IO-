package com.lujun61.javase.io.data;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
    数据专属的流：
        这个流可以将数据连同数据类型一并写入文件
        tip：此文件不是普通文本文件（无法用记事本打开/打开也是一堆乱码）
 */
public class DataOutputStreamTest {
    public static void main(String[] args) {
        DataOutputStream data = null;

        try {
            //构造方法中的类型为：OutputStream；但是OutputStream是接口，无法new对象，所以使用它的子类
            data = new DataOutputStream(new FileOutputStream("常用流\\src\\com\\lujun61\\javase\\io\\data\\test", true));

            //准备不同数据类型的数据：数据流将会把数据类型一同写入~
            byte b = 1;
            short s = 2;
            int i = 3;
            long l = 4L;
            float f = 5.5F;
            double d = 6.6;
            boolean bool = false;
            char c = 'c';
            data.writeByte(b);
            data.writeShort(s);
            data.writeInt(i);
            data.writeLong(l);
            data.writeFloat(f);
            data.writeDouble(d);
            data.writeBoolean(bool);
            data.writeChar(c);

            data.flush();
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
