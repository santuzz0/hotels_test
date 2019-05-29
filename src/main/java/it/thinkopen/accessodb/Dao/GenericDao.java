package it.thinkopen.accessodb.Dao;

import it.thinkopen.accessodb.request_response.Pagination;
import it.thinkopen.accessodb.request_response.ResponseFromQuery;

import java.util.HashMap;

public interface GenericDao {

    ResponseFromQuery findHotelsEntityByCityNameSQL(Pagination pagination, HashMap<String, String> filters);

}
