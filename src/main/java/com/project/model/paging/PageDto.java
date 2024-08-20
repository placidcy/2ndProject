package com.project.model.paging;

public class PageDto {
    private int page;
    private int totalPage;
    private int startPage;
    private int endPage;

    public PageDto(int page, int totalPage) {
        this.page = page;
        this.totalPage = totalPage;
        this.startPage = (page - 1) / 10 * 10 + 1;
        this.endPage = Math.min(startPage + 9, totalPage);
    }

    public int getPage() {
        return page;
    }

    public boolean isStartPage() {
        return startPage == 1;
    }

    public boolean isEndPage() {
        return endPage == totalPage;
    }

    public int getStartPage() {
        return startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public int getTotalPage() {
        return totalPage;
    }
}
