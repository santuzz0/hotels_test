package it.thinkopen.accessodb.service;

import it.thinkopen.accessodb.entity.Pagination;
import it.thinkopen.accessodb.entity.ResponseFromQuery;
import it.thinkopen.accessodb.exception.BusinessException;

import java.util.HashMap;

public interface LookUpService
{
    ResponseFromQuery findHotelsEntityByCityName(Pagination pagination, HashMap<String, String> filters) throws BusinessException;
}
