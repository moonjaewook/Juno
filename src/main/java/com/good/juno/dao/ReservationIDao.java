package com.good.juno.dao;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

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
	// public List<ReservationDto> getBookedTimes(String designerId, String reservationDate);
	public List<ReservationDto> getBookedTimes(@Param("designerId") String designerId, @Param("reservationDate") String reservationDate);

	// 예약 데이터베이스에 넣기
	public void insertReservation(ReservationDto reservation);
   
	

}
