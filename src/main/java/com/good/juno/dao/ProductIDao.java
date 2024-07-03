package com.good.juno.dao;

import java.util.ArrayList;

import com.good.juno.dto.ProductDto;


public interface ProductIDao {
	
	 //�׽�Ʈ��
	 void insertProduct(ProductDto product);
	 
	 //��ǰ����Ʈ�ҷ�����
	 ArrayList<ProductDto> productList1();
	 ArrayList<ProductDto> productList2();
	 ArrayList<ProductDto> productList3();
	 ArrayList<ProductDto> productList4();
	 ArrayList<ProductDto> productList5();
	 ArrayList<ProductDto> productList6();
	 ArrayList<ProductDto> productList7();
	 
	 //��ǰ��
	 ProductDto productDetail(int ptype, int pid);
	 
	 //�ֹ���ȣã��
	 int getOrderNum();
	 //�ֹ����̺�
	 void insertOrder(int orderId, String id);
	 //�ֹ������̺�
	 void insertOrderDetail(int orderId, String productName, String productId, String quantity);
	 
}
