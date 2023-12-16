package com.mypac.main;

import com.mypac.essence.Bank;
import com.mypac.essence.Request;
import com.mypac.essence.OperationType;
import com.mypac.thread.ChangeBankThread;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Threads!");
        Bank bank = new Bank(100);

        Thread increaseThread1 = new ChangeBankThread(new Request("increaseBankThread1", 100, OperationType.INCREASING));
        Thread increaseThread2 = new ChangeBankThread(new Request("increaseBankThread2", 200, OperationType.INCREASING));
        Thread decreaseThread3 = new ChangeBankThread(new Request("decreaseBankThread3", 100, OperationType.DECREASING));
        Thread decreaseThread4 = new ChangeBankThread(new Request("decreaseBankThread3", 200, OperationType.DECREASING));

        increaseThread1.start();
        increaseThread2.start();
        decreaseThread3.start();
        decreaseThread4.start();



        System.out.println("Hello world!");
    }
}