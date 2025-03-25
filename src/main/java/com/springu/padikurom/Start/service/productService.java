package com.springu.padikurom.Start.service;

import com.springu.padikurom.Start.model.ProductDto;

import java.util.List;

public interface productService {

    public List<ProductDto> getProducts();
    public ProductDto getProductById(int id);
    public ProductDto addProduct(ProductDto dto);
    public ProductDto updateProduct(int id, ProductDto product) throws Exception;
    public String deleteProduct(int id) throws Exception;
    public List<ProductDto>findByName(String name);
}
