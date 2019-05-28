package it.thinkopen.accessodb.entity;

public class SearchConditions {
    private Pagination pagination;
    private Filter[] filters;

    public SearchConditions() {
    }

    public SearchConditions(Pagination pagination, Filter[] filters) {
        this.pagination = pagination;
        this.filters = filters;
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
}
