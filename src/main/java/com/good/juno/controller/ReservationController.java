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
	
	
	// ���� - ��������
	@RequestMapping("/branch")
	public String branch(Model model) {
		System.out.println("branch()");
		
		ReservationIDao dao = sqlSession.getMapper(ReservationIDao.class); 
		model.addAttribute("branch", dao.branchList()); // �����ͺ��̽����� branch ����� �����ͼ� �Ѱ��ֱ�
		
		return "/reservation/branch"; // jsp�� �̵�
	}
	
//	// Paging
//    @RequestMapping("/getShopList")
//    @ResponseBody
//    public Map<String, Object> getShopList(@RequestParam Map<String, Object> params) {
//    	ReservationIDao dao = sqlSession.getMapper(ReservationIDao.class);
//        PagingCommand pagingCommand = new PagingCommand(dao);
//        return pagingCommand.getPaginatedList(params);
//    }
	
    
	// ���� - �����̳�
    @RequestMapping("/designer")
    public String designer(HttpServletRequest request, Model model) {
    	System.out.println("designer()");
    	
    	int branchId = Integer.parseInt(request.getParameter("branchId")); // branchId�� int�� ��ȯ
    	
    	ReservationIDao dao = sqlSession.getMapper(ReservationIDao.class);
    	
		model.addAttribute("designers", dao.designerList(branchId)); // �����̳� ���
		model.addAttribute("branchInfo", dao.selectedBranchInfo(branchId)); // ������ �������� -> ������ ��� ${branchInfo.branchName}
	
		return "/reservation/designer"; // jsp�� �̵�
	}
	
    
	// ���� - ������
	@RequestMapping("/schedule")
	public String schedule(HttpServletRequest request, Model model) {
		System.out.println("schedule()");
		
		int branchId = Integer.parseInt(request.getParameter("branchId")); // branchId�� int�� ��ȯ
		int designerId = Integer.parseInt(request.getParameter("designerId")); // ������ �����̳� Id
		
		ReservationIDao dao = sqlSession.getMapper(ReservationIDao.class);

		model.addAttribute("branchInfo", dao.selectedBranchInfo(branchId)); // ������ �������� -> ������ ��� ${branchInfo.branchName}
        model.addAttribute("designerInfo", dao.selectedDesignerInfo(designerId)); // ������ �����̳��� ���� ����
        model.addAttribute("designerWorkInfo", dao.selectedDesignerWorkInfo(designerId)); // ������ �����̳��� �ٹ� ����
        
        ScheduleCommand command = new ScheduleCommand();
        command.execute(model, branchId, designerId, dao);
		return "/reservation/schedule"; // jsp�� �̵�
	}

	
	
	
	
	// ���� - Ȯ��
	@RequestMapping("/reservationConfirm")
	public String reservationConfirm(Model model) {
		System.out.println("reservationConfirm()");

		return "/reservation/reservationConfirm"; // jsp�� �̵�
	}
	
	// ���� - �Ϸ�
	@RequestMapping("/done")
	public String done(Model model) {
		System.out.println("done()");

		return "/reservation/done"; // jsp�� �̵�
	}

}
