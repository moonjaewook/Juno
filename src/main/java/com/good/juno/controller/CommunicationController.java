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

import com.good.juno.command.reservation.Command;
import com.good.juno.dao.AdminDao;
import com.good.juno.dao.CommunicationIDao;
import com.good.juno.dto.LoginDto;
import com.good.juno.dto.NoticeDto;

@Controller
public class CommunicationController {
	Command command = null;
	
	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping("/news")
	public String news(Model model) {
		
		CommunicationIDao dao = sqlSession.getMapper(CommunicationIDao.class);
		List<NoticeDto> noticeList = dao.getNoticeList();
		
		model.addAttribute("noticeList", noticeList);
		
		return "communication/news";
	}
	
	@RequestMapping("/noticeDetail")
	public String newsDetail(@RequestParam("id") int id, Model model) {
		
		CommunicationIDao dao = sqlSession.getMapper(CommunicationIDao.class);
		NoticeDto dto = dao.getNoticeDetail(id);
		
		model.addAttribute("notice", dto);
		
		return "communication/newsDetail";
	}
	
	@RequestMapping("/qna")
	public String qna(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		System.out.println("로그인된 id : " + id);
		
		if (id == null) {
			session.setAttribute("loginCheck", "로그인이 필요합니다.");
			return "Join_Login/Login";
		}
		
		AdminDao dao = sqlSession.getMapper(AdminDao.class);
		LoginDto dto = dao.getInfo(id);
		
		model.addAttribute("userInfo", dto);
		
		return "communication/qna";
	}
	
	@RequestMapping("/sendQna")
	public String sendMail(HttpServletRequest request, Model model) {
		
		//작업필요
		String userId = request.getParameter("userId");
		String userEmail = request.getParameter("userEmail");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		CommunicationIDao dao = sqlSession.getMapper(CommunicationIDao.class);
		dao.sendQna(userId, userEmail, title, content);
		
		HttpSession session = request.getSession();
		session.setAttribute("qnaOk", "QNA가 전송되었습니다.");
		
		return "communication/qna";
	}
	
}
