package it.thinkopen.accessodb.Dao;

import it.thinkopen.accessodb.LocalDBConf;
import it.thinkopen.accessodb.Utils.QueryBuilder;
import it.thinkopen.accessodb.entity.GenericEntity;
import it.thinkopen.accessodb.exceptions.BusinessException;
import it.thinkopen.accessodb.request_response.Pagination;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;

// Qua dentro ci deve essere un EntityManager annotato con
// @PersistenceContext(hdb). Questa classe è necessaria per
// poter fare query personalizzate sul DB. La query viene fatta
// con entityManager.?
// createQuery mi torna uun oggetto di tipo Query che dovrò applicare al DB
// Posso usare HQL o SQL

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
            throw new BusinessException("Errore: si sta facendo un UPDATE o DELETE anziché un SELECT");
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
            throw new BusinessException("Errore: si sta facendo un UPDATE o DELETE anziché un SELECT");
        }
    }

}
