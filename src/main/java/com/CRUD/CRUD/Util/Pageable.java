package com.CRUD.CRUD.Util;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;


public class Pageable {


    public static final String DEFAULT_PAGE_NUMBER = "0";
    public static final String DEFAULT_PAGE_SIZE = "10";
    public static final String DEFAULT_SORT_BY = "name";
    public static final String DEFAULT_SORT_DIRECTION = "desc";

    private Pageable() {
    }

    @Builder
    public static org.springframework.data.domain.Pageable pageable(int pageNo, int pageSize, String sortBy, String sortDir) {
        final var sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())
                ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        // create Pageable instance
        return PageRequest.of(pageNo, pageSize, sort);
    }
}
