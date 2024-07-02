package com.good.juno.command.product;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.good.juno.dao.ProductIDao;
import com.good.juno.dto.ProductDto;


@Component
public class ProductListCommand implements BCommand {

	
	private SqlSession sqlSession;
	
	@Autowired
	public ProductListCommand(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public void execute(Model model) {
		

		ProductIDao dao = sqlSession.getMapper(ProductIDao.class);
		
		List<ProductDto> productList1 = dao.productList1();
		List<ProductDto> productList2 = dao.productList2();
		List<ProductDto> productList3 = dao.productList3();
		List<ProductDto> productList4 = dao.productList4();
		List<ProductDto> productList5 = dao.productList5();
		List<ProductDto> productList6 = dao.productList6();
		List<ProductDto> productList7 = dao.productList7();
		
		model.addAttribute("products1", productList1);
		model.addAttribute("products2", productList2);
		model.addAttribute("products3", productList3);
		model.addAttribute("products4", productList4);
		model.addAttribute("products5", productList5);
		model.addAttribute("products6", productList6);
		model.addAttribute("products7", productList7);
	}

}
