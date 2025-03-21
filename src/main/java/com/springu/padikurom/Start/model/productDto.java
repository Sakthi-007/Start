package com.springu.padikurom.Start.model;

public class productDto {

private int id;
private String productName;
private String productCategory;
private int productPrice;

public productDto(){
    super();
}
public productDto(int id, String productName, String productCategory, int productPrice) {
    this.id = id;
    this.productName = productName;
    this.productCategory = productCategory;
    this.productPrice = productPrice;

}



}
