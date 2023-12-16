package com.mypac.essence;

public class Bank {
    private long balance;
    public Bank(long balance) {
        this.balance = balance;
    }

    public long getBalance() {
        return balance;
    }

    // Увеличить счёт
    public synchronized void increase(long value) {
        balance += value;
        System.out.printf("Поток %s отправил сигнал о пополнеии счета, balance = %d\n",
                Thread.currentThread().getName(), balance);
        notify(); // this.notify()
    }

    // Уменьшить счёт
    public synchronized void decrease(long value) {

        while (balance - value < 0) {

            try {
                System.out.printf("Поток %s ждет, потому что: balance - value = %d\n",
                        Thread.currentThread().getName(), balance - value);

                // освобождает монитор и переводит вызывающий
                // поток в состояние ожидания до тех пор,
                // пока другой поток не вызовет метод notify()
                wait(); // this.wait()

                System.out.printf("Поток %s получил сигнал о пополнении счета\n",
                        Thread.currentThread().getName());

            } catch (InterruptedException e) {
                System.out.println("Ошибка InterruptedException");
            }

        }
        balance -= value;

        System.out.printf("Поток %s списал %d, balance = %d\n",
                Thread.currentThread().getName(), value, balance);
    }
}
