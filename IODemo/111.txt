package com.tsingkuo.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

/**
 * Created by johnnykuo on 2017/10/27.
 */
public class RafDemo {
    public static void main(String[] args) throws IOException{
        File file = new File("fileTest");
        File file2 = null;
        if (!file.exists()) {
            file.mkdir(); //创建目录
        } else {
            file2 = new File(file, "file2.txt");
            if (!file2.exists()) {
                file2.createNewFile(); //创建文件
            }
        }

        RandomAccessFile raf = new RandomAccessFile(file2, "rw"); //创建一个读写文件
        System.out.println(raf.getFilePointer()); //获取文件指针的位置
        raf.write('A'); //往文件里写一个A,但这个英文字符占用两字节，write方法只能写一个字节，所以它会写A这个字符所占两位字节中的后边一个字节
        System.out.println(raf.getFilePointer());
        raf.write('B');
        System.out.println(raf.getFilePointer());

        int i = 0x7fffffff; //int类型的最大值，十六进制写出来就是0x0111 1111 1111 1111 1111 1111 1111 1111，一个字节是8位
        raf.write(i >>> 24); //i的字节整体向右平移24位，也就是0x0000 0000 0000 0000 0000 0000 0111 1111
        raf.write(i >>> 16); //i的字节整体向右平移16位，也就是0x0000 0000 0000 0000 0111 1111 1111 1111
        raf.write(i >>> 8);  //i的字节整体向右平移8位，也就是 0x0000 0000 0111 1111 1111 1111 1111 1111
        raf.write(i);           //这次写入的时候，就直接去i所有字节的最后八位
        System.out.println(raf.getFilePointer());

        raf.writeInt(i); // 在这里我们是直接用了writeInt()方法，其实这个方法的底层源码就是实现了我们上边向右平移24位，再向右平移16位，再向右平移8位等操作
        System.out.println(raf.getFilePointer());

        String s = "中";
        byte[] bytes = s.getBytes();
        raf.write(bytes);  //write()方法是可以直接写入一个byte类型的数组
        System.out.println(raf.getFilePointer());
        System.out.println(raf.length());

        raf.writeBytes(s); //可以通过writeChars() 方法来直接写入一个字符串,但这个方法写出来的结果则有一些小问题，等待以后深入学习之后再处理
        System.out.println(raf.getFilePointer());

        /**
         * 由于读、写操作都是公用一个RandomAccessFile对象，所以它的指针会被其他任意操作改变的，我们在读之前需要把它的指针归零
         */
        raf.seek(0);
        System.out.println(raf.read()); //读出来一个字节的内容
        System.out.println(raf.getFilePointer());
        if (raf.getFilePointer() != 0) {
            raf.seek(0);
        }
        byte[] buf = new byte[(int) raf.length()];
        raf.read(buf); //read()方法返回一个字节的内容，但也可以直接把读取的字节数组写入到一个字节数组中去
        System.out.println(Arrays.toString(buf));

        String s1 = new String(buf);
        System.out.println(s1);

        raf.close(); //文件读取之后，一定要进行关闭操作
    }
}
