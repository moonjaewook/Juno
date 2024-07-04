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

	// 예약 - 지점선택
	@RequestMapping("/branch")
	public String branch(HttpServletRequest request, Model model) {
		System.out.println("branch()");
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		if (id == null) {
			session.setAttribute("loginCheck", "로그인해주세요.");
			return "Join_Login/Login";
		}

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
		model.addAttribute("branchInfo", dao.selectedBranchInfo(branchId)); // 선택한 지점정보 -> 지점명 출력
																			// ${branchInfo.branchName}

		return "/reservation/designer"; // jsp로 이동
	}
	

	// 예약 - 스케줄
	@RequestMapping("/schedule")
	public String schedule(HttpServletRequest request, Model model) {
		System.out.println("schedule()");
		
		int branchId = Integer.parseInt(request.getParameter("branchId")); // branchId를 int로 변환
		String designerId = request.getParameter("designerId"); // 선택한 디자이너 Id
		
		ReservationIDao dao = sqlSession.getMapper(ReservationIDao.class);

		model.addAttribute("branchInfo", dao.selectedBranchInfo(branchId)); // 선택한 지점정보 -> 지점명 출력 ${branchInfo.branchName}
        model.addAttribute("designerInfo", dao.selectedDesignerInfo(designerId)); // 선택한 디자이너의 인적 정보
        model.addAttribute("designerWorkInfo", dao.selectedDesignerWorkInfo(designerId)); // 선택한 디자이너의 근무 정보
 
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
        model.addAttribute("designerWorkDay", dayList); // 선택한 디자이너의 근무 정보
        
        
        ScheduleCommand command = new ScheduleCommand();
        command.execute(model, branchId, designerId, dao);
        
		return "/reservation/schedule"; // jsp로 이동
	}
	
	// AJAX 요청을 처리하는 메서드 추가
    @RequestMapping(value = "/getBookedTimes", method = RequestMethod.GET)
    @ResponseBody
    public List<String> getBookedTimes(@RequestParam("designerId") String designerId,
                                       @RequestParam("reservationDate") String reservationDate) {
    	
    	
    	log.info("designerId: {}", designerId);
    	log.info("reservationDate: {}", reservationDate);
    	ReservationIDao dao = sqlSession.getMapper(ReservationIDao.class);
    	
        List<ReservationDto> bookedTimes = dao.getBookedTimes(designerId, reservationDate + "%"); // 예약된 시간목록

        // 예약된 시간을 String 리스트로 변환
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
//		System.out.println("컨트롤러들어왔찌롱");
//		
//		int branchId = Integer.parseInt(request.getParameter("branchId")); // branchId를 int로 변환
//		String designerId = request.getParameter("designerId"); // 선택한 디자이너 Id
//		
//		ReservationIDao dao = sqlSession.getMapper(ReservationIDao.class);
//
//		model.addAttribute("branchInfo", dao.selectedBranchInfo(branchId)); // 선택한 지점정보 -> 지점명 출력 ${branchInfo.branchName}
//        model.addAttribute("designerInfo", dao.selectedDesignerInfo(designerId)); // 선택한 디자이너의 인적 정보
//
//		return "/reservation/reservationConfirm"; // jsp로 이동
//	}
	
	@RequestMapping("/reservationConfirm")
    public String insertReservation(HttpServletRequest request, Model model)  {
		
		System.out.println("컨트롤러들어왔찌롱");
		
		
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
          

          model.addAttribute("branchInfo", dao.selectedBranchInfo(Integer.parseInt(branchId))); // 선택한 지점정보 -> 지점명 출력 ${branchInfo.branchName}
          model.addAttribute("designerInfo", dao.selectedDesignerInfo(designerId)); // 선택한 디자이너의 인적 정보

        return "/reservation/reservationConfirm"; // 성공 시 이동할 JSP 페이지
       }
	


	// 예약 - 완료
	@RequestMapping("/done")
	public String done(Model model) {
		System.out.println("done()");

		return "/reservation/done"; // jsp로 이동
	}

}
