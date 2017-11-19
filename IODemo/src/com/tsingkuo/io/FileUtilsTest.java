package com.tsingkuo.io;

import java.io.File;
import java.io.IOException;

/**
 * Created by johnnykuo on 2017/10/27.
 */
public class FileUtilsTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        FileUtils.listDirectory(new File("/Users/johnnykuo/Documents"));
//     FileUtils.printHexByByteArrays("/Users/johnnykuo/Documents/Projects/IODemo/src/com/tsingkuo/io/RafDemo.java");
//        FileUtils.fileOPStreamTest("/Users/johnnykuo/Documents/Projects/IODemo/src/com/tsingkuo/io/test.txt");
//        FileUtils.printHex("/Users/johnnykuo/Documents/Projects/IODemo/src/com/tsingkuo/io/test.txt");
//        FileUtils.copyFile("/Users/johnnykuo/Documents/Projects/IODemo/src/com/tsingkuo/io/RafDemo.java",
//                    "/Users/johnnykuo/Documents/Projects/IODemo/src/com/tsingkuo/io/RafDemo.txt");
//        FileUtils.dataOutputStreamTest("./test.txt");
//        FileUtils.dataInputStreamTest("./test.txt");
//        FileUtils.copyFileByBuffer("/Users/johnnykuo/Documents/Projects/IODemo/src/com/tsingkuo/io/RafDemo.java", "111.txt");
        FileUtils.testSerializableWriter("test.txt");
        FileUtils.testSerializableReader("test.txt");
    }
}
