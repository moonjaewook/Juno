package com.good.juno.dto;

public class OrderDetailProductDto {
    private int orderid;
    private int producttype;
    private int productid;
    private int quantity;
    private String name;
    private int price;
    private String productImg1;
    
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public int getProducttype() {
		return producttype;
	}
	public void setProducttype(int producttype) {
		this.producttype = producttype;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getProductImg1() {
		return productImg1;
	}
	public void setProductImg1(String productImg1) {
		this.productImg1 = productImg1;
	}
}
