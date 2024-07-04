package com.good.juno.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.good.juno.dto.NoticeDto;

public interface CommunicationIDao {
	
	//������ ����Ʈ
	List<NoticeDto> getNoticeList();
	//������ ��
	NoticeDto getNoticeDetail(int id);
	//QNA ������
    void sendQna(@Param("userId") String userId, 
            @Param("userEmail") String userEmail, 
            @Param("title") String title, 
            @Param("content") String content);

}
