package com.good.juno.dto;

public class DesignerDto {
	
	private int designerId;
    private String designerName;
    private String introduce;
    private String designerPath; // �����̳� ����
    private String branchId; // FK(branch ���̺�)
    
    // getter setter
	public int getDesignerId() {
		return designerId;
	}
	public void setDesignerId(int designerId) {
		this.designerId = designerId;
	}
	public String getDesignerName() {
		return designerName;
	}
	public void setDesignerName(String designerName) {
		this.designerName = designerName;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public String getDesignerPath() {
		return designerPath;
	}
	public void setDesignerPath(String designerPath) {
		this.designerPath = designerPath;
	}
	public String getBranchId() {
		return branchId;
	}
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}
   
    
    
 
	
}