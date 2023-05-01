package com.acme.sprocket.common.data.page;

import com.acme.sprocket.common.data.page.Page;

import java.util.List;
import java.util.Optional;

public class PageUtility {
    public PageUtility() {}

    public static <A> Page<A> toPage(final List<A> list, final Optional<Integer> pageSizeOption, final Optional<Integer> pageNumberOption) {
        return new Page<>(
                list,
                pageSizeOption.orElse(10),
                pageNumberOption.orElse(0),
                pageSizeOption.map(pageSize -> list.size()/pageSize).orElse(list.size()/10),
                list.size());
    }

    public static <A> Page<A> toPage(org.springframework.data.domain.Page page) {
        return new Page<>(
                page.getContent(),
                page.getNumberOfElements(),
                page.getNumber(),
                page.getTotalPages(),
                page.getTotalElements());
    }

}
