package com.good.juno.command.reservation;

import java.util.Map;

import org.springframework.ui.Model;

import com.good.juno.dao.ReservationIDao;

public interface Command {
	
	void execute(Model model); // �ٸ� Ŭ�����鿡�� model��ü�� �Ű������� �޾� �����͸� �߰��ϰų� �����ϵ��� ��
							   // ��Ʈ�ѷ����� ���Ǵ� Model�� ���� �ϰ��� �����͸� ����� �� �ֵ��� �ϱ� ���� ��

	void execute(Model model, int branchId, String designerId, ReservationIDao dao);
}
