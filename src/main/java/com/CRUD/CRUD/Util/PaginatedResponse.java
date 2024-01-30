package com.CRUD.CRUD.Util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaginatedResponse<T> {
    private int pageNo;
    private int pageSize;
    private boolean last;
    private int totalPages;
    private long totalElements;
    private List<T> content;
}
