package com.lujun61.javase.io.file;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
    1、File类和流四大家族没有关系，所以不能完成文件的读和写
    2、File对象代表：“文件和路径名的抽象表示形式”
 */
public class FileTest01 {
    public static void main(String[] args) {
        /*//1、创建一个File对象
        File file_1 = new File("D:\\temp");

        //2、判断File对象是否存在
        Boolean isHave_1 = file_1.exists();

        //3、如果不存在，则以‘文件’的形式创建出来
        if (!isHave_1) {
            try {
                file_1.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //4、如果不存在，则以‘目录（文件夹）’的形式创建
        if (!isHave_1) {

            file_1.mkdir();
        }
*/
        //5、创建多重目录
        File file_2 = new File("D:/a/b/c/d/e");
        file_2.mkdirs();

        //6、获取文件的父路径（方法一）
        String parentPath = file_2.getParent();
        System.out.println(parentPath);

        //7、获取文件的父路径（方法二）
        File parentFile = file_2.getParentFile();
        System.out.println(parentFile.getAbsolutePath());

        //8、获取文件名(不是路径)
        System.out.println(file_2.getName());

        //9、判断是否是一个文件
        System.out.println(file_2.isFile());

        //10、判断是否是一个目录
        System.out.println(file_2.isDirectory());

        //11、获取文件最后一次被修改的时间
        long time = file_2.lastModified();
        Date date = new Date(time);
        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        String lastModifyTime = myFormat.format(date);
        System.out.println(lastModifyTime);

        //12、获取文件大小
        System.out.println(file_2.length());

        //13、获取当前目录下的所有子目录
        File file_3 = new File("D:\\Java Source File");
        File[] all_File = file_3.listFiles();
        for (File son_File :
             all_File) {
            System.out.println(son_File.getName());
        }

        //14、删除文件(只能删除当前绝对路径下所表示的文件)
        file_2.delete();
    }
}
