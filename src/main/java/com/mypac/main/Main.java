package com.mypac.main;

import com.mypac.essence.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Main Threads!");
        Bank bank = new Bank();
        Front front = new Front();

        ExecutorService clientThreadPool = Executors.newFixedThreadPool(1);
        ExecutorService handlerThreadPool = Executors.newFixedThreadPool(1);

        ClientRunnable increaseBankRunnable1 = new ClientRunnable("increaseBankRunnable1",new Request("increaseBankRunnable1", 100, OperationType.INCREASING), front);
        ClientRunnable increaseBankRunnable2 = new ClientRunnable("increaseBankRunnable2",new Request("increaseBankRunnable2", 200, OperationType.INCREASING), front);
        ClientRunnable decreaseBankRunnable3 = new ClientRunnable("decreaseBankRunnable3",new Request("decreaseBankRunnable3", 100, OperationType.DECREASING), front);
        ClientRunnable decreaseBankRunnable4 = new ClientRunnable("decreaseBankRunnable4",new Request("decreaseBankRunnable4", 200, OperationType.DECREASING), front);
        ClientRunnable decreaseBankRunnable5 = new ClientRunnable("decreaseBankRunnable5",new Request("decreaseBankRunnable5", 200, OperationType.DECREASING), front);

        HandlerRunnable handlerRunnable1 = new HandlerRunnable("handlerRunnable1", bank, front);
        HandlerRunnable handlerRunnable2 = new HandlerRunnable("handlerRunnable2", bank, front);

        clientThreadPool.submit(increaseBankRunnable1);
        clientThreadPool.submit(increaseBankRunnable2);
        clientThreadPool.submit(decreaseBankRunnable3);
        clientThreadPool.submit(decreaseBankRunnable4);
        clientThreadPool.submit(decreaseBankRunnable5);

        handlerThreadPool.submit(handlerRunnable1);
        handlerThreadPool.submit(handlerRunnable2);

        System.out.println("Goodbye Main Threads!");
    }
}