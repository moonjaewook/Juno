package com.good.juno.dao;

import java.util.List;

import com.good.juno.dto.NoticeDto;

public interface CommunicationIDao {
	
	//������ ����Ʈ
	List<NoticeDto> getNoticeList();
	//������ ��
	NoticeDto getNoticeDetail(int id);

}
