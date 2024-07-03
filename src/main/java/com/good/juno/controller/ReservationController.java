package com.good.juno.controller;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.good.juno.command.reservation.Command;
import com.good.juno.command.reservation.ScheduleCommand;
import com.good.juno.dao.ReservationIDao;
import com.good.juno.dto.ReservationDto;


@Controller
// @RequestMapping("/reservation")
public class ReservationController {
	
	Command command = null;
	
	@Autowired
	private SqlSession sqlSession;
	
	
	// 예약 - 지점선택
	@RequestMapping("/branch")
	public String branch(Model model) {
		System.out.println("branch()");
		
		ReservationIDao dao = sqlSession.getMapper(ReservationIDao.class); 
		model.addAttribute("branch", dao.branchList()); // 데이터베이스에서 branch 목록을 가져와서 넘겨주기
		
		return "/reservation/branch"; // jsp로 이동
	}
	
//	// Paging
//    @RequestMapping("/getShopList")
//    @ResponseBody
//    public Map<String, Object> getShopList(@RequestParam Map<String, Object> params) {
//    	ReservationIDao dao = sqlSession.getMapper(ReservationIDao.class);
//        PagingCommand pagingCommand = new PagingCommand(dao);
//        return pagingCommand.getPaginatedList(params);
//    }
	
    
	// 예약 - 디자이너
    @RequestMapping("/designer")
    public String designer(HttpServletRequest request, Model model) {
    	System.out.println("designer()");
    	
    	int branchId = Integer.parseInt(request.getParameter("branchId")); // branchId를 int로 변환
    	
    	ReservationIDao dao = sqlSession.getMapper(ReservationIDao.class);
    	
		model.addAttribute("designers", dao.designerList(branchId)); // 디자이너 목록
		model.addAttribute("branchInfo", dao.selectedBranchInfo(branchId)); // 선택한 지점정보 -> 지점명 출력 ${branchInfo.branchName}
	
		return "/reservation/designer"; // jsp로 이동
	}
	
    
	// 예약 - 스케줄
	@RequestMapping("/schedule")
	public String schedule(HttpServletRequest request, Model model) {
		System.out.println("schedule()");
		
		int branchId = Integer.parseInt(request.getParameter("branchId")); // branchId를 int로 변환
		int designerId = Integer.parseInt(request.getParameter("designerId")); // 선택한 디자이너 Id
		
		ReservationIDao dao = sqlSession.getMapper(ReservationIDao.class);

		model.addAttribute("branchInfo", dao.selectedBranchInfo(branchId)); // 선택한 지점정보 -> 지점명 출력 ${branchInfo.branchName}
        model.addAttribute("designerInfo", dao.selectedDesignerInfo(designerId)); // 선택한 디자이너의 인적 정보
        model.addAttribute("designerWorkInfo", dao.selectedDesignerWorkInfo(designerId)); // 선택한 디자이너의 근무 정보
        
        ScheduleCommand command = new ScheduleCommand();
        command.execute(model, branchId, designerId, dao);
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
