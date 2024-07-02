package com.good.juno.dto;

public class ReservationDto {
	
	private int branchId;
    private String branchName;
    private String address;
    private String openingTime;
    private String parking;
    private String contact; //연락처
    private String branchPath; //지점 사진
    
    
    // getter setter
	public int getBranchId() {
		return branchId;
	}
	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getOpeningTime() {
		return openingTime;
	}
	public void setOpeningTime(String openingTime) {
		this.openingTime = openingTime;
	}
	public String getParking() {
		return parking;
	}
	public void setParking(String parking) {
		this.parking = parking;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getBranchPath() {
		return branchPath;
	}
	public void setBranchPath(String branchPath) {
		this.branchPath = branchPath;
	}

	
}