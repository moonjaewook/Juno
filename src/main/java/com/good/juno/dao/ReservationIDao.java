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
	
	// ���� ���
	public ArrayList<BranchDto> branchList();
	
	// ����¡
//	public List<ReservationDto> getShopList(Map<String, Object> params);
//    int getShopListCount(Map<String, Object> params);
    
    // (������ ������) �����̳� ��� ��ȸ 
    public List<DesignerDto> designerList(int branchId);
    // (������ ������) ���� ����
    public BranchDto selectedBranchInfo(int branchId); 
    
    // ������ �����̳��� (����)����
    public DesignerDto selectedDesignerInfo(String designerId);
    
    
    // ������ �����̳��� (�ٹ�)����
    public List<DesignerWorkDto> selectedDesignerWorkInfo(String designerId);

    // Ư�� �����̳��� Ư�� ��¥�� ���� ����� �ð� ��ȸ
	// public List<ReservationDto> getBookedTimes(String designerId, String reservationDate);
	public List<ReservationDto> getBookedTimes(@Param("designerId") String designerId, @Param("reservationDate") String reservationDate);

	// ���� �����ͺ��̽��� �ֱ�
	public void insertReservation(ReservationDto reservation);
   
	

}
