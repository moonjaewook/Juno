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
import com.good.juno.dao.AdminDao;
import com.good.juno.dao.ProductDao;
import com.good.juno.dao.ProductIDao;
import com.good.juno.dto.LoginDto;
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
	
	//상품리스트
	@RequestMapping("/jmarket")
	public String market(Model model) {
		
		command = new ProductListCommand(sqlSession);
		command.execute(model);
	       
		return "market/productList";
	}
	
	//상품상세
	@RequestMapping("/prodview")
	public String productDetail(@RequestParam("ptype") int ptype, @RequestParam("pid") int pid, Model model) {
			
		ProductIDao dao = sqlSession.getMapper(ProductIDao.class);
		ProductDto dto = dao.productDetail(ptype, pid);
		
		model.addAttribute("productDetail", dto);
		
		return "market/productDetail";
	}
	
	//장바구니
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
	        // 기존에 이미 있는 경우 수량 업데이트
	        if (item.getProduct().getProductId() == dto.getProductId() &&
	            item.getProduct().getProductType() == dto.getProductType()) {
	            item.setQuantity(item.getQuantity() + quantity); // 수량 추가
	            existProduct = true;
	            break;
	        }
	    }
	    //기존에 없던 상품이라면
	    if (!existProduct) {
	        cart.add(new ProductCartDto(dto, quantity));
	    }
		
	    session.setAttribute("cart", cart);
	    List<ProductCartDto> cart2 = (List<ProductCartDto>) session.getAttribute("cart");
	    
	    //테스트
	    for (ProductCartDto item : cart2) {
	    	
	    	System.out.println(item.getProduct().getName());
	    	System.out.println(item.getProduct().getPrice());
	    	System.out.println(item.getQuantity());

	    }
	    
		return "redirect:jmarket";
	}
	
	//장바구니에서 특정 목록 삭제
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
	
	//구매하기 페이지1
	@RequestMapping("/purchase")
	public String purchase(HttpServletRequest request, Model model) {
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		System.out.println("로그인된 id : " + id);
		
		if (id == null) {
			session.setAttribute("loginCheck", "로그인이 필요합니다.");
			return "Join_Login/Login";
		}
		
		AdminDao dao = sqlSession.getMapper(AdminDao.class);
		LoginDto user = dao.getInfo(id);
		model.addAttribute("user", user);
		
		List<ProductCartDto> cart = (List<ProductCartDto>) session.getAttribute("cart");
		
		return "market/orderStep1";
	}
	
	//주문처리
	@RequestMapping("/order")
	public String order(HttpServletRequest request, Model model) {
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		ProductIDao dao = sqlSession.getMapper(ProductIDao.class);
		//결제테이블에서 마지막 주문번호 가져오기
		int orderId = dao.getOrderNum();
		orderId++;
		//결제테이블에 insert
		dao.insertOrder(orderId, id);
		
	    int totalItems = Integer.parseInt(request.getParameter("totalItems")); // 총 상품 개수
	    
	    System.out.println("상품 총 개수" + totalItems);
	    for (int i = 0; i < totalItems; i++) {
	    	//String productName = request.getParameter("productName_" + i);
	        String productType = request.getParameter("productType_" + i);
	        String productId = request.getParameter("productId_" + i);
	        String quantity = request.getParameter("productQuantity_" + i);
	        
	        System.out.println(i + "번째 항목");
	        System.out.println(orderId);
	        System.out.println(productType);
	        System.out.println(productId);
	        System.out.println(quantity);

	        dao.insertOrderDetail(orderId, productType, productId, quantity);

	    }
		
		return "market/orderStep2";
	}
	

}
