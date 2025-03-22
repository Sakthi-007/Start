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
        @PutMapping("/updateProduct/{id}")
    public ProductDto updateProduct(
            @PathVariable("id")int id,
            @RequestBody ProductDto product
        ) throws Exception {
            for(ProductDto dto:dtos){
                if(dto.getProductId()==id)
                {
                    dto.setProductName(product.getProductName());
                    dto.setProductPrice(product.getProductPrice());
                    dto.setProductCatagory(product.getProductCatagory());
                    return dto;
                }
            }
         throw new Exception("Product not found");
        }

        @DeleteMapping("/deleteProduct/{id}")
        public String deleteProduct(
                @PathVariable("id")int id
        ){
            for(ProductDto dto:dtos){
                if(dto.getProductId()==id)
                {
                    dtos.remove(dto);
                    return "Product Deleted";
                }
            }
            return "Product not found";
        }
}
