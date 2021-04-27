package com.example.demo4.domain;

public class Criteria {

    /**
     * page                 해당 페이지
     * perPageNum           해당 페이지의 글 수
     * rowStart/rowEnd      해당 페이지의 첫글번호/마지막글번호 Mapper에서 property접근법
     */
    private int page;
    private int perPageNum;
    private int rowStart;
    private int rowEnd;

    public Criteria() {
        this.page = 1;
        this.perPageNum = 4;
    }

    public void setPage(int page) {
        if (page <= 0) {
            this.page = 1;
            return;
        }
        this.page = page;
    }
    public void setPerPageNum(int perPageNum) {
        if (perPageNum <= 0 || perPageNum > 16) {
            this.perPageNum = 4;
            return;
        }
    }

    public int getPage() {
        return page;
    }

    public int getPageStart() {
        return (this.page - 1) * perPageNum;
    }

    public int getPerPageNum() {
        return this.perPageNum;
    }

    public int getRowStart() {
        rowStart = ((page - 1) * perPageNum) + 1;
        return rowStart;
    }

    public int getRowEnd() {
        rowEnd = rowStart + perPageNum - 1;
        return rowEnd;
    }

}
