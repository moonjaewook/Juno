package com.good.juno.controller;


import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import com.good.juno.dto.ProductCartDto;
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
	
	@RequestMapping("/prodview")
	public String productDetail(@RequestParam("ptype") int ptype, @RequestParam("pid") int pid, Model model) {
			
		ProductIDao dao = sqlSession.getMapper(ProductIDao.class);
		ProductDto dto = dao.productDetail(ptype, pid);
		
		model.addAttribute("productDetail", dto);
		
		return "market/productDetail";
	}
	
	//��ٱ���
	@RequestMapping("/addCart")
	public String addCart(HttpServletRequest request, Model model) {
		
		int ptype = Integer.parseInt(request.getParameter("productType"));
		int pid = Integer.parseInt(request.getParameter("productId"));
		int quantity = Integer.parseInt(request.getParameter("productQuantity"));
		
	    
	    ProductIDao dao = sqlSession.getMapper(ProductIDao.class);
		ProductDto dto = dao.productDetail(ptype, pid);
		
		HttpSession session = request.getSession();
	    List<ProductCartDto> cart = (List<ProductCartDto>) session.getAttribute("cart");
	    if (cart == null) {
	        cart = new ArrayList<ProductCartDto>();
	        session.setAttribute("cart", cart);
	    }
	    
	    boolean existProduct = false;
	    
	    for (ProductCartDto item : cart) {
	        // ������ �̹� �ִ� ��� ���� ������Ʈ
	        if (item.getProduct().getProductId() == dto.getProductId() &&
	            item.getProduct().getProductType() == dto.getProductType()) {
	            item.setQuantity(item.getQuantity() + quantity); // ���� �߰�
	            existProduct = true;
	            break;
	        }
	    }
	    //������ ���� ��ǰ�̶��
	    if (!existProduct) {
	        cart.add(new ProductCartDto(dto, quantity));
	    }
		
	    session.setAttribute("cart", cart);
	    List<ProductCartDto> cart2 = (List<ProductCartDto>) session.getAttribute("cart");
	    
	    //�׽�Ʈ
	    for (ProductCartDto item : cart2) {
	    	
	    	System.out.println(item.getProduct().getName());
	    	System.out.println(item.getProduct().getPrice());
	    	System.out.println(item.getQuantity());

	    }
	    
		return "redirect:jmarket";
	}
	
	@RequestMapping("/deleteCart")
	public String deleteCart(@RequestParam("ptype") int ptype, @RequestParam("pid") int pid, HttpServletRequest request) {
		
		
	    ProductIDao dao = sqlSession.getMapper(ProductIDao.class);
		ProductDto dto = dao.productDetail(ptype, pid);
		
		HttpSession session = request.getSession();
		List<ProductCartDto> cart = (List<ProductCartDto>) session.getAttribute("cart");
		
	    if (cart != null) {
	        Iterator<ProductCartDto> iterator = cart.iterator();
	        while (iterator.hasNext()) {
	            ProductCartDto item = iterator.next();
	            if (item.getProduct().getProductId() == dto.getProductId() &&
	                item.getProduct().getProductType() == dto.getProductType()) {
	                iterator.remove();
	                break;
	            }
	        }
	    }
	    
	    session.setAttribute("cart", cart);
		
		return "redirect:jmarket";
	}
	

}
