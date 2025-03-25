package com.springu.padikurom.Start.response;

import org.springframework.http.HttpStatus;

public class ProductAlreadyExists extends RuntimeException {
    String msg;
    ProductAlreadyExists(){super();
    }
    public ProductAlreadyExists(String s){
        super(s);

    }
}
