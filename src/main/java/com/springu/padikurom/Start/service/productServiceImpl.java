package com.springu.padikurom.Start.service;

import com.springu.padikurom.Start.model.ProductDto;
import com.springu.padikurom.Start.repository.ProductRepo;
import com.springu.padikurom.Start.response.ProductAlreadyExists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class productServiceImpl implements productService{

    @Autowired
    ProductRepo repo;
   List<ProductDto>dtos=new ArrayList<>();

    @Override
    public List<ProductDto> getProducts() {
        return repo.findAll();
    }

    @Override
    public ProductDto getProductById(int id) {
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
        ProductDto temp=repo.getReferenceById(dto.getProductId());
        if(temp!=null)
        {
            throw new ProductAlreadyExists("Product with ID " + dto.getProductId() + " already exists");
        }
        return repo.save(dto);
    }

    @Override
    public ProductDto updateProduct(int id, ProductDto product) throws Exception {
        ProductDto temp=repo.findById(id).get();
        temp.setProductName(product.getProductName());
        temp.setProductName(product.getProductName());
        temp.setProductCatagory(product.getProductCatagory());
        return repo.save(temp);

    }

    @Override
    public String deleteProduct(int id) throws Exception {
      repo.deleteById(id);
      return "Product deleted";
    }

    @Override
    public List<ProductDto> findByName(String name) {
        return repo.findByProductName(name);
    }
}
