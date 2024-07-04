package com.good.juno.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.good.juno.command.reservation.Command;
import com.good.juno.command.reservation.ScheduleCommand;
import com.good.juno.dao.ReservationIDao;
import com.good.juno.dto.DesignerWorkDto;
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
		model.addAttribute("branchInfo", dao.selectedBranchInfo(branchId)); // ������ �������� -> ������ ���
																			// ${branchInfo.branchName}

		return "/reservation/designer"; // jsp�� �̵�
	}
	
	// ���� - ������
	@RequestMapping(value = "/schedule", method = {RequestMethod.GET, RequestMethod.POST})
    public String schedule(HttpServletRequest request, Model model,
                           @RequestParam(value = "designerId", required = false) String designerId,
                           @RequestParam(value = "reservationDate", required = false) String reservationDate) {
        System.out.println("schedule()");

        // Check if the request is for fetching booked times
        if (designerId != null && reservationDate != null) {
            ReservationIDao dao = sqlSession.getMapper(ReservationIDao.class);
            List<ReservationDto> bookedTimes = dao.getBookedTimes(designerId, reservationDate + "%");

            // ����� �ð��� String ����Ʈ�� ��ȯ
            List<String> bookedTime = new ArrayList<String>();
            for (ReservationDto dto : bookedTimes) {
                bookedTime.add(dto.getReservationTime().toLocalDateTime().toLocalTime().toString());
            }

            // AJAX ��û�� ��� JSON ���·� ��ȯ
            model.addAttribute("bookedTime", bookedTime);
            return "jsonView"; // JSON �������� ������ ��ȯ�ϱ� ���� View ����
        }
        

        // Normal schedule page
        int branchId = Integer.parseInt(request.getParameter("branchId")); // branchId�� int�� ��ȯ

        ReservationIDao dao = sqlSession.getMapper(ReservationIDao.class);

        model.addAttribute("branchInfo", dao.selectedBranchInfo(branchId)); // ������ �������� -> ������ ��� ${branchInfo.branchName}
        model.addAttribute("designerInfo", dao.selectedDesignerInfo(designerId)); // ������ �����̳��� ���� ����
        model.addAttribute("designerWorkInfo", dao.selectedDesignerWorkInfo(designerId)); // ������ �����̳��� �ٹ� ����

        List<DesignerWorkDto> list = dao.selectedDesignerWorkInfo(designerId);

        String[] days = {"0", "1", "2", "3", "4", "5", "6"};
        String[] strDays = {"��", "��", "ȭ", "��", "��", "��", "��"};
        List<String> dayList = new ArrayList<String>();
        for (DesignerWorkDto dto : list) {
            for (int i = 0; i < strDays.length; i++) {
                if (dto.getWorkDay().equals(strDays[i])) {
                    dayList.add(days[i]);
                }
            }
        }
        model.addAttribute("designerWorkDay", dayList); // ������ �����̳��� �ٹ� ����

        ScheduleCommand command = new ScheduleCommand();
        command.execute(model, branchId, designerId, dao);

        return "/reservation/schedule"; // jsp�� �̵�
    }
	
	

	// ���� - ������
	@RequestMapping("/schedule")
	public String schedule(HttpServletRequest request, Model model) {
		System.out.println("schedule()");
		
		int branchId = Integer.parseInt(request.getParameter("branchId")); // branchId�� int�� ��ȯ
		String designerId = request.getParameter("designerId"); // ������ �����̳� Id
		
		ReservationIDao dao = sqlSession.getMapper(ReservationIDao.class);

		model.addAttribute("branchInfo", dao.selectedBranchInfo(branchId)); // ������ �������� -> ������ ��� ${branchInfo.branchName}
        model.addAttribute("designerInfo", dao.selectedDesignerInfo(designerId)); // ������ �����̳��� ���� ����
        model.addAttribute("designerWorkInfo", dao.selectedDesignerWorkInfo(designerId)); // ������ �����̳��� �ٹ� ����
 
        List<DesignerWorkDto> list = dao.selectedDesignerWorkInfo(designerId);
        
        String[] days= {"0","1","2","3","4","5","6"};
        String[] strDays= {"��","��","ȭ","��","��","��","��"};
        List<String> dayList = new ArrayList<String>();
        for(DesignerWorkDto dto : list) {
        	for(int i=0; i < strDays.length; i++) {
        		if(dto.getWorkDay().equals(strDays[i])) {
        			dayList.add(days[i]);
        		}
        	}
        	
        }
        model.addAttribute("designerWorkDay", dayList); // ������ �����̳��� �ٹ� ����
        
        
        ScheduleCommand command = new ScheduleCommand();
        command.execute(model, branchId, designerId, dao);
        
		return "/reservation/schedule"; // jsp�� �̵�
	}
	
	// AJAX ��û�� ó���ϴ� �޼��� �߰�
    @RequestMapping(value = "/getBookedTimes", method = RequestMethod.GET)
    @ResponseBody
    public List<String> getBookedTimes(@RequestParam("designerId") String designerId,
                                       @RequestParam("reservationDate") String reservationDate, Model model) {
    	
    	ReservationIDao dao = sqlSession.getMapper(ReservationIDao.class);
    	
        List<ReservationDto> bookedTimes = dao.getBookedTimes(designerId, reservationDate + "%"); // ����� �ð����

        // ����� �ð��� String ����Ʈ�� ��ȯ
        List<String> bookedTime = new ArrayList<String>(); 
        for (ReservationDto dto : bookedTimes) {
        	bookedTime.add(dto.getReservationTime().toLocalDateTime().toLocalTime().toString());
        }

        return bookedTime;
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
