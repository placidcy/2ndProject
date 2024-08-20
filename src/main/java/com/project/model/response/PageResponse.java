package com.project.model.response;

import java.util.List;

public class PageResponse<T> {
    private Integer totalPages;        // 전체 페이지 수
    private Integer currentPage;       // 현재 페이지 번호
    private Long totalElements;        // 전체 데이터 수
    private Integer size;              // 페이지당 데이터 수
    private List<T> content;           // 현재 페이지의 데이터 목록

    public PageResponse(List<T> content, int currentPage, int size, long totalElements) {
        this.content = content;
        this.currentPage = currentPage;
        this.size = size;
        this.totalElements = totalElements;
        this.totalPages = (int) Math.ceil((double) totalElements / size);
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(Long totalElements) {
        this.totalElements = totalElements;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }
}
