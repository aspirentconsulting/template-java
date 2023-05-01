package com.acme.sprocket.common.data.page;

import org.springframework.data.domain.PageRequest;

import java.util.Optional;
import static org.springframework.data.domain.PageRequest.of;

public class PageRequestUtility {
    public PageRequestUtility() {}

    public static PageRequest pageRequest(
            final Optional<Integer> pageNumberOption,
            final Optional<Integer> pageSizeOption) {

        return pageNumberOption.flatMap(pageNumber -> pageSizeOption.map(pageSize -> pageRequest(pageNumber, pageSize)))
                .orElse(of(0,10));
    }

    public static PageRequest pageRequest(
            final int pageNumber,
            final int pageSize) {

        return of(pageNumber, pageSize);
    }
}
