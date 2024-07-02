package com.good.juno.controller;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.good.juno.command.reservation.Command;
import com.good.juno.command.reservation.PagingCommand;
import com.good.juno.dao.ReservationIDao;


@Controller
// @RequestMapping("/reservation")
public class ReservationController {
	
	Command command = null;
	
	@Autowired
	private SqlSession sqlSession;
	
	
	// 예약 - 지점선택
	@RequestMapping("/branch")
	public String branch(Model model, @RequestParam Map<String, Object> params) {
		System.out.println("branch(), params: " + params);
	
	    
		ReservationIDao dao = sqlSession.getMapper(ReservationIDao.class); // MyBatis를 사용하여 데이터베이스에서 게시글 목록 가져옴
//		model.addAttribute("branch", dao.branch());
		
        PagingCommand pagingCommand = new PagingCommand(dao);
        // params.put("pageNo", pageNum);
        
        Map<String, Object> packages = pagingCommand.getPaginatedList(params);
        model.addAttribute("packages", packages);
		return "/reservation/branch"; // jsp로 이동
	}
	
	// Paging
    @RequestMapping("/getShopList")
    @ResponseBody
    public Map<String, Object> getShopList(@RequestParam Map<String, Object> params) {
    	ReservationIDao dao = sqlSession.getMapper(ReservationIDao.class);
        PagingCommand pagingCommand = new PagingCommand(dao);
        return pagingCommand.getPaginatedList(params);
    }
	
	
	
	
	// 예약 - 디자이너
	@RequestMapping("/designer")
	public String designer(Model model) {
		System.out.println("designer()");
		
		return "/reservation/designer"; // jsp로 이동
	}
	
	// 예약 - 스케줄
	@RequestMapping("/schedule")
	public String schedule(Model model) {
		System.out.println("schedule()");

		return "/reservation/schedule"; // jsp로 이동
	}
	
	// 예약 - 확인
	@RequestMapping("/reservationConfirm")
	public String reservationConfirm(Model model) {
		System.out.println("reservationConfirm()");

		return "/reservation/reservationConfirm"; // jsp로 이동
	}
	
	// 예약 - 완료
	@RequestMapping("/done")
	public String done(Model model) {
		System.out.println("done()");

		return "/reservation/done"; // jsp로 이동
	}

}
