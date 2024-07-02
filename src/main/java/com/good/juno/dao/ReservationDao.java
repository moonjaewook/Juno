package com.good.juno.dao;

import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.good.juno.dto.ReservationDto;
import com.good.juno.util.Constant;

public class ReservationDao {
	
	JdbcTemplate template;
	
	public ReservationDao() {
		this.template = Constant.template;
	}

	// 지점목록 BranchListCommand
	public ArrayList<ReservationDto> branch() {

		ArrayList<ReservationDto> branch = new ArrayList<ReservationDto>();
		
		String sql = "SELECT * FROM branch ORDER BY branchName ASC";
		return (ArrayList<ReservationDto>) template.query(sql, new BeanPropertyRowMapper<ReservationDto>(ReservationDto.class));
	}

}
