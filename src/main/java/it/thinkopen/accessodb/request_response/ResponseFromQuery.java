package it.thinkopen.accessodb.request_response;

import it.thinkopen.accessodb.entity.GenericEntity;

import java.util.List;

public class ResponseFromQuery {
    private Pagination pagination;
    private Filter[] filters;
    private List<GenericEntity> entityList;
    private String status;
    private String message;

    public ResponseFromQuery() {
    }

    public ResponseFromQuery(Pagination pagination, Filter[] filters, List<GenericEntity> entityList, String status, String message) {
        this.pagination = pagination;
        this.filters = filters;
        this.entityList = entityList;
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

    public List<GenericEntity> getEntityList() {
        return entityList;
    }

    public void setEntityList(List<GenericEntity> entityList) {
        this.entityList = entityList;
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
