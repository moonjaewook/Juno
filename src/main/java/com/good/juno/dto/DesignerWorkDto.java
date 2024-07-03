package com.good.juno.dto;

import java.sql.Timestamp;

public class DesignerWorkDto {
	
	private int designerId;
    private String workDay;
    private Timestamp workStart;
    private Timestamp workEnd;
    private boolean status;

    // Getters and Setters
    public int getDesignerId() {
        return designerId;
    }

    public void setDesignerId(int designerId) {
        this.designerId = designerId;
    }

    public String getWorkDay() {
        return workDay;
    }

    public void setWorkDay(String workDay) {
        this.workDay = workDay;
    }

    public Timestamp getWorkStart() {
        return workStart;
    }

    public void setWorkStart(Timestamp workStart) {
        this.workStart = workStart;
    }

    public Timestamp getWorkEnd() {
        return workEnd;
    }

    public void setWorkEnd(Timestamp workEnd) {
        this.workEnd = workEnd;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
 
	
}