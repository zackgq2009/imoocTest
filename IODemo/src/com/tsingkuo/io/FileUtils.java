package com.tsingkuo.io;

import java.io.*;

/**
 * Created by johnnykuo on 2017/10/27.
 */
public class FileUtils {

    /**
     * 我们通过此方法来遍历指定目录下的所有子目录以及所有文件
     * 然后通过递归的方式来实现遍历所有子目录跟文件，以及所有子目录下的所有文件。一层一层往下遍历
     * @param dir
     * @throws IOException
     */
    public static void listDirectory(File dir) throws IOException {
        if (!dir.exists()) {
            throw new IllegalArgumentException("目录" + dir + "不存在");
        } else if (!dir.isDirectory()) {
            throw new IllegalArgumentException(dir + "不是目录");
        } else {
//            String[] fileList = dir.list(); //list()只返回指定目录下子目录跟文件的名称
//            for (String file : fileList
//                    ) {
//                System.out.println(file);
//            }
            File[] fileList = dir.listFiles();
            if (fileList != null && fileList.length > 0) {
                for (File file : fileList
                        ) {
//                    listDirectory(file);
                    if (file.isDirectory()) {
                        listDirectory(file); //递归方法
                    } else {
                        System.out.println(dir);
                    }
                }
            }
        }
    }


    /**
     * 读取指定文件内容，按照16进制输出到控制台
     * 并且没输出10个byte换行
     * @param fileName
     * @throws IOException
     */
    public static void printHex(String fileName) throws IOException{
        FileInputStream in = new FileInputStream(fileName); //把文件作为字节流进行读操作
        int b;
        int j =1;
        while ((b = in.read()) != -1) {
            if (b < 0xf) {
                System.out.print("0");
            }
            System.out.print(Integer.toHexString(b) + "  ");
            if (j++ % 10 == 0) {
                System.out.println(" ");
            }
        }
        in.close();
    }

    public static void printHexByByteArray(String fileName) throws IOException{
        FileInputStream in = new FileInputStream(fileName);
        byte[] buf = new byte[20 * 1024];
        /**
         * 从in中批量读取字节，放入到buf这个字节数组中，
         * 从第0个位置开始放，最多放buf.length个
         * 返回的是读到的字节的个数
         */
        int bytes = in.read(buf, 0, buf.length);  //如果一次性读完的话，就说明字节数组足够大，那么返回回来的长度就没有字节数组的长度长啦
        int j = 1;
        for (int i=0; i<bytes; i++) {
            if (buf[i] <= 0xf) {
                System.out.print("0");
            } else {
                /**
                 * 这里说明一下，由于我们是使用了Integer的toHexString方法，但里边传的是byte类型，byte类型时8位，int类型是32位，为了避免数据转换错误，通过& 0xff将高24位清零
                 */
//                System.out.print(Byte.toString(buf[i]) + "  ");
                System.out.print(Integer.toHexString(buf[i] & 0xff) + "  ");
                if (j++ % 10 == 0) {
                    System.out.println("");
                }
            }
        }
    }

    /**
     * 当我们分配的缓冲区的字节数组不够大，一次性无法读完文件，这个时候我们就需要这个方法啦
     * @param fileName
     * @throws IOException
     */
    public static void printHexByByteArrays(String fileName) throws IOException{
        byte[] buf = new byte[1024];
        int j =1;
        FileInputStream in = new FileInputStream(fileName);
        int bytes = 0;
        while ((bytes = in.read(buf, 0, buf.length))!= -1) {
            for (int i=0; i<bytes; i++) {
                if (buf[i] <= 0xf) {
                    System.out.print("0");
                } else {
                    System.out.print(Integer.toHexString(buf[i] & 0xff) + "  ");
                    if (j++ % 10 == 0) {
                        System.out.println("");
                    }
                }
            }
        }
    }

    /**
     * 用于测试FileOutputStream类对于文件写入的操作
     * @param fileName
     */
    public static void fileOPStreamTest(String fileName) throws IOException{
        /**
         * 如果该文件不存在，则直接创建，如果存在，删除后创建
         * 它还有另一个构造函数，new FileOutputStream(fileName, boolean append)
         * append则是告知是否要在已存在的文件上进行内容的追加，当时false时，则直接删除已存在的文件，重新创建新文件，然后在新文件中写入内容
         * 如果是true的话，则是在已存在的文件上追加内容，文件以及文件中之前的内容均不会受影响
         */
        FileOutputStream out = new FileOutputStream(fileName);
        out.write('A'); //写入了'A'的低八位
        out.write('B'); //写入了'B'的低八位
        int a = 10; //write只能写八位，那么写一个int需要写4次，每次8位。因为int是32位的
        out.write(a >>> 24);
        out.write(a >>> 16);
        out.write(a >>> 8);
        out.write(a);
        byte[] utf8 = "中国".getBytes();
        out.write(utf8);
        out.close();
    }

    /**
     * 通过FileInputStream/FileOutputStream类来测试拷贝文件的方法
     * @param srcFile
     * @param directFile
     * @throws IOException
     */
    public static void copyFile(String srcFile, String directFile) throws IOException{
        File inFile = new File(srcFile);
        File outFile = new File(directFile);
        if (!inFile.exists()) {
            throw new IllegalArgumentException("文件：" + inFile + "不存在");
        } else if (!inFile.isFile()) {
            throw new IllegalArgumentException(inFile + "不是文件");
        } else {
            FileInputStream in = new FileInputStream(srcFile);
            FileOutputStream out = new FileOutputStream(directFile);
            //这个时候append的意义是来判断文件是否存在，其实这边的boolean append的值对于以后往里边写内容是不影响的，只是在new FileOutputStream对象的时候才会进行判断并决定是否删除已有文件的
            byte[] buf = new byte[8 * 1024];
            int bytes;
            while ((bytes = in.read(buf, 0, buf.length)) != -1) {
                out.write(buf, 0, bytes);
//            out.flush();  这个地方不用刷新，只有用到BufferedInputStream/BufferedOutputStream时才要用到刷新
            }
            in.close();
            out.close();
        }
    }

    /**
     * 测试DataOutputStream这个流的写入方法
     * 它是在FileOutputStream类的基础上进行了一层封装，封装出一些针对int,long,double,char等类型数据的写入操作
     * @param directFileName
     * @throws IOException
     */
    public static void dataOutputStreamTest(String directFileName) throws IOException {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream(directFileName));
        dos.writeInt(10);
        dos.writeInt(-10);
        dos.writeLong(10l);
        dos.writeDouble(10.5);
        dos.writeUTF("中国");
        dos.writeChars("中国");
        dos.close();
    }

    /**
     * 测试DataInputStream这个流的读取方法
     * 它是在FileInputStream类的基础上进行了一层封装，封装出一些针对int,long,double,char等类型数据的读取操作
     * @param srcFileName
     * @throws IOException
     */
    public static void dataInputStreamTest(String srcFileName) throws IOException {
        DataInputStream dis = new DataInputStream(new FileInputStream(srcFileName));
        int i = dis.readInt();
        System.out.println(i);
        i = dis.readInt();
        System.out.println(i);
        long l = dis.readLong();
        System.out.println(l);
        double d = dis.readDouble();
        System.out.println(d);
        String s = dis.readUTF();
        System.out.println(s);
//        char = dis.readChar();
//        System.out.println(i);
    }

    /**
     *
     * @param srcFileName
     * @param directFileName
     * @throws IOException
     */
    public static void copyFileByBuffer(String srcFileName, String directFileName) throws IOException{
        File inFile = new File(srcFileName);
        File outFile = new File(directFileName);
        if (!inFile.exists()) {
            throw new IllegalArgumentException("文件：" + inFile + "不存在");
        } else if (!inFile.isFile()) {
            throw new IllegalArgumentException(inFile + "不是文件");
        } else {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(inFile));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(outFile));
            int b;
            while ((b = bis.read()) != -1) {
                bos.write(b);
                bos.flush();
            }
            bis.close();
            bos.close();
        }
    }

    /**
     * 通过ObjectOutputStream实现类来测试将对象序列化并保存在文件中
     * @param fileName
     * @throws IOException
     */
    public static void testSerializableWriter(String fileName) throws IOException{
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName));
        TestStudent ts = new TestStudent("111", "johnny", 22);
        objectOutputStream.writeObject(ts);
        objectOutputStream.flush();
        objectOutputStream.close();
    }

    /**
     * 通过ObjectInputStream实现类来测试对象的反序列化操作
     * 注意一点就是ObjectInputStream.readObject() 方法返回出来的永远是Object对象，我们需要根绝自己的实际情况来进行强制转型
     * @param fileName
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void testSerializableReader(String fileName) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName));
        TestStudent testStudent = (TestStudent) objectInputStream.readObject();
        System.out.println(testStudent);
        System.out.println(testStudent.getStuNo() + testStudent.getStuName() + testStudent.getStuAge());
        objectInputStream.close();
    }
}
