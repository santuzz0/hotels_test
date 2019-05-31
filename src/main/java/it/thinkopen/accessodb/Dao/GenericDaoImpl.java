package it.thinkopen.accessodb.Dao;

import it.thinkopen.accessodb.config.ExceptionStringConf;
import it.thinkopen.accessodb.entity.GenericEntity;
import it.thinkopen.accessodb.exceptions.BusinessException;
import it.thinkopen.accessodb.request_response.Pagination;
import it.thinkopen.accessodb.utils.QueryBuilder;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;

@Component
public class GenericDaoImpl implements GenericDao {

    @PersistenceContext
    private EntityManager entityManager;

    public GenericDaoImpl() {
    }

    @Override
    public List<GenericEntity> findHotelsEntityByCityNameSQL(Pagination pagination, HashMap<String, String> filters) throws BusinessException {
        try {
            Query query = QueryBuilder.buildSQLQuery("hotel", pagination, filters, entityManager);
            List<GenericEntity> entityList = query.getResultList();
            return entityList;
        } catch (IllegalStateException ex) {
            System.err.println(ex.getMessage());
            throw new BusinessException(ExceptionStringConf.ERROR2);
        }
    }

    @Override
    public List<GenericEntity> findHotelsEntityByCityNameHQL(Pagination pagination, HashMap<String, String> filters) throws BusinessException {
        try {
            Query query = QueryBuilder.buildHQLQuery("HotelEntity", pagination, filters, entityManager);
            List<GenericEntity> entityList = query.getResultList();
            return entityList;
        } catch (IllegalStateException ex) {
            System.err.println(ex.getMessage());
            throw new BusinessException(ExceptionStringConf.ERROR2);
        }
    }

}
