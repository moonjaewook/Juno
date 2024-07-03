package com.good.juno.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.good.juno.command.product.BCommand;
import com.good.juno.dao.AdminDao;

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
				request.getParameter("intro"), "일반");
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
		model.addAttribute("errorMessage", "ID 혹은 PW가 일치하지 않습니다!");
		return "Join_Login/Login";
		}
	}
	
	
	
	@RequestMapping("/admin")
	public String admin() {

		return "admin/admin";
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
