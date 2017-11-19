package com.tsingkuo.concurrent;

/**
 * Created by johnnykuo on 2017/10/30.
 */
public class Stage extends Thread {

    @Override
    public void run() {
        ArmyRunnable armyTaskOfSuiDynasty = new ArmyRunnable();
        ArmyRunnable armyTaskOfRevolt = new ArmyRunnable();

        //使用Runnable接口创建线程
        Thread armyOfSuiDynasty = new Thread(armyTaskOfSuiDynasty, "隋军");
        Thread armyOfRevolt = new Thread(armyTaskOfRevolt, "农民起义军");

        //启动线程，让军队开始作战
        armyOfSuiDynasty.start();
        armyOfRevolt.start();

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        armyTaskOfSuiDynasty.keepRunning = false;
        armyTaskOfRevolt.keepRunning = false;

        try {
            armyOfSuiDynasty.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Stage().start();
    }
}
