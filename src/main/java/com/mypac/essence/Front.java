package com.mypac.essence;

import java.util.ArrayDeque;

public class Front {
    private ArrayDeque<Request> requests = new ArrayDeque<Request>();

    public void addRequest(Request request) {
        requests.addLast(request);
    }

    public Request getRequest() {
        return requests.getFirst();
    }

}
