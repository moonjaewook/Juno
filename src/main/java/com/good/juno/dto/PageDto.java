package com.good.juno.dto;

public class PageDto {

	private int currentPage; //현재 페이지
    private int totalPages; // 전체 페이지
    private int totalRecords; // 전체 레코드 수

    public PageDto(int currentPage, int totalPages, int totalRecords) {
        this.currentPage = currentPage;
        this.totalPages = totalPages;
        this.totalRecords = totalRecords;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
    }
	    
}
