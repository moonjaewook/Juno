package com.good.juno.dto;

public class DesignerDto {
	
	private String designerId;
    private String designerName;
    private String introduce;
    private String designerPath; // 디자이너 사진
    private String branchId; // FK(branch 테이블)
    
    // getter setter
	public String getDesignerId() {
		return designerId;
	}
	public void setDesignerId(String designerId) {
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