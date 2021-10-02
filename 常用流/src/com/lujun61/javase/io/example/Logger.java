package com.lujun61.javase.io.example;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    public static void log(String str_Info) {
        PrintStream print = null;//改变标准输出流的方向

        //获取当前时间
        Date meantime_Date = new Date();
        SimpleDateFormat my_Format = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss SSS");
        String str_Time = my_Format.format(meantime_Date);

        try {
            print = new PrintStream(new FileOutputStream("log.txt", true));
            System.setOut(print);
            System.out.println((str_Time + ":" + str_Info));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (print != null) {
                print.close();
            }
        }
    }
}
