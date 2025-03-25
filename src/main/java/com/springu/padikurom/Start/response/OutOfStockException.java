package com.springu.padikurom.Start.response;


public class OutOfStockException extends RuntimeException{

    public String msg;

    public OutOfStockException() {
        super();
    }

    public OutOfStockException(String msg) {
        super(msg);

    }


}
