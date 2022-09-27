package com.kevinavy.easyaccount.model.common.http;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class PageRequest {
    private Integer pageNo;
    private Integer pageSize;
    private Map<String, Object> filterMap;

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Map<String, Object> getFilterMap() {
        return filterMap;
    }

    public void setFilterMap(Map<String, Object> filterMap) {
        this.filterMap = filterMap;
    }
}
