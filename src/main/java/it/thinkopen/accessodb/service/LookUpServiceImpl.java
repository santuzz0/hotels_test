package it.thinkopen.accessodb.service;

import it.thinkopen.accessodb.Dao.GenericDaoImpl;
import it.thinkopen.accessodb.entity.GenericEntity;
import it.thinkopen.accessodb.exceptions.BusinessException;
import it.thinkopen.accessodb.request_response.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class LookUpServiceImpl implements LookUpService {


    @Autowired
    private GenericDaoImpl genericDaoImpl;

    public LookUpServiceImpl() {
    }

    @Override
    public List<GenericEntity> findHotelsEntityByCityNameSQL(Pagination pagination, HashMap<String, String> filters) throws BusinessException {
        return genericDaoImpl.findHotelsEntityByCityNameSQL(pagination, filters);
    }

    @Override
    public List<GenericEntity> findHotelsEntityByCityNameHQL(Pagination pagination, HashMap<String, String> filters) throws BusinessException {
        return genericDaoImpl.findHotelsEntityByCityNameHQL(pagination, filters);
    }
}
