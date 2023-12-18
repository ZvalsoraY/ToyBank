package com.mypac.essence;

import java.util.ArrayDeque;

public class Front {
    private ArrayDeque<Request> requests = new ArrayDeque<>();

    public void addRequest(Request request){
        synchronized (this) {
            //requests.addLast(request);
            while (requests.size() >= 2) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    //Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }
            }
            requests.add(request);
            //requests.addLast(request);
            this.notifyAll();
        }
    }

    public Request getRequest() {
        synchronized (this) {
            while (requests.size() < 1) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    //Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }
            }
            Request firstRequest = requests.poll();
            this.notifyAll();
            return firstRequest;
        }
    }

}
