package com.good.juno.command.reservation;

import org.springframework.ui.Model;

public interface Command {
	
	void execute(Model model); // �ٸ� Ŭ�����鿡�� model��ü�� �Ű������� �޾� �����͸� �߰��ϰų� �����ϵ��� ��
							   // ��Ʈ�ѷ����� ���Ǵ� Model�� ���� �ϰ��� �����͸� ����� �� �ֵ��� �ϱ� ���� ��

}
