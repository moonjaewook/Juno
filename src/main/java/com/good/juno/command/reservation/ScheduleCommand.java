package com.good.juno.command.reservation;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.Model;

import com.good.juno.dao.ReservationIDao;
import com.good.juno.dto.DesignerDto;
import com.good.juno.dto.ReservationDto;

public class ScheduleCommand implements Command {
	
	@Override
	public void execute(Model model) {
		
	}

	 @Override
	    public void execute(Model model, int branchId, String designerId, ReservationIDao dao) {
	        DesignerDto designerInfo = dao.selectedDesignerInfo(designerId);
	        model.addAttribute("designerInfo", designerInfo);

	        // ���� ��¥�� ������ ���� ��¥ ������ ����
	        LocalDate currentDate = LocalDate.now();
	        YearMonth currentMonth = YearMonth.from(currentDate);
	        YearMonth nextMonth = currentMonth.plusMonths(1);

	        // ���� �� ������
	        LocalDate firstDayCurrent = currentMonth.atDay(1);
	        LocalDate lastDayCurrent = currentMonth.atEndOfMonth();

	        // ���� �� ������
	        LocalDate firstDayNext = nextMonth.atDay(1);
	        LocalDate lastDayNext = nextMonth.atEndOfMonth();

	        List<String> currentMonthDays = getDays(firstDayCurrent, lastDayCurrent);
	        List<String> nextMonthDays = getDays(firstDayNext, lastDayNext);

	        model.addAttribute("currentMonth", currentMonth);
	        model.addAttribute("nextMonth", nextMonth);
	        model.addAttribute("currentMonthDays", currentMonthDays);
	        model.addAttribute("nextMonthDays", nextMonthDays);
	        
//	        int branchId = Integer.parseInt(model.getParameter("branchId"));

	        // ����� �ð��� �����ͼ� �𵨿� �߰�
//	        String reservationDate = currentDate.getYear() + "-" + (currentDate.getMonthValue() < 10 ? "0" + currentDate.getMonthValue() : currentDate.getMonthValue()) + "-%";
//	        List<ReservationDto> bookedTimesList = dao.getBookedTimes(designerId, reservationDate);
//	        List<String> bookedTimes = new ArrayList<String>();
//	        for (ReservationDto dto : bookedTimesList) {
//	            bookedTimes.add(dto.getReservationTime().toLocalDateTime().toLocalTime().toString());
//	        }
//	        model.addAttribute("bookedTimes", bookedTimes);
	    }

	    private List<String> getDays(LocalDate start, LocalDate end) {
	        List<String> days = new ArrayList<String>();
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd"); // ���ڸ� �׻� �� �ڸ��� ����

	        int startDayOfWeek = start.getDayOfWeek().getValue();
	        startDayOfWeek = startDayOfWeek == 7 ? 0 : startDayOfWeek;

	        for (int i = 0; i < startDayOfWeek; i++) {
	            days.add(""); // �� ĭ �߰�
	        }
	        for (LocalDate date = start; !date.isAfter(end); date = date.plusDays(1)) {
	            days.add(formatter.format(date)); // ��¥�� �� �ڸ� ���ڿ��� �߰�
	        }
	        return days;
    }


}