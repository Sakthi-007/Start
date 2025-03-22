package com.springu.padikurom.Start.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.springu.padikurom.Start.model.ProductDto;
@RestController
@RequestMapping("/app")
public class ProductController {

    List<ProductDto> dtos = new ArrayList<>();


    public ProductController()
    {
        dtos.add(new ProductDto(1, "Chair" , 4000 , "Infra"));
        dtos.add(new ProductDto(2, "Table" , 5000 , "Infra"));
        dtos.add(new ProductDto(3, "Fan" , 500 , "Electronics"));

    }

    @GetMapping(value="/products" )
    public List<ProductDto> getProducts()
    {
        return dtos;

    }

    @GetMapping("/products/{id}")
    public ProductDto getProductById(
            @PathVariable("id") int id
    ){
        for (ProductDto dto : dtos) {
            if(dto.getProductId() == id)
            {
                return dto;
            }

        }
        throw new RuntimeException("Product not found");
    }
    @PostMapping("/addProduct")
    public ProductDto addProduct(
                @RequestBody ProductDto dto
        ){
            dtos.add(dto);
            return dto;
        }

}
