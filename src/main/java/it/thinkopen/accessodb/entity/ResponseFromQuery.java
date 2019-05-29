package it.thinkopen.accessodb.entity;

import java.util.List;

public class ResponseFromQuery {
    private Pagination pagination;
    private Filter[] filters;
    private List<HotelEntity> page;
    private String status;
    private String message;


}
