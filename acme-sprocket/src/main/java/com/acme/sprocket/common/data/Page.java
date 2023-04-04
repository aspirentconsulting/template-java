package com.acme.sprocket.common.data;


import java.util.List;

public class Page<A> {
    private final List<A> list;
    private final int pageSize;
    private final int pageNumber;
    private final long pageCount;
    private final long elementCount;

    public Page(List<A> list, int pageSize, int pageNumber, long pageCount, long elementCount) {
        this.list = list;
        this.pageSize = pageSize;
        this.pageNumber = pageNumber;
        this.pageCount = pageCount;
        this.elementCount = elementCount;
    }

    public List<A> getList() {
        return list;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public long getPageCount() {
        return pageCount;
    }

    public long getElementCount() {
        return elementCount;
    }
}
