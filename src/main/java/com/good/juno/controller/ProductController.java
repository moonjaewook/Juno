package com.good.juno.controller;


import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.good.juno.command.product.BCommand;
import com.good.juno.command.product.ProductAddTest;
import com.good.juno.command.product.ProductListCommand;
import com.good.juno.dao.ProductDao;
import com.good.juno.dao.ProductIDao;
import com.good.juno.dto.ProductDto;


@Controller
public class ProductController {

	BCommand command = null;
	
	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	private ProductDao productDao;
	
	@RequestMapping("/ProductAddTest")
	public String productAddTest() {
		
		return "market/productAddTest";
	}
	
    @RequestMapping("/ProductAdd")
    public String productAdd(MultipartHttpServletRequest request, 
                             @RequestParam("productImg1") MultipartFile productImg1,
                             @RequestParam("productImg2") MultipartFile productImg2,
                             @RequestParam("productDetailImg") MultipartFile productDetailImg,
                             Model model) {
        
        model.addAttribute("request", request);
        model.addAttribute("productImg1", productImg1);
        model.addAttribute("productImg2", productImg2);
        model.addAttribute("productDetailImg", productDetailImg);
        
        command = new ProductAddTest(productDao);
        command.execute(model);
		
		return "redirect:jmarket";
	}
	
	
	@RequestMapping("/jmarket")
	public String market(Model model) {
		
		command = new ProductListCommand(sqlSession);
		command.execute(model);
	       
		return "market/productList";
	}
	
	@RequestMapping("/jmarket/prodview")
	public String productDetail(@RequestParam("ptype") int ptype, @RequestParam("pid") int pid, Model model) {
		
		System.out.println(ptype);
		System.out.println(pid);
		
		ProductIDao dao = sqlSession.getMapper(ProductIDao.class);
		ProductDto dto = dao.productDetail(ptype, pid);
		
		model.addAttribute("productDetail", dto);
		
		return "market/productDetail";
	}
}
