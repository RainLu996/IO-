package com.lujun61.javase.io.properties;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


/* IO与Properties集合的联合使用 */

/*
    IO与Properties联合使用是一个非常好的设计理念：
        以后经常改变的数据，可以单独写到一个文件当中，使用程序动态读取；
        将来只要修改这个文件的内容，java代码无须改动：不需要重新编译、服务器不需要重启，就可以拿到动态修改后的信息

     类似于以上机制的文件被称为配置文件。

     若配置文件中的内容格式为：
        key1=value1
        key2=value2
        ......
        的时候，我们把这种配置文件叫做《属性配置文件》。
     java中的属性配置文件有规范要求：即文件扩展名以“.properties”结尾
 */
public class IoPropertiesTest01 {
    public static void main(String[] args) {
        /* 将UserInFo文件中的用户信息加载到Properties集合中 */

        //创建一个输出流对象
        FileReader reader = null;
        try {
            reader = new FileReader("常用流\\src\\com\\lujun61\\javase\\io\\properties\\UserInFo.properties");

            Properties pro = new Properties();
            pro.load(reader);//流中的数据顺着“管道”加载（load）到Properties集合当中

            System.out.println(pro.getProperty("password"));
            System.out.println(pro.getProperty("UserName"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
