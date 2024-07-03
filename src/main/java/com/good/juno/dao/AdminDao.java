package com.good.juno.dao;

import java.util.List;

import com.good.juno.dto.LoginDto;

public interface AdminDao {
	
	
	public int memberInsert(String id, String pw, String email, String name, String Birth,
			String intro, String admin);
	
	public int membercheck(String id, String pw);
	
	public LoginDto getInfo(String id);
	
	public String admin(String id);
	
	public List<LoginDto> memberall();
	
	public int memberDel(final String id);
	

	
}
