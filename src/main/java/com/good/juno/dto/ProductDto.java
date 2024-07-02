package com.good.juno.dto;

public class ProductDto {
	
	private int productType; //상품구분
	private int productId; //상품번호
    private String name; //상품명
    private int price; //상품가격
    private String productDes; //상품설명
    private String productKeyword; //키워드
    private String productToWho; //추천고객
    private String productSmell; //향
    private String productIngr; //주요성분
    private String productImg1; //썸넬1
    private String productImg2; //썸넬2
    private String productDetailImg; //상세이미지
    
    
	public int getProductType() {
		return productType;
	}
	public void setProductType(int productType) {
		this.productType = productType;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
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
	public String getProductDes() {
		return productDes;
	}
	public void setProductDes(String productDes) {
		this.productDes = productDes;
	}
	public String getProductKeyword() {
		return productKeyword;
	}
	public void setProductKeyword(String productKeyword) {
		this.productKeyword = productKeyword;
	}
	public String getProductToWho() {
		return productToWho;
	}
	public void setProductToWho(String productToWho) {
		this.productToWho = productToWho;
	}
	public String getProductSmell() {
		return productSmell;
	}
	public void setProductSmell(String productSmell) {
		this.productSmell = productSmell;
	}
	public String getProductIngr() {
		return productIngr;
	}
	public void setProductIngr(String productIngr) {
		this.productIngr = productIngr;
	}
	public String getProductImg1() {
		return productImg1;
	}
	public void setProductImg1(String productImg1) {
		this.productImg1 = productImg1;
	}
	public String getProductImg2() {
		return productImg2;
	}
	public void setProductImg2(String productImg2) {
		this.productImg2 = productImg2;
	}
	public String getProductDetailImg() {
		return productDetailImg;
	}
	public void setProductDetailImg(String productDetailImg) {
		this.productDetailImg = productDetailImg;
	}
    
    
}
