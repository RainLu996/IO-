package com.lujun61.javase.io.writer;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {
    public static void main(String[] args) {
        FileWriter writer = null;

        try {
            writer = new FileWriter("D:\\JavaSourceFile\\IO流\\常用流\\src\\com\\lujun61\\javase\\io\\writer\\writer.txt");

            char[] c = {'H', 'H', 'H'};
            writer.write(c);
            writer.write("Hello World!");//字符流可以直接写入字符串

            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
