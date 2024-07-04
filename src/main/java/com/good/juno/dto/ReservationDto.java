package com.good.juno.dto;

import java.sql.Timestamp;

public class ReservationDto {
	
    private int reservationId;
    private Timestamp reservationDate;
    private Timestamp reservationTime;
    private String sisul;
    private String userId; // 원래는 fk인데 일단은 .. 직접 데이터 넣기
    private int branchId; // FOREIGN KEY (branchId) REFERENCES branch(branchId),
    private int designerId; // FOREIGN KEY (designerId) REFERENCES Designer(designerId)
    
    // getter setter
	public int getReservationId() {
		return reservationId;
	}
	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}
	public Timestamp getReservationDate() {
		return reservationDate;
	}
	public void setReservationDate(Timestamp reservationDate) {
		this.reservationDate = reservationDate;
	}
	public Timestamp getReservationTime() {
		return reservationTime;
	}
	public void setReservationTime(Timestamp reservationTime) {
		this.reservationTime = reservationTime;
	}
	public String getSisul() {
		return sisul;
	}
	public void setSisul(String sisul) {
		this.sisul = sisul;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getBranchId() {
		return branchId;
	}
	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}
	public int getDesignerId() {
		return designerId;
	}
	public void setDesignerId(int designerId) {
		this.designerId = designerId;
	}
    
    // getter setter
	
    
    
	
    
}
