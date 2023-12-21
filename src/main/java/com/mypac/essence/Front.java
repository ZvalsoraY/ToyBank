package com.mypac.essence;

import java.util.concurrent.ArrayBlockingQueue;


public class Front {
    private ArrayBlockingQueue<Request> requests = new ArrayBlockingQueue<>(2);

    public void addRequest(Request request) {
        try{
            requests.put(request);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public Request getRequest(){
        try {
            Request firstRequest = requests.take();
            return firstRequest;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
