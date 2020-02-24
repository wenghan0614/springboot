package com.venink.slec.base.utils.page;

public class BaseObject {
    //首页
    private int start;
    //尾页
    private int end;
    //当前页
    private int pageCurrent;
    //页面尺寸
    private int pageSize;
    //页数
    private int pageCount;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getPageCurrent() {
        return pageCurrent;
    }

    public void setPageCurrent(int pageCurrent) {
        this.pageCurrent = pageCurrent;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void pageHandle(Integer pageCurrent,Integer pageSize,Integer pageCount,Integer rows){
        //判断 页数
        //页面尺寸默认为10
        if (pageSize == 0) pageSize = 10;
        //设置默认当前页为第一页
        if (pageCurrent == 0) pageCurrent = 1;

        //如果总页数为0，总页数 = 总记录数 % 页面尺寸（默认10） == 0 ？（总记录数 / 页面尺寸）：（总记录数 / 页面尺寸）+ 1
        if (pageCount == 0) pageCount = rows % pageSize == 0 ? (rows / pageSize) : (rows / pageSize) + 1;

        //设置limit开始值 = （当前页码（默认1） - 1）* 页面尺寸（默认10）
        this.pageCurrent = pageCurrent;
        this.pageSize = pageSize;
        this.pageCount = pageCount;
        this.start = (pageCurrent - 1) * pageSize;
        //设置limit尺寸(取多少条记录) = 页面尺寸
        this.end = pageSize;
    }
}
