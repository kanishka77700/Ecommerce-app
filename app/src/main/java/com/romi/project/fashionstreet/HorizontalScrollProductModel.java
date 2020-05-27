package com.romi.project.fashionstreet;

public class HorizontalScrollProductModel {

    private int productImage;
    private String productName,productDetails,productPrice;

    public HorizontalScrollProductModel(int productImage, String productName, String productDetails, String productPrice) {
        this.productImage = productImage;
        this.productName = productName;
        this.productDetails = productDetails;
        this.productPrice = productPrice;
    }

    public int getProductImage() {
        return productImage;
    }

    public void setProductImage(int productImage) {
        this.productImage = productImage;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(String productDetails) {
        this.productDetails = productDetails;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }
}
