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
	public List<ReservationDto> getBookedTimes(String designerId, String reservationDate);
    
 
    
    
	
//	// ��� BListCommand
//	public ArrayList<BDto> list();
//	
//	// �� �󼼳��� BContentCommand
//	public BDto contentView(String bId);
//	// �� �󼼳��� - ��ȸ��
//	public void upHit(final String bId);
//	
//	// ���� BModifyCommand
//	public void modify(final String bName, final String bTitle, final String bContent, final int bId);
//	
//	// ���� BDeleteCommand
//	public void delete(final String bId);
//	
//	// �亯 ���ȭ�� BReplyViewCommand
//	public BDto reply_view(String str);
//	
//	// �亯 �ޱ� BReplyCommand
//	public void reply(String bName, String bTitle, String bContent, int bGroup, int bStep, int bIndent);
//	// �亯 �ޱ� - �亯 ����
//	public void replyShape(final int bGroup, final int bStep);
//	
//	// �� �ۼ�
//	public void write(final String bName, final String bTitle, final String bContent);
	

}
