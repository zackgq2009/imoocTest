package com.tsingkuo.suitang;

/**
 * Created by johnnykuo on 2017/10/30.
 */
public class Actor extends Thread {
    @Override
    public void run() {
        System.out.println(this.getName() + "是一个演员");

        int count = 0;
        boolean keepRunning = true;

        while (keepRunning) {
            System.out.println(this.getName() + "表演了" + (++count));

            if (count % 10 == 0) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (count == 100) {
                keepRunning = false;
            }
        }

        System.out.println(this.getName() + "表演结束");
    }
}
