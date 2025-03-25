package com.springu.padikurom.Start.repository;

import com.springu.padikurom.Start.model.ProductDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository <ProductDto, Integer> {
public List<ProductDto> findByProductName(String name);

}
