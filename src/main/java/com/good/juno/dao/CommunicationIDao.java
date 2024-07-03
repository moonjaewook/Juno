package com.good.juno.dao;

import java.util.List;

import com.good.juno.dto.NoticeDto;

public interface CommunicationIDao {
	
	//공지글 리스트
	List<NoticeDto> getNoticeList();
	//공지글 상세
	NoticeDto getNoticeDetail(int id);

}
