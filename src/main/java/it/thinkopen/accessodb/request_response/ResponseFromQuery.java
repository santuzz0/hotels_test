package it.thinkopen.accessodb.request_response;

import it.thinkopen.accessodb.entity.HotelEntity;

import java.util.List;

public class ResponseFromQuery {
    private Pagination pagination;
    private Filter[] filters;
    private List<HotelEntity> hotelsList;
    private String status;
    private String message;

    public ResponseFromQuery() {
    }

    public ResponseFromQuery(Pagination pagination, Filter[] filters, List<HotelEntity> hotelsList, String status, String message) {
        this.pagination = pagination;
        this.filters = filters;
        this.hotelsList = hotelsList;
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

    public List<HotelEntity> getHotelsList() {
        return hotelsList;
    }

    public void setHotelsList(List<HotelEntity> hotelsList) {
        this.hotelsList = hotelsList;
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
