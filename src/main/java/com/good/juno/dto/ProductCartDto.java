package com.good.juno.dto;

public class ProductCartDto {
	
    private ProductDto product;
    private int quantity;

    public ProductCartDto(ProductDto product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    // Getter and Setter
    public ProductDto getProduct() {
        return product;
    }

    public void setProduct(ProductDto product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
