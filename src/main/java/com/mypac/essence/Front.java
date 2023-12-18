package com.mypac.essence;

import java.util.ArrayDeque;

public class Front {
    private ArrayDeque<Request> requests = new ArrayDeque<>();

    public void addRequest(Request request){
        synchronized (this) {
            requests.addLast(request);
            while (requests.size() >= 2) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            requests.add(request);
            this.notifyAll();
        }
    }

    public Request getRequest() {
        synchronized (this) {
            while (requests.size() < 1) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            Request firstRequest = requests.getFirst();
            this.notifyAll();
            return firstRequest;
        }
    }

}
