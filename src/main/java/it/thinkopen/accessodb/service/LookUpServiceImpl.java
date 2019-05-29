package it.thinkopen.accessodb.service;

import it.thinkopen.accessodb.Dao.GenericDaoImpl;
import it.thinkopen.accessodb.entity.Pagination;
import it.thinkopen.accessodb.entity.ResponseFromQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class LookUpServiceImpl implements LookUpService {


    @Autowired
    private GenericDaoImpl genericDaoImpl;

    public LookUpServiceImpl() {
    }

    @Override
    public ResponseFromQuery findHotelsEntityByCityName(Pagination pagination, HashMap<String, String> filters)
    {
        return genericDaoImpl.findHotelsEntityByCityName(pagination, filters);
    }
}
