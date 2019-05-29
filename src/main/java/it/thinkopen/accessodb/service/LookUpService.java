package it.thinkopen.accessodb.service;

import it.thinkopen.accessodb.entity.Pagination;
import it.thinkopen.accessodb.entity.Response;

import java.util.HashMap;

public interface LookUpService {

    public Response findHotelsEntityByCityName(Pagination pagination, HashMap<String, String> filters);

}
