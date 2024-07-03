package com.good.juno.dto;

import java.sql.Timestamp;

public class ReservationDto {
	
    private int reservationId;
    private Timestamp reservationDate;
    private Timestamp reservationTime;
    private String reservationStatus;
    private Timestamp createdAt;
    private String userId; // ������ fk�ε� �ϴ��� .. ���� ������ �ֱ�
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
	public String getReservationStatus() {
		return reservationStatus;
	}
	public void setReservationStatus(String reservationStatus) {
		this.reservationStatus = reservationStatus;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
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
    
    
	
    
}
