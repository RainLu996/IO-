package com.lujun61.javase.io.serial;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/* 序列化多个对象：建议使用List集合 */
public class ObjectOutputStreamTest02 {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("hhh", 11));
        personList.add(new Person("lll", 12));
        personList.add(new Person("zzz", 13));
        personList.add(new Person("ccc", 14));
        personList.add(new Person("kkk", 15));

        ObjectOutputStream objects = null;
        try {
            objects = new ObjectOutputStream(new FileOutputStream("crowd"));

            //序列化集合
            objects.writeObject(personList);

            objects.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (objects != null) {
                try {
                    objects.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
