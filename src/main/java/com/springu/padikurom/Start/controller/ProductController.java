package com.springu.padikurom.Start.controller;

import com.springu.padikurom.Start.model.productDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @GetMapping("/product")
    public productDto getProduct(){
        return new productDto(1, "Iphone", "Electronics", 1000);
    }
}
