package com.good.juno.command.reservation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.good.juno.dao.ReservationIDao;
import com.good.juno.dto.PageDto;
import com.good.juno.dto.ReservationDto;

public class PagingCommand {
	
	private ReservationIDao reservationIDao;
    
    public PagingCommand(ReservationIDao reservationIDao) {
        this.reservationIDao = reservationIDao;
    }
    
    public Map<String, Object> getPaginatedList(Map<String, Object> params) {
//        int pageNo = Integer.parseInt((String) params.get("pageNo"));
//        int pageSize = Integer.parseInt((String) params.get("pageSize"));
    	int pageNo = params.get("pageNo") != null ? Integer.parseInt((String) params.get("pageNo")) : 1;
        int pageSize = params.get("pageSize") != null ? Integer.parseInt((String) params.get("pageSize")) : 10;
        int offset = (pageNo - 1) * pageSize;
        params.put("offset", offset);
        params.put("pageSize", pageSize);

        List<ReservationDto> list = reservationIDao.getShopList(params);
        
        int totalRecords = reservationIDao.getShopListCount(params);
        int totalPages = (int) Math.ceil((double) totalRecords / pageSize);

        Map<String, Object> result = new HashMap<String, Object>();
        result.put("list", list);
        result.put("PageDto", new PageDto(pageNo, totalPages, totalRecords)); // 현재페이지, 전체갯수, 전체페이지수

        return result;
    }
}
