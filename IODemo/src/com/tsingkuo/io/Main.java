package com.tsingkuo.io;

/**
 * 这个main里边主要就是讲编码问题的
 */

import java.io.File;
import java.io.UnsupportedEncodingException;

public class Main {

    public static void main(String[] args) throws UnsupportedEncodingException {
	// write your code here\
        String s = "慕课ABC";
        byte[] bytes = s.getBytes();
        for (byte b : bytes) {
            System.out.print(Integer.toHexString(b & 0xff) + " ");
        }
        System.out.println(" ");
        System.out.println("按照gbk编码类型进行转换");
        /**
         * gbk编码中文占用两个字节，英文占用一个字节
         */
        byte[] bytes1 = s.getBytes("gbk");
        for (byte b : bytes1
                ) {
            System.out.print(Integer.toHexString(b & 0xff) + " ");
        }

        System.out.println(" ");
        System.out.println("按照utf-8编码类型进行转换");
        /**
         * utf-8编码中文占用三个字节，英文占用一个字节
         */
        byte[] bytes2 = s.getBytes("utf-8");
        for (byte b : bytes2
                ) {
            System.out.print(Integer.toHexString(b & 0xff) + " ");
        }

        System.out.println(" ");
        System.out.println("按照utf-16be编码类型进行转换");
        /**
         * utf-16be编码中文占用两个字节，英文占用两个字节
         */
        byte[] bytes3 = s.getBytes("utf-16be");
        for (byte b : bytes3
                ) {
            System.out.print(Integer.toHexString(b & 0xff) + " ");
        }
    }
}
