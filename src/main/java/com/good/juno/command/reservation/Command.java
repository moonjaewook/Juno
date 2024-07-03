package com.good.juno.command.reservation;

import java.util.Map;

import org.springframework.ui.Model;

import com.good.juno.dao.ReservationIDao;

public interface Command {
	
	void execute(Model model); // 다른 클래스들에서 model객체를 매개변수로 받아 데이터를 추가하거나 변경하도록 함
							   // 컨트롤러에서 사용되는 Model을 통해 일관된 데이터를 사용할 수 있도록 하기 위한 것

	void execute(Model model, int branchId, String designerId, ReservationIDao dao);
}
