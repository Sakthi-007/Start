package com.springu.padikurom.Start.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.stereotype.Component;

@Component
@Entity
public class ProductDto {
    @Id
    private int productId;

    @Column(name="product_name")
    private String productName;

    @Column(name="product_price")
    private Integer productPrice;

    @Column(name="product_cat")
    private String productCatagory;

    public ProductDto() {
        super();
    }


    public ProductDto(int productId, String productName, Integer productPrice, String productCatagory) {
        super();
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productCatagory = productCatagory;
    }





    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Integer productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductCatagory() {
        return productCatagory;
    }

    public void setProductCatagory(String productCatagory) {
        this.productCatagory = productCatagory;
    }


    public int getProductId() {
        return productId;
    }


    public void setProductId(int productId) {
        this.productId = productId;
    }



    @Override
    public String toString() {
        return "ProductDto [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
                + ", productCatagory=" + productCatagory + "]";
    }

}
