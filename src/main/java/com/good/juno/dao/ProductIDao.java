package com.good.juno.dao;

import java.util.ArrayList;

import com.good.juno.dto.ProductDto;


public interface ProductIDao {
	
	 //테스트용
	 void insertProduct(ProductDto product);
	 
	 //상품리스트불러오기
	 ArrayList<ProductDto> productList1();
	 ArrayList<ProductDto> productList2();
	 ArrayList<ProductDto> productList3();
	 ArrayList<ProductDto> productList4();
	 ArrayList<ProductDto> productList5();
	 ArrayList<ProductDto> productList6();
	 ArrayList<ProductDto> productList7();
	 
	 //상품상세
	 ProductDto productDetail(int ptype, int pid);
	 
}
