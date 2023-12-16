package com.mypac.thread;

public class Signal {
    public synchronized void waitBlock() throws InterruptedException {

        System.out.printf("Поток %s ждет\n", Thread.currentThread().getName());

        wait(); // искусственный пример

        System.out.printf("Поток %s освобожден\n", Thread.currentThread().getName());
    }

    public synchronized void releaseThreads() {
        System.out.printf("Поток %s отправил сигнал\n", Thread.currentThread().getName());

        notify();
    }
}
