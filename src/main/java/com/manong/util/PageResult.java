package com.manong.util;

import com.github.pagehelper.PageInfo;
import org.apache.poi.ss.formula.functions.T;

import java.util.List;

public class PageResult {
    private Long totalCount;

    private List<T> dataList;

    private Integer pageNum;
    public PageResult( Integer pageNum, Long totalCount,List<T> dataList){
        this.pageNum = pageNum;
        this.totalCount = totalCount;
        this.dataList = dataList;
    }

    public PageResult(PageInfo<T> pageInfo) {
        this.pageNum = pageInfo.getPageNum();
        this.totalCount = pageInfo.getTotal();
        this.dataList = pageInfo.getList();
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }
}
