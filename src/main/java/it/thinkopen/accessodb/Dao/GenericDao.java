package it.thinkopen.accessodb.Dao;

import it.thinkopen.accessodb.entity.Pagination;
import it.thinkopen.accessodb.entity.Response;

import java.util.HashMap;

public interface GenericDao {

    Response findHotelsEntityByCityName(Pagination pagination, HashMap<String, String> filters);

}
