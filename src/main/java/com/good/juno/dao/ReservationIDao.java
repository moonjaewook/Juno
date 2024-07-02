package com.good.juno.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.good.juno.dto.ReservationDto;

public interface ReservationIDao {
	
	// 지점 목록 BranchCommand
	public ArrayList<ReservationDto> branch();
	
	// 페이징
	List<ReservationDto> getShopList(Map<String, Object> params);
	
    int getShopListCount(Map<String, Object> params);
	
	
//	// 목록 BListCommand
//	public ArrayList<BDto> list();
//	
//	// 글 상세내용 BContentCommand
//	public BDto contentView(String bId);
//	// 글 상세내용 - 조회수
//	public void upHit(final String bId);
//	
//	// 수정 BModifyCommand
//	public void modify(final String bName, final String bTitle, final String bContent, final int bId);
//	
//	// 삭제 BDeleteCommand
//	public void delete(final String bId);
//	
//	// 답변 등록화면 BReplyViewCommand
//	public BDto reply_view(String str);
//	
//	// 답변 달기 BReplyCommand
//	public void reply(String bName, String bTitle, String bContent, int bGroup, int bStep, int bIndent);
//	// 답변 달기 - 답변 정렬
//	public void replyShape(final int bGroup, final int bStep);
//	
//	// 글 작성
//	public void write(final String bName, final String bTitle, final String bContent);
	

}
