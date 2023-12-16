package com.mypac.thread;

import com.mypac.essence.Request;

public class ChangeBankThread extends Thread{
    private Request request;
    public ChangeBankThread(Request request){
        this.request = request;
    }


}
