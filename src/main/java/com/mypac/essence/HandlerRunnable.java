package com.mypac.essence;

import static com.mypac.essence.OperationType.INCREASING;

public class HandlerRunnable implements Runnable{
    private Bank bank;
    private Front front;

    public HandlerRunnable(Bank bank, Front front) {
        this.bank = bank;
        this.front = front;
    }

    @Override
    public void run() {
        while (true){
            OperationType operationType = front.getRequest().operationType;
            switch (operationType){
                case INCREASING -> {
                     bank.increase(front.getRequest().sum);
                }
                case DECREASING -> {
                    bank.decrease(front.getRequest().sum);
                }

            }
        }
    }
}
