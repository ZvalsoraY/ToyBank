package com.mypac.thread;

public class WaitThread extends Thread {

    // Ожидающий поток
    public WaitThread(String name) {
        super(name);
    }

    /*@Override
    public void run() {
        try {
            signal.waitBlock();
        } catch (InterruptedException e) {
            System.out.println("Ошибка InterruptedException");
        }
    }*/
}
