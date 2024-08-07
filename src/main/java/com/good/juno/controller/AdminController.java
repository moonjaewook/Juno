package com.good.juno.controller;

import java.util.List;

import javax.mail.MessagingException;
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
import com.good.juno.dao.ProductDao;
import com.good.juno.dto.DesignerDto;
import com.good.juno.dto.OrderDetailProductDto;
import com.good.juno.dto.OrderInfoDto;
import com.good.juno.dto.QnaDto;
import com.good.juno.dto.ReservationDetailDto;

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
	
	@RequestMapping("/admin_designer")
	public String admin_designer() {
		return "admin/admin_designer";
	}

	@RequestMapping("/register2")
	public String register2() {

		return "admin/branch_register";
	}

	@RequestMapping("/RegisterBranchAction")
	public String RegisterBranchAction(MultipartHttpServletRequest request,
			@RequestParam("branch_img") MultipartFile branch_img, Model model) {
		System.out.println("RegisterBranchAction");

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
		System.out.println("RegisterManagerAction");

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
	
	@RequestMapping("admin_designerinfo")
	public String admin_designerinfo(HttpSession session, HttpServletRequest request, Model model) {
		System.out.println("admin_designerinfo");
		
		AdminDao dao = sqlSession.getMapper(AdminDao.class);
		
		String id = (String) session.getAttribute("id");
		System.out.println(dao.workday(id));
		
		model.addAttribute("member", dao.getInfo(id));
		model.addAttribute("designer", dao.getDesignerInfo(id));
		model.addAttribute("branch", dao.branchname(dao.getDesignerInfo(id).getBranchId()));
		model.addAttribute("workday", dao.workday(id));
		
		
		return "admin/designer_modify";
	}
	
	@RequestMapping("admin_designer_modifyAction")
	public String admin_designer_modifyAction(HttpSession session, HttpServletRequest request, Model model) {
		System.out.println("admin_designer_modifyAction");
		
		AdminDao dao = sqlSession.getMapper(AdminDao.class);
		
		String id = (String) session.getAttribute("id");
		
		System.out.println(request.getParameter("pw"));
		System.out.println(request.getParameter("email"));
		

		dao.designer_modify_member(id, request.getParameter("pw"), request.getParameter("email"), request.getParameter("intro"));
		dao.designer_modify_designer(id, request.getParameter("intro"));
	
		dao.delete_workday(id);
		
		String[] workdays =  request.getParameterValues("workdays");
		System.out.println(workdays);
		
		for (String workday : workdays) {
			dao.designer_modify_work(id, workday);
			}
			
		return "redirect:admin_designer";
	}
	
	@RequestMapping("admin_reservation")
	public String designerReservationCheck(HttpServletRequest request, Model model, HttpSession session) {
		
		String id = (String) session.getAttribute("id");
		System.out.println(id);
		
		AdminDao dao = sqlSession.getMapper(AdminDao.class);
		List<ReservationDetailDto> dto = dao.getAllReservationsForDesigner(id);
		
		model.addAttribute("reservations", dto);
		
		return "admin/reservationList";
	}

	@RequestMapping("designer_del")
	public String designer_del(HttpServletRequest request, Model model, HttpSession session) {
		System.out.println("desinger_del");
		AdminDao dao = sqlSession.getMapper(AdminDao.class);
		dao.designer_del(request.getParameter("id"));
		dao.member_del(request.getParameter("id"));

		return "redirect:designerall";

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

	@RequestMapping("/adminqna_reply")
	public String qna_reply(HttpServletRequest request, Model model) {
		System.out.println("qna_reply");

		AdminDao dao = sqlSession.getMapper(AdminDao.class);
		model.addAttribute("qnaId", dao.Qnainfo(request.getParameter("qnaId")));
		return "admin/qna_reply";
	}

	@RequestMapping("/adminqna_replyaction")
	public String qna_replyaction(HttpServletRequest request, Model model) {
		System.out.println("qna_replyaction");

		AdminDao dao = sqlSession.getMapper(AdminDao.class);
		dao.qna_reply(Integer.parseInt(request.getParameter("qnaId")));

		ProductDao pdao = new ProductDao(null);
		try {
			pdao.sendEmail(request.getParameter("userEmail"), request.getParameter("answerContent"));
		} catch (MessagingException e) {
			e.printStackTrace();
		}

		return "redirect:adminqna";
	}
	
	@RequestMapping("/reservationListCheck")
	public String reservationList(Model model) {
		
		AdminDao dao = sqlSession.getMapper(AdminDao.class);
		List<ReservationDetailDto> dto = dao.getAllReservations();
		
		model.addAttribute("reservations", dto);
		
		return "admin/reservationList";
	}
	
	@RequestMapping("/myJuno")
	public String myJuno(HttpServletRequest request, HttpSession session) {
		
		String id = (String) session.getAttribute("id");
		System.out.println("로그인된 id : " + id);
		
		if (id == null) {
			session.setAttribute("loginCheck", "로그인이 필요합니다.");
			return "Join_Login/Login";
		}
		
		return "admin/myJuno";
	}
	
	@RequestMapping("/MyreservationListCheck")
	public String myReservationListCheck(HttpServletRequest request, Model model, HttpSession session) {
		
		String id = (String) session.getAttribute("id");
		System.out.println(id);
		
		AdminDao dao = sqlSession.getMapper(AdminDao.class);
		List<ReservationDetailDto> dto = dao.getAllReservationsForUser(id);
		
		model.addAttribute("reservations", dto);
		
		return "admin/reservationList";
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
