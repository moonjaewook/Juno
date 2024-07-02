package com.good.juno.command.reservation;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.good.juno.dao.ReservationDao;
import com.good.juno.dto.ReservationDto;


public class BranchCommand implements Command {
 
	@Override
	public void execute(Model model) {
		
		ReservationDao dao = new ReservationDao(); // �����ͺ��̽� ����
		ArrayList<ReservationDto> dtos = dao.branch(); // �����ͺ��̽����� branch ����� �������� �޼���, �� ������ �𸣹Ƿ� ArrayList
		model.addAttribute("branch", dtos); // ������ ���� ArrayList Ÿ���� dtos�� branch��� �̸����� �Ѱ��ֱ�
		
	}

}
