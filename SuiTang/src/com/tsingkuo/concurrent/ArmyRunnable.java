package com.tsingkuo.concurrent;

/**
 * Created by johnnykuo on 2017/10/30.
 */
public class ArmyRunnable implements Runnable {

    //volatile保证了线程可以正确的读取其他线程写入的值，该值是共享的性质
    volatile boolean keepRunning = true;

    @Override
    public void run() {
        while (keepRunning) {
            //发动5连击
            for (int i=0;i<5;i++) {
                System.out.println(Thread.currentThread().getName() + "进攻对象【" + i + "】");
                //让出了处理器时间，下次该谁进攻还不一定呢！
                Thread.yield();
            }
        }
        System.out.println(Thread.currentThread().getName() + "结束了战斗");
    }
}
