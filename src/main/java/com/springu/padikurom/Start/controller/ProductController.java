package com.springu.padikurom.Start.controller;


import java.util.ArrayList;
import java.util.List;

import com.springu.padikurom.Start.service.productServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.springu.padikurom.Start.model.ProductDto;
@RestController
@RequestMapping("/app")
public class ProductController {

    productServiceImpl service = new productServiceImpl();
//    List<ProductDto> dtos = new ArrayList<>();
//
//
//    public ProductController()
//    {
//        dtos.add(new ProductDto(1, "Chair" , 4000 , "Infra"));
//        dtos.add(new ProductDto(2, "Table" , 5000 , "Infra"));
//        dtos.add(new ProductDto(3, "Fan" , 500 , "Electronics"));
//
//    }

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
