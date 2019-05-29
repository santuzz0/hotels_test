package it.thinkopen.accessodb.Dao;

import it.thinkopen.accessodb.entity.HotelEntity;
import it.thinkopen.accessodb.request_response.Pagination;
import it.thinkopen.accessodb.request_response.ResponseFromQuery;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

// Qua dentro ci deve essere un EntityManager annotato con
// @PersistenceContext(hdb). Questa classe è necessaria per
// poter fare query personalizzate sul DB. La query viene fatta
// con entityManager.?
// createQuery mi torna uun oggetto di tipo Query che dovrò applicare al DB
// Posso usare HQL o SQL

@Repository
public class GenericDaoImpl implements GenericDao {

    @PersistenceContext
    private EntityManager entityManager;

    public GenericDaoImpl() {
    }

    @Override
    public ResponseFromQuery findHotelsEntityByCityNameSQL(Pagination pagination, HashMap<String, String> filters) {
        String queryString = buildQuery(pagination, filters);
        Query query = entityManager.createNativeQuery(queryString, HotelEntity.class);
        List<HotelEntity> hotelEntityList = (List<HotelEntity>) query.getResultList();

        ResponseFromQuery responseFromQuery = new ResponseFromQuery();
        responseFromQuery.setHotelsList(hotelEntityList);

        return responseFromQuery;
    }

    private String buildQuery(Pagination pagination, HashMap<String, String> filters) {
        int limit = pagination.getPerPage();
        int offset = (pagination.getCurrentPage() - 1) * pagination.getPerPage();

        StringBuilder queryStringBuilder = new StringBuilder();
        queryStringBuilder.append("SELECT * FROM hotel ");

        Iterator keyIterator = filters.keySet().iterator();
        while (keyIterator.hasNext()) {
            String key = (String) keyIterator.next();

            queryStringBuilder.append(" WHERE ");
            queryStringBuilder.append(key);
            queryStringBuilder.append(" = '");
            queryStringBuilder.append(filters.get(key));
            queryStringBuilder.append("' ");
            if (keyIterator.hasNext()) {
                queryStringBuilder.append(" AND ");
            }
        }
        queryStringBuilder.append(" LIMIT ");
        queryStringBuilder.append(limit);
        queryStringBuilder.append(" OFFSET ");
        queryStringBuilder.append(offset);

        return queryStringBuilder.toString();
    }

}
