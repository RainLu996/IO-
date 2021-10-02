package com.lujun61.javase.io.serial;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

/* 反序列化多个对象（反序列化集合） */
public class ObjectInputStreamTest02 {
    public static void main(String[] args) {
        ObjectInputStream inCollection = null;

        try {
            inCollection = new ObjectInputStream(new FileInputStream("crowd"));

            Object obj;
            if ((obj = inCollection.readObject()) instanceof List) {
                List<Person> destL = (List<Person>) obj;
                for (Person getL :
                     destL) {
                    System.out.println(getL);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (inCollection != null) {
                try {
                    inCollection.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
