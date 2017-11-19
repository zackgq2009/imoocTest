package com.tsingkuo.tickets;

import java.util.Scanner;

/**
 * Created by johnnykuo on 2017/10/31.
 */
public class DaemonTest {
    public static void main(String[] args) {
        DaemonThread dt = new DaemonThread();
        Thread thread = new Thread(dt, "守护进程1");
        thread.setDaemon(true);
        thread.start();

        System.out.println("主线程开始");
        Scanner scanner = new Scanner(System.in);
        scanner.next();

        System.out.println("主线程结束");
    }
}

