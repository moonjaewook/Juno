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
import com.good.juno.dao.CommunicationIDao;
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
	public String qna() {
		
		return "communication/qna";
	}
	
	@RequestMapping("/sendMail")
	public String sendMail(HttpServletRequest request, Model model) {
		
		HttpSession session = request.getSession();
		String senderID = (String) session.getAttribute("id");
		//id 기준으로 보낸사람 email 찾는 로직, 찾았다치고
		String email = "test@test.com";
		
		
		
		
		
		

		
		return "communication/qna";
	}
	
}
