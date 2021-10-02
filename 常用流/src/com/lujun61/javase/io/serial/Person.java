package com.lujun61.javase.io.serial;

import java.io.Serial;
import java.io.Serializable;

/*
    NotSerializableException:
        如果Person类不实现<Serializable>接口，就无法进行序列化操作和反序列化操作

    这个接口中什么代码也没有，只起到一个标志作用；"标志接口"
    java虚拟机看到某个类实现了这个接口，会给这个类自动生成序列化版本号；
    铭记：不推荐使用这个自动生成的序列化版本号，建议手动添加！

    使用自动生成的序列化版本号的缺点：类在后续无法被修改代码，否则就会报错
    因为只要修改，必然会重新进行编译，此时又会生成全新的序列化版本号，这个时候JVM就会认为这是一个全新的类，自然会影响原有操作
 */

/*
    java中是通过什么机制来识别类的？
        1、首先将类名进行比对，如果类名不一样，则肯定不是同一个类
        2、如果类名一样，再去比对序列化版本号
 */


public class Person implements Serializable {
    @Serial
    private static final long serialVersionUID = 7242696659127610877L;

    private String m_Name;
    private int m_Age;

    public Person() {
    }

    public Person(String m_Name, int m_Age) {
        this.m_Name = m_Name;
        this.m_Age = m_Age;
    }

    public String getM_Name() {
        return m_Name;
    }

    public void setM_Name(String m_Name) {
        this.m_Name = m_Name;
    }

    public int getM_Age() {
        return m_Age;
    }

    public void setM_Age(int m_Age) {
        this.m_Age = m_Age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "m_Name='" + m_Name + '\'' +
                ", m_Age=" + m_Age +
                '}';
    }
}
