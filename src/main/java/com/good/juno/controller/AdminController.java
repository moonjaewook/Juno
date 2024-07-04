package com.good.juno.controller;

import java.util.List;

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

import com.good.juno.command.admin.BCommand;
import com.good.juno.command.admin.BranchRegister;
import com.good.juno.command.admin.DesignerRegister;
import com.good.juno.dao.AdminDao;
import com.good.juno.dto.DesignerDto;
import com.good.juno.dto.OrderDetailProductDto;
import com.good.juno.dto.OrderInfoDto;
import com.good.juno.dto.QnaDto;

@Controller
public class AdminController {

	BCommand command = null;

	@Autowired
	private SqlSession sqlSession;

	@RequestMapping("/Login")
	public String Login() {

		return "Join_Login/Login";
	}

	@RequestMapping("/Join1")
	public String Join1() {

		return "Join_Login/Join1";
	}

	@RequestMapping("/Join2")
	public String Join2() {

		return "Join_Login/Join2";
	}

	@RequestMapping("/JoinAction")
	public String JoinAction(HttpServletRequest request, Model model) {
		System.out.println("Join");

		AdminDao dao = sqlSession.getMapper(AdminDao.class);
		dao.memberInsert(request.getParameter("id"), request.getParameter("pw"), request.getParameter("email"),
				request.getParameter("name"),
				request.getParameter("year") + request.getParameter("month") + request.getParameter("day"),
				request.getParameter("intro"), "�씪諛�");
		return "Join_Login/Login";
	}

	@RequestMapping("/LoginAction")
	public String LoginAction(HttpServletRequest request, Model model, HttpSession session) {
		System.out.println("Login");

		AdminDao dao = sqlSession.getMapper(AdminDao.class);
		System.out.println("id: " + request.getParameter("id"));
		System.out.println("pw: " + request.getParameter("pw"));
		System.out.println("admin: " + dao.admin(request.getParameter("id")));

		if (dao.membercheck(request.getParameter("id"), request.getParameter("pw")) == 1) {
			session.setAttribute("id", request.getParameter("id"));
			session.setAttribute("name", request.getParameter("name"));
			session.setAttribute("email", request.getParameter("email"));
			session.setAttribute("admin", dao.admin(request.getParameter("id")));
			System.out.println(1);
			return "home";
		} else {
			System.out.println(2);
			model.addAttribute("errorMessage", "ID �샊�� PW媛� �씪移섑븯吏� �븡�뒿�땲�떎!");
			return "Join_Login/Login";
		}
	}

	@RequestMapping("/admin")
	public String admin() {

		return "admin/admin";
	}

	@RequestMapping("/register2")
	public String register2() {

		return "admin/branch_register";
	}

	@RequestMapping("/RegisterBranchAction")
	public String RegisterBranchAction(MultipartHttpServletRequest request,
			@RequestParam("branch_img") MultipartFile branch_img, Model model) {
		System.out.println("吏��젏 �벑濡� 而⑦듃濡ㅻ윭");

		model.addAttribute("request", request);
		model.addAttribute("branch_img", branch_img);

		command = new BranchRegister(sqlSession);
		command.execute(model);

		return "redirect:branch";
	}

	@RequestMapping("/register1")
	public String register1(Model model) {
		AdminDao dao = sqlSession.getMapper(AdminDao.class);
		List<String> branches = dao.branchlist();
		model.addAttribute("branches", branches);
		return "admin/designer_register";
	}

	@RequestMapping("/RegisterManagerAction")
	public String RegisterManagerAction(MultipartHttpServletRequest request,
			@RequestParam("profile") MultipartFile profile, Model model) {
		System.out.println("�뵒�옄�씠�꼫 �벑濡� 而⑦듃濡ㅻ윭");

		model.addAttribute("request", request);
		model.addAttribute("profile", profile);

		command = new DesignerRegister(sqlSession);
		command.execute(model);

		return "admin/admin";
	}

	@RequestMapping("designerall")
	public String designerall(HttpServletRequest request, Model model, HttpSession session) {
		System.out.println("desingerall");

		AdminDao dao = sqlSession.getMapper(AdminDao.class);
		List<DesignerDto> designer_all = dao.desingerall();
		model.addAttribute("designer_all", designer_all);
		return "admin/designer_all";
	}

	@RequestMapping("/adminqna")
	public String qna(Model model) {
		
		AdminDao dao = sqlSession.getMapper(AdminDao.class);
		List<QnaDto> qnaList = dao.getAllQna();
		
		model.addAttribute("qnaList", qnaList);
		
		return "admin/qnaList";
	}
	
	@RequestMapping("/orderListCheck")
	public String orderListCheck(Model model) {
		
		AdminDao dao = sqlSession.getMapper(AdminDao.class);
		List<OrderInfoDto> orders = dao.getAllOrders();
		
		model.addAttribute("orders", orders);
		
		return "admin/orderListCheck";
	}
	
	@RequestMapping("/orderDetails")
	public String orderDetails(@RequestParam("orderid") int orderid, Model model) {
		
		AdminDao dao = sqlSession.getMapper(AdminDao.class);
		List<OrderDetailProductDto> detail = dao.getOrderDetails(orderid);
		
		model.addAttribute("detail", detail);
		
		return "admin/orderListDetail";
	}

	@RequestMapping("/Logout")
	public String logoutAction(HttpServletRequest request, Model model, HttpSession session) {

		model.addAttribute("request", request);

		if (session != null) {
			session.invalidate();
		}

		return "home";
	}

}
