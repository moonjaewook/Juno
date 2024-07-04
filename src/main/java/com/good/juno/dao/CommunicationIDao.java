package com.good.juno.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.good.juno.dto.NoticeDto;

public interface CommunicationIDao {
	
	//공지글 리스트
	List<NoticeDto> getNoticeList();
	//공지글 상세
	NoticeDto getNoticeDetail(int id);
	//QNA 보내기
    void sendQna(@Param("userId") String userId, 
            @Param("userEmail") String userEmail, 
            @Param("title") String title, 
            @Param("content") String content);

}
