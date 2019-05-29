package it.thinkopen.accessodb.Dao;

import it.thinkopen.accessodb.Utils.QueryBuilder;
import it.thinkopen.accessodb.entity.HotelEntity;
import it.thinkopen.accessodb.request_response.Pagination;
import it.thinkopen.accessodb.request_response.ResponseFromQuery;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;

@Repository
public class GenericDaoImpl implements GenericDao {

    @PersistenceContext
    private EntityManager entityManager;

    public GenericDaoImpl() {
    }

    @Override
    public ResponseFromQuery findHotelsEntityByCityNameSQL(Pagination pagination, HashMap<String, String> filters) {
        String queryString = QueryBuilder.buildQuery("hotel", pagination, filters);
        Query query = entityManager.createNativeQuery(queryString, HotelEntity.class);
        List<HotelEntity> hotelEntityList = (List<HotelEntity>) query.getResultList();

        ResponseFromQuery responseFromQuery = new ResponseFromQuery();
        responseFromQuery.setHotelsList(hotelEntityList);

        return responseFromQuery;
    }

}
