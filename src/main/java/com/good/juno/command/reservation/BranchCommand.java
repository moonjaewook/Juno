package com.good.juno.command.reservation;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.good.juno.dao.ReservationDao;
import com.good.juno.dto.ReservationDto;


public class BranchCommand implements Command {
 
	@Override
	public void execute(Model model) {
		
		ReservationDao dao = new ReservationDao(); // 데이터베이스 접근
		ArrayList<ReservationDto> dtos = dao.branch(); // 데이터베이스에서 branch 목록을 가져오는 메서드, 몇 개일지 모르므로 ArrayList
		model.addAttribute("branch", dtos); // 위에서 담은 ArrayList 타입의 dtos를 branch라는 이름으로 넘겨주기
		
	}

}
