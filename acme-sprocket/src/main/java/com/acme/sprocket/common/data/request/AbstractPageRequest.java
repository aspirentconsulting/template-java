package com.acme.sprocket.common.data.request;

import java.util.Optional;
import static java.util.Optional.empty;
import static java.util.Optional.of;

public abstract class AbstractPageRequest {
    protected Optional<Integer> pageNumber = of(0);
    protected Optional<Integer> pageSize = of(10);

    public Optional<Integer> getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Optional<Integer> pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Optional<Integer> getPageSize() {
        return pageSize;
    }

    public void setPageSize(Optional<Integer> pageSize) {
        this.pageSize = pageSize;
    }
}

