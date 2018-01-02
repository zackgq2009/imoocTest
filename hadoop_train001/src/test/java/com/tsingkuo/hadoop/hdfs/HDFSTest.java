package com.tsingkuo.hadoop.hdfs;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.hdfs.server.namenode.top.window.RollingWindowManager;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.util.Progressable;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;

public class HDFSTest {

    public static final String HDFS_URI = "hdfs://192.168.1.9:8020";

    FileSystem fileSystem = null;
    Configuration configuration = null;


    /**
     * 测试用例开始前执行的代码
     */
    @Before
    public void setUp() {
        System.out.println("get fileSystem");
        configuration = new Configuration();
        try {
            fileSystem = FileSystem.get(new URI(HDFS_URI), configuration, "root");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试用例结束时进行的代码
     */
    @After
    public void tearDown() {
        System.out.println("over fileSystem");
        fileSystem = null;
        configuration = null;
    }

    /**
     * 创建目录
     */
    @Test
    public void mkdir() {
        try {
            fileSystem.mkdirs(new Path("/test001"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建文件
     */
    @Test
    public void create() {
        try {
            FSDataOutputStream outputStream = fileSystem.create(new Path("/test001/hello.txt"));
            outputStream.write("hello hello hello".getBytes());
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 为hdfs中的文件重命名
     */
    @Test
    public void rename() {
        Path oldPath = new Path("/test001/hello.txt");
        Path newPath = new Path("/test001/bbb.txt");
        try {
            fileSystem.rename(oldPath, newPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除HDFS中的文件
     */
    @Test
    public void delete() {
        try {
            fileSystem.delete(new Path("/test001/bbb.txt"), false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 从本地拷贝文件到HDFS上
     */
    @Test
    public void copyFromLocalFile() {
        Path localPath = new Path("/Users/johnnykuo/Downloads/hadoop-2.6.0-cdh5.7.0.tar.gz");
        Path hdfsPath = new Path("/test001");
        try {
            fileSystem.copyFromLocalFile(localPath, hdfsPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 从HDFS上拷贝出文件
     */
    @Test
    public void copyToLocalFile() {
        Path hdfsPath = new Path("/test001/hadoop-2.6.0-cdh5.7.0.tar.gz");
        Path localPath = new Path("/Users/johnnykuo/Documents/workspace");
        try {
            fileSystem.copyToLocalFile(hdfsPath, localPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过IOUtiles来实现了拷贝时有进度
     * 但后来发现fileSystem中只有create方法中可以加入Progressable参数，open方法中没有Progressable参数
     */
//    @Test
//    public void copyToLocalFileWithProgress() {
//        try {
//            OutputStream outputStream = new FileOutputStream(new File("/Users/johnnykuo/Documents/workspace/hadoop.tar.gz"));
//            FSDataInputStream inputStream = fileSystem.open(new Path("/test001/hadoop-2.6.0-cdh5.7.0.tar.gz"));
//
//            IOUtils.
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    /**
     * 通过IOUtils来实现拷贝时有进度
     */
    @Test
    public void copyFromLocalFileWithProgress() {
        try {
            InputStream inputStream = new FileInputStream(new File("/Users/johnnykuo/Documents/workspace/hadoop-2.6.0-cdh5.7.0.tar.gz"));
            FSDataOutputStream outputStream = fileSystem.create(new Path("/test001/hadoop.tar.gz"), new Progressable() {
                public void progress() {
                    System.out.println(".");
                }
            });

            IOUtils.copyBytes(inputStream , outputStream, 4096);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查看目录结构以及相关目录中的各个信息
     */
    @Test
    public void fileList() {
        try {
            FileStatus[] fileStatuses = fileSystem.listStatus(new Path("/test001"));
            for (FileStatus fileStatus : fileStatuses
                    ) {
                System.out.println(fileStatus.getPath());
                System.out.println(fileStatus.isDirectory()? "文件夹" : "文件");
                System.out.println(fileStatus.getBlockSize());
                System.out.println(fileStatus.getReplication());
                System.out.println(fileStatus.getLen());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过fileSystem的delete方法，并且通过递归处理进行整个目录以及文件的删除
     */
    @Test
    public void deleteAll() {
        try {
            fileSystem.delete(new Path("/test001"), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
