package com.good.juno.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private Logger log = LoggerFactory.getLogger(getClass());
	Command command = null;

	@Autowired
	private SqlSession sqlSession;

	// ���� - ��������
	@RequestMapping("/branch")
	public String branch(HttpServletRequest request, Model model) {
		System.out.println("branch()");
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		if (id == null) {
			session.setAttribute("loginCheck", "�α������ּ���.");
			return "Join_Login/Login";
		}

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
        String[] strDays= {"일","월","화","수","목","금","토"};
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
                                       @RequestParam("reservationDate") String reservationDate) {
    	
    	
    	log.info("designerId: {}", designerId);
    	log.info("reservationDate: {}", reservationDate);
    	ReservationIDao dao = sqlSession.getMapper(ReservationIDao.class);
    	
        List<ReservationDto> bookedTimes = dao.getBookedTimes(designerId, reservationDate + "%"); // ����� �ð����

        // ����� �ð��� String ����Ʈ�� ��ȯ
        List<String> bookedTime = new ArrayList<String>(); 
        for (ReservationDto dto : bookedTimes) {
        	 LocalTime localTime = dto.getReservationTime().toLocalDateTime().toLocalTime();
        	 DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        	 String formattedTime = localTime.format(timeFormatter);
        	 bookedTime.add(formattedTime);
        }
        log.info("bookedTime: {}", bookedTime);
        return bookedTime;
    }
    
 
//	@RequestMapping("/reservationConfirm")
//	public String reservationConfirm(HttpServletRequest request, Model model) {
//		
//		System.out.println("��Ʈ�ѷ��������");
//		
//		int branchId = Integer.parseInt(request.getParameter("branchId")); // branchId�� int�� ��ȯ
//		String designerId = request.getParameter("designerId"); // ������ �����̳� Id
//		
//		ReservationIDao dao = sqlSession.getMapper(ReservationIDao.class);
//
//		model.addAttribute("branchInfo", dao.selectedBranchInfo(branchId)); // ������ �������� -> ������ ��� ${branchInfo.branchName}
//        model.addAttribute("designerInfo", dao.selectedDesignerInfo(designerId)); // ������ �����̳��� ���� ����
//
//		return "/reservation/reservationConfirm"; // jsp�� �̵�
//	}
	
	@RequestMapping("/reservationConfirm")
    public String insertReservation(HttpServletRequest request, Model model)  {
		
		System.out.println("��Ʈ�ѷ��������");
		
		
		System.out.println(request.getParameter("reservationDate"));
		System.out.println(request.getParameter("reservationTime"));
		System.out.println(request.getParameter("userId"));
		System.out.println(request.getParameter("branchId"));
		System.out.println(request.getParameter("designerId"));
		
		String reservationDate = request.getParameter("reservationDate");
		String reservationTime = request.getParameter("reservationTime");
		String userId = request.getParameter("userId");
		String branchId = request.getParameter("branchId");
		String designerId = request.getParameter("designerId");
		
		  ReservationDto reservation = new ReservationDto();
		  reservation.setUserId(userId);
		  reservation.setBranchId(Integer.parseInt(branchId));
		  reservation.setDesignerId(designerId);
		  reservation.setReservationDate(Timestamp.valueOf(reservationDate + " " + reservationTime + ":00"));
		  
		  System.out.println(reservation.getReservationDate());

	        
          ReservationIDao dao = sqlSession.getMapper(ReservationIDao.class);
          dao.insertReservation2(reservation.getReservationDate(), reservation.getUserId(), reservation.getBranchId(), reservation.getDesignerId());
          
          model.addAttribute("reservation", reservation);
          

          model.addAttribute("branchInfo", dao.selectedBranchInfo(Integer.parseInt(branchId))); // ������ �������� -> ������ ��� ${branchInfo.branchName}
          model.addAttribute("designerInfo", dao.selectedDesignerInfo(designerId)); // ������ �����̳��� ���� ����

        return "/reservation/reservationConfirm"; // ���� �� �̵��� JSP ������
       }
	


	// ���� - �Ϸ�
	@RequestMapping("/done")
	public String done(Model model) {
		System.out.println("done()");

		return "/reservation/done"; // jsp�� �̵�
	}

}
