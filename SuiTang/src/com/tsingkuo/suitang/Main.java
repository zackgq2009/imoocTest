package com.tsingkuo.suitang;

public class Main {

    public static void main(String[] args) {
        Actor actor = new Actor();
        actor.setName("男演员");
        actor.start();

        Thread thread = new Thread(new Actress(), "女演员");
        thread.start();
    }
}
