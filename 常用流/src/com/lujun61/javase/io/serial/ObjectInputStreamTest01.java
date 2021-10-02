package com.lujun61.javase.io.serial;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/* 反序列化单个对象 */
public class ObjectInputStreamTest01 {
    public static void main(String[] args) {
        ObjectInputStream input = null;

        try {
            input = new ObjectInputStream(new FileInputStream("human"));

            //方法一：反序列化得到的数据类型的父类都是Object
            Object temp;
            if ((temp = input.readObject()) instanceof Person) {
                Person goalP = (Person) temp;
                System.out.println(goalP);
            }

            /*方法二（不推荐）
            Object g = input.readObject();
            System.out.println(g);*/

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
