package com.tsingkuo.tickets;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by johnnykuo on 2017/10/31.
 */
public class TicketWindow implements Runnable {

//    volatile long ticketsCount = 100;
//    private final Object lockObj = new Object();
    AtomicInteger ticketsCount = new AtomicInteger(100);
    public void increment() {
        ticketsCount.incrementAndGet();
    }

    public void decrement() {
        ticketsCount.decrementAndGet();
    }

    public int getCount() {
        return ticketsCount.get();
    }

//    private Set<Tickets> ticketsSet = new HashSet<>();

//    @Override
//    public void run() {
//        synchronized (lockObj) {
//            while (ticketsCount > 0) {
//                ticketsCount--;
//                System.out.println(Thread.currentThread().getName() + "卖了第" + (100 - ticketsCount) + "张票！");
//                break;
//            }
//            try {
//                lockObj.wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            lockObj.notifyAll();
//        }
//    }


            @Override
            public void run() {
                while (getCount() > 0) {
                    decrement();
                    System.out.println(Thread.currentThread().getName() + "卖了第" + (100 - getCount()) + "张票");
                }
            }
}
