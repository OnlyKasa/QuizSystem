package com.ben.quiz.domain.dto.request;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by QuangNV on 9/18/2017.
 */
public class PagingReq {
    public static final String DEFAULT_SORTED_BY = "default";
    
    private String sortedBy;
    private Boolean ascending;
    @NotNull
    private Integer page;
    @Max(50)
    private Integer rowPerPage;
    private Integer from;

    public PagingReq() {
        sortedBy = DEFAULT_SORTED_BY;
        ascending = true;
        page = 0;
        rowPerPage = 0;
    }

    public PagingReq(String sortedBy, Boolean ascending, Integer page, Integer rowPerPage, Integer from) {
        this.sortedBy = sortedBy;
        this.ascending = ascending;
        this.page = page;
        this.rowPerPage = rowPerPage;
        this.from = from;
    }

    public void setStrAscending(String strAscending){
        ascending = strAscending.equals("true");
    }

    public String getSortedBy() {
        return sortedBy;
    }

    public void setSortedBy(String sortedBy) {
        this.sortedBy = sortedBy;
    }

    public Boolean getAscending() {
        return ascending;
    }

    public void setAscending(Boolean ascending) {
        this.ascending = ascending;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRowPerPage() {
        return rowPerPage;
    }

    public void setRowPerPage(Integer rowPerPage) {
        this.rowPerPage = rowPerPage;
    }

    public Integer getFrom() {
        return from;
    }

    public void setFrom(Integer from) {
        this.from = from;
    }
}
