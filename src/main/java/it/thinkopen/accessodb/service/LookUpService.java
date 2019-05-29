package it.thinkopen.accessodb.service;

import it.thinkopen.accessodb.request_response.Pagination;
import it.thinkopen.accessodb.request_response.ResponseFromQuery;

import java.util.HashMap;

public interface LookUpService {

    public ResponseFromQuery findHotelsEntityByCityNameSQL(Pagination pagination, HashMap<String, String> filters);

}
