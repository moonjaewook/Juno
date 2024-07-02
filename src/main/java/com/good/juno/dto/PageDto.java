package com.good.juno.dto;

public class PageDto {

	private int currentPage; //���� ������
    private int totalPages; // ��ü ������
    private int totalRecords; // ��ü ���ڵ� ��

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
