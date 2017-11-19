package com.tsingkuo.tickets;

/**
 * Created by johnnykuo on 2017/10/31.
 */
public class TicketsThread {
    public static void main(String[] args) throws InterruptedException {
        TicketWindow tw = new TicketWindow();

        Thread thread1 = new Thread(tw, "窗口一");
        Thread thread2 = new Thread(tw, "窗口二");
        Thread thread3 = new Thread(tw, "窗口三");

        thread1.start();
        thread2.start();
        thread3.start();

//        thread1.join();
//        thread2.join();
//        thread3.join();
    }
}
