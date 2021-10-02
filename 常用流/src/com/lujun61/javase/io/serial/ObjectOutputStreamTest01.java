package com.lujun61.javase.io.serial;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/* 序列化单个对象 */
public class ObjectOutputStreamTest01 {
    public static void main(String[] args) {
        Person p = new Person("Lj", 18);
        ObjectOutputStream o = null;
        try {
            o = new ObjectOutputStream(new FileOutputStream("human"));

            //序列化对象
            o.writeObject(p);

            o.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (o != null) {
                try {
                    o.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
