package it.thinkopen.accessodb.Dao;

import it.thinkopen.accessodb.entity.GenericEntity;
import it.thinkopen.accessodb.exceptions.BusinessException;
import it.thinkopen.accessodb.request_response.Pagination;

import java.util.HashMap;
import java.util.List;

public interface GenericDao {

    List<GenericEntity> findHotelsEntityByCityNameSQL(Pagination pagination, HashMap<String, String> filters) throws BusinessException;

    List<GenericEntity> findHotelsEntityByCityNameHQL(Pagination pagination, HashMap<String, String> filters) throws BusinessException;
}
