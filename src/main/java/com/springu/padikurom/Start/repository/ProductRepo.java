package com.springu.padikurom.Start.repository;

import com.springu.padikurom.Start.model.ProductDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository <ProductDto, Integer> {
public List<ProductDto> findByProductName(String name);

@Query(value = "Select COUNT(*) from start.product_dto as p where p.product_name=:name;",nativeQuery = true)
public int getProductCount(@Param("name")String Pname);

}
