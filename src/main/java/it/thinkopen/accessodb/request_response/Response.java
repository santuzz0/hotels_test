package it.thinkopen.accessodb.request_response;

import it.thinkopen.accessodb.entity.HotelEntity;
import org.springframework.data.domain.Page;

public class Response {
    private Pagination pagination;
    private Filter[] filters;
    private Page<HotelEntity> page;
    private String status;
    private String message;

    public Response() {
    }

    public Response(Pagination pagination, Filter[] filters, Page<HotelEntity> page, String status, String message) {
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

    public Page<HotelEntity> getPage() {
        return page;
    }

    public void setPage(Page<HotelEntity> page) {
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
