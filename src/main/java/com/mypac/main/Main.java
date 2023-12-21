package com.mypac.main;

import com.mypac.essence.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Main Threads!");
        Bank bank = new Bank();

        Front front = new Front();

        ClientRunnable increaseBankRunnable1 = new ClientRunnable("increaseBankRunnable1",new Request("increaseBankRunnable1", 100, OperationType.INCREASING), front);
        ClientRunnable increaseBankRunnable2 = new ClientRunnable("increaseBankRunnable2",new Request("increaseBankRunnable2", 200, OperationType.INCREASING), front);
        ClientRunnable decreaseBankRunnable3 = new ClientRunnable("decreaseBankRunnable3",new Request("decreaseBankRunnable3", 100, OperationType.DECREASING), front);
        ClientRunnable decreaseBankRunnable4 = new ClientRunnable("decreaseBankRunnable4",new Request("decreaseBankRunnable4", 200, OperationType.DECREASING), front);
        ClientRunnable decreaseBankRunnable5 = new ClientRunnable("decreaseBankRunnable5",new Request("decreaseBankRunnable5", 200, OperationType.DECREASING), front);

        Thread increaseThread1 = new Thread(increaseBankRunnable1);
        Thread increaseThread2 = new Thread(increaseBankRunnable2);
        Thread decreaseThread3 = new Thread(decreaseBankRunnable3);
        Thread decreaseThread4 = new Thread(decreaseBankRunnable4);
        Thread decreaseThread5 = new Thread(decreaseBankRunnable5);



        HandlerRunnable handlerRunnable1 = new HandlerRunnable("handlerRunnable1", bank, front);
        HandlerRunnable handlerRunnable2 = new HandlerRunnable("handlerRunnable2", bank, front);

        Thread handler1 = new Thread(handlerRunnable1);
        Thread handler2 = new Thread(handlerRunnable2);

        increaseThread1.start();
        increaseThread2.start();
        decreaseThread3.start();
        decreaseThread4.start();
        decreaseThread5.start();

        handler1.start();
        handler2.start();



        System.out.println("Goodbye Main Threads!");
    }
}