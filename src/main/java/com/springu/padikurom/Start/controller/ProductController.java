package com.springu.padikurom.Start.controller;


import java.util.ArrayList;
import java.util.List;

import com.springu.padikurom.Start.service.productServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.springu.padikurom.Start.model.ProductDto;
@RestController
@RequestMapping("/app")
public class ProductController {

    @Autowired
    productServiceImpl service ;


    @GetMapping(value="/products" )
    public List<ProductDto> getProducts()
    {
       return service.getProducts();
    }

    @GetMapping("/products/{id}")
    public ProductDto getProductById(
            @PathVariable("id") int id
    ){
       return service.getProductById(id);
    }
    @PostMapping("/addProduct")
    public ProductDto addProduct(
                @RequestBody ProductDto dto
        ){
        return service.addProduct(dto);

        }
        @PutMapping("/updateProduct/{id}")
    public ProductDto updateProduct(
            @PathVariable("id")int id,
            @RequestBody ProductDto product
        ) throws Exception {
        return service.updateProduct(id, product);
    }

        @DeleteMapping("/deleteProduct/{id}")
        public String deleteProduct(
                @PathVariable("id")int id
        ) throws Exception {
            return service.deleteProduct(id);
        }
}
