package com.tsingkuo.tickets;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * Created by johnnykuo on 2017/10/31.
 */
public class DaemonThread implements Runnable {
    @Override
    public void run() {
        System.out.println("守护进程开始");

        try {
            writeTo();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("守护进程结束");
    }

    public void writeTo() throws Exception{
        File file = new File("/Users/johnnykuo/Documents/Projects/111.txt");
        int count =0;
        FileOutputStream fos = new FileOutputStream(file, true);
        while (count < 999) {
            fos.write(("写入" + count).getBytes());
            count++;
            System.out.println(Thread.currentThread().getName() + "写入" + count);

            Thread.sleep(1000);
        }
    }
}
