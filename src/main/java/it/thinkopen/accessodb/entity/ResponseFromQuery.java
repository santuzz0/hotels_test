package it.thinkopen.accessodb.entity;

import java.util.List;

public class ResponseFromQuery {
    private Pagination pagination;
    private Filter[] filters;
    private List<GenericEntity> page;
    private String status;
    private String message;

    public ResponseFromQuery() {
    }

    public ResponseFromQuery(Pagination pagination, Filter[] filters, List<GenericEntity> page, String status, String message) {
        this.pagination = pagination;
        this.filters = filters;
        this.page = page;
        this.status = status;
        this.message = message;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public Filter[] getFilters() {
        return filters;
    }

    public void setFilters(Filter[] filters) {
        this.filters = filters;
    }

    public List<GenericEntity> getPage() {
        return page;
    }

    public void setPage(List<GenericEntity> page) {
        this.page = page;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
