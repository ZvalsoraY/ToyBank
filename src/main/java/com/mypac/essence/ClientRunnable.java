package com.mypac.essence;

public class ClientRunnable implements Runnable {
    private String name;
    private Request request;

    private Front front;

    public ClientRunnable(String name, Request request, Front front){
        this.name = name;
        this.request = request;
        this.front = front;
    }
    @Override
    public void run() {
        front.addRequest(request);
    }
}
