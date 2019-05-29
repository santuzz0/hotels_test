package it.thinkopen.accessodb.Dao;

import it.thinkopen.accessodb.entity.Pagination;
import it.thinkopen.accessodb.entity.ResponseFromQuery;

import java.util.HashMap;

public interface GenericDao
{
    ResponseFromQuery findHotelsEntityByCityName(Pagination pagination, HashMap<String, String> filters);
}
