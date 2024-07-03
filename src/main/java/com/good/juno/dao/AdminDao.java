package com.good.juno.dao;

import java.util.List;

import com.good.juno.dto.DesignerDto;
import com.good.juno.dto.LoginDto;

public interface AdminDao {

	public int memberInsert(String id, String pw, String email, String name, String Birth, String intro, String admin);

	public int membercheck(String id, String pw);

	public LoginDto getInfo(String id);

	public String admin(String id);

	public List<LoginDto> memberall();

	public int memberDel(final String id);

	public int branch_register(String branchName, String address, String openingTime, String parking, String contact,
			String branchPath);

	public int designer_register(String designerId, String designerName, String introduce, String designerPath,
			int branchId);

	List<String> branchlist();
	
	public int branchid(String branchName);

	List<DesignerDto> desingerall();

	
}
