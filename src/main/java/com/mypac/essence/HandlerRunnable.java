package com.mypac.essence;

import static com.mypac.essence.OperationType.INCREASING;

public class HandlerRunnable implements Runnable{
    private String name;
    private Bank bank;
    private Front front;

    public HandlerRunnable(String name, Bank bank, Front front) {
        this.name = name;
        this.bank = bank;
        this.front = front;
    }

    @Override
    public void run() {
        while (true){
            Request currentRequest = front.getRequest();
            System.out.println("Получена заявка на обработку по клиенту " + currentRequest.name +
                    " обработчик " + name);
            OperationType operationType = currentRequest.operationType;
            switch (operationType){
                case INCREASING -> {
                     bank.increase(currentRequest.sum);
                }
                case DECREASING -> {
                    bank.decrease(currentRequest.sum);
                }
            }
        }
    }
}
