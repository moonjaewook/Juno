package com.good.juno.dao;

import java.util.List;

import com.good.juno.dto.DesignerDto;
import com.good.juno.dto.LoginDto;
import com.good.juno.dto.OrderDetailProductDto;
import com.good.juno.dto.OrderInfoDto;
import com.good.juno.dto.QnaDto;

public interface AdminDao {

	public int memberInsert(String id, String pw, String email, String name, String Birth, String intro, String admin);

	public int membercheck(String id, String pw);

	public LoginDto getInfo(String id);

	public DesignerDto getDesignerInfo(String id);
	
	public String admin(String id);

	public List<LoginDto> memberall();

	public int memberDel(final String id);

	public int branch_register(String branchName, String address, String openingTime, String parking, String contact,
			String branchPath);

	public int designer_register(String designerId, String designerName, String introduce, String designerPath,
			int branchId);

	public int designer_del(String designerId);
	public int member_del(String designerId);
	
	List<String> branchlist();
	
	public int branchid(String branchName);
	
	public String branchname(String branchid );

	public int qna_reply(int qnaid);
	
	List<DesignerDto> desingerall();

	public List<OrderInfoDto> getAllOrders();

	public List<OrderDetailProductDto> getOrderDetails(int orderid);

	public List<QnaDto> getAllQna();
	
	public List<String> workday(String id);
	
	public int designer_modify_member(String id, String pw, String email, String intro);
	public int designer_modify_designer(String designerId, String introduce);;
	public int designer_modify_work(String designerId, String workday);
	public int delete_workday(String designerId);
	
	public QnaDto Qnainfo(String qnaId);

	
}
