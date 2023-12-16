package com.mypac.essence;

public class Request {
    //которая содержит имя клиента (имя потока), сумму, тип операции
    public String name;
    public long sum;
    public OperationType operationType;

    /**
     * Creating request for changing client balance.
     * @param name Client name (Thread name)
     * @param sum Operation sum
     * @param operationType Type of operation
     */
    public Request(String name, long sum, OperationType operationType){
        this.name = name;
        this.sum = sum;
        this.operationType = operationType;
    }

}
