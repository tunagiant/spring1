package com.example.demo4.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PageMaker {

    /**
     * totalCount               게시글총갯수(Controller, Mapper)
     * startPage / endPage      해당페이지그룹의 첫페이지번호, 마지막페이지번호
     * prev / next              이전페이지그룹, 다음페이지그룹
     * displayPageNum           해당페이지그룹의 페이지수(이전,다음 사이 번호)
     * caclDate()               여러가지 처리
     */
    private int totalCount;
    private int startPage;
    private int endPage;
    private boolean prev;
    private boolean next;
    private int displayPageNum = 5;
    private Criteria criteria;

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
        calcDate();
    }

    private void calcDate() {
        // 1X페이지-> 끝이 20이됨. 2X페이지-> 끝이30이됨
        endPage = (int) (Math.ceil(criteria.getPage() / (double)displayPageNum) * displayPageNum);
        startPage = (endPage - displayPageNum) + 1;

        // 5페이지가 끝이라면-> 10곱하는식이 아닌 5페이지를 끝페이지로설정
        int tempEndPage = (int) (Math.ceil(totalCount / (double)criteria.getPerPageNum()));
        if (endPage > tempEndPage) {
            endPage = tempEndPage;
        }

        // 1페이지라면 prev false값. 끝페이지그룹 next falser값.
        prev = startPage == 1 ? false : true;
        next = endPage * criteria.getPerPageNum() >= totalCount ?  false : true;
    }

}
