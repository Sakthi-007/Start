package com.springu.padikurom.Start.service;

import com.springu.padikurom.Start.model.ProductDto;
import com.springu.padikurom.Start.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class productServiceImpl implements productService{

    @Autowired
    ProductRepo repo;
   List<ProductDto>dtos=new ArrayList<>();
//    public productServiceImpl(){
//        dtos.add(new ProductDto(1, "Chair" , 4000 , "Infra"));
//        dtos.add(new ProductDto(2, "Table" , 5000 , "Infra"));
//        dtos.add(new ProductDto(3, "Fan" , 500 , "Electronics"));
//    }

    @Override
    public List<ProductDto> getProducts() {
        return repo.findAll();
    }

    @Override
    public ProductDto getProductById(int id) {
//        for (ProductDto dto : dtos) {
//            if(dto.getProductId() == id)
//            {
//                return dto;
//            }
//
//        }
        List<ProductDto> list= repo.findAll();
        for(ProductDto dto:list){
            if(dto.getProductId()==id)
            {
                return dto;
            }
        }
        throw new RuntimeException("Product not found");
    }

    @Override
    public ProductDto addProduct(ProductDto dto) {
//        dtos.add(dto);
//        return dto;
        return repo.save(dto);
    }

    @Override
    public ProductDto updateProduct(int id, ProductDto product) throws Exception {
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

    @Override
    public String deleteProduct(int id) throws Exception {
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
