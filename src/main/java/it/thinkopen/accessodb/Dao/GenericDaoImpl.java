package it.thinkopen.accessodb.Dao;

import it.thinkopen.accessodb.LocalDBConf;
import it.thinkopen.accessodb.entity.GenericEntity;
import it.thinkopen.accessodb.entity.Pagination;
import it.thinkopen.accessodb.entity.ResponseFromQuery;
import it.thinkopen.accessodb.utils.QueryBuilder;
import org.springframework.stereotype.Component;

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

//    @Override
//    public ResponseFromQuery findHotelsEntityByCityName(Pagination pagination, HashMap<String, String> filters) {
//
//        Query query = entityManager.createNativeQuery("SELECT * FROM hotel LIMIT 10", HotelEntity.class);
//        List<HotelEntity> resultSet = (List<HotelEntity>)query.getResultList();
//
//        for(HotelEntity hotelEntity:resultSet) {
//            System.out.println(hotelEntity);
//        }
//
//        ResponseFromQuery responseFromQuery = new ResponseFromQuery();
//
//        responseFromQuery.setPage(resultSet);
//
//        return responseFromQuery;
//    }

    @Override
    public ResponseFromQuery findHotelsEntityByCityName(Pagination pagination, HashMap<String, String> filters) {
        QueryBuilder queryBuilder = new QueryBuilder();

        Query query = entityManager.createNativeQuery(queryBuilder.buildSelectQuery(pagination, filters, LocalDBConf.HOTEL_TABLE_NAME), GenericEntity.class);
        List<GenericEntity> resultSet = (List<GenericEntity>)query.getResultList();

        for(GenericEntity genericEntityEntity:resultSet) {
            System.out.println(genericEntityEntity);
        }

        ResponseFromQuery responseFromQuery = new ResponseFromQuery();

        responseFromQuery.setPage(resultSet);

        return responseFromQuery;
    }

}
