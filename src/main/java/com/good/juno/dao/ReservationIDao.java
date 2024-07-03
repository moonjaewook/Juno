package com.good.juno.dao;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;

import com.good.juno.dto.DesignerDto;
import com.good.juno.dto.DesignerWorkDto;
import com.good.juno.dto.ReservationDto;
import com.good.juno.dto.BranchDto;
import java.sql.Timestamp;

public interface ReservationIDao {
	
	// 지점 목록
	public ArrayList<BranchDto> branchList();
	
	// 페이징
//	public List<ReservationDto> getShopList(Map<String, Object> params);
//    int getShopListCount(Map<String, Object> params);
    
    // (선택한 지점의) 디자이너 목록 조회 
    public List<DesignerDto> designerList(int branchId);
    // (선택한 지점의) 지점 정보
    public BranchDto selectedBranchInfo(int branchId); 
    
    // 선택한 디자이너의 (인적)정보
    public DesignerDto selectedDesignerInfo(String designerId);
    
    // 선택한 디자이너의 (근무)정보
    public List<DesignerWorkDto> selectedDesignerWorkInfo(String designerId);

    // 특정 디자이너의 특정 날짜에 대한 예약된 시간 조회
	public List<ReservationDto> getBookedTimes(String designerId, String reservationDate);
    
 
    
    
	
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
