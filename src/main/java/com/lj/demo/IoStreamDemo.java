package com.lj.demo;

import java.io.*;

/**
 * @author : liangjun
 * @ClassName : IoStreamDemo
 * @Description :
 * @Date : 2019/12/04 14:25
 */
public class IoStreamDemo {
    public static void main(String[] args) {
        //字节流读取
        File file = new File("C:\\Users\\Administrator\\Desktop\\Redis.txt");
//        InputStream fs = null;
//        try {
//            fs = new FileInputStream(file);
//            byte[] bt = new byte[1024];
//            int result;
//            while ((result = fs.read(bt)) != -1) {
//                String s = new String(bt, 0, result);
//                System.out.println(s);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (fs != null) {
//                try {
//                    fs.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }

        //字符流读取
        Reader reader = null;
        try {
            reader = new FileReader("C:\\Users\\Administrator\\Desktop\\Redis.txt");
            char[] ch = new char[1024];
            int result;
            while ((reader.read(ch)) != -1) {
                System.out.println(ch);
            }
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
