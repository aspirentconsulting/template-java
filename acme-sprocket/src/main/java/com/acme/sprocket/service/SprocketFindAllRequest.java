package com.acme.sprocket.service;

import com.acme.sprocket.common.data.request.AbstractPageRequest;

import java.util.Optional;

public class SprocketFindAllRequest extends AbstractPageRequest {
    public SprocketFindAllRequest() {}

    public SprocketFindAllRequest(Optional<Integer> pageNumber, Optional<Integer> pageSize) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
    }
}
