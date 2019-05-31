package it.thinkopen.accessodb.utils;

import it.thinkopen.accessodb.config.ExceptionStringConf;
import it.thinkopen.accessodb.entity.GenericEntity;
import it.thinkopen.accessodb.exceptions.BusinessException;
import it.thinkopen.accessodb.request_response.Pagination;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.Iterator;

public final class QueryBuilder {

    private final static Logger logger = Logger.getLogger(QueryBuilder.class);

    public static Query buildSQLQuery(String table, Pagination pagination, HashMap<String, String> filters, EntityManager entityManager) throws BusinessException {
        try {
            int limit = pagination.getPerPage();
            int offset = (pagination.getCurrentPage() - 1) * pagination.getPerPage();

            StringBuilder queryStringBuilder = new StringBuilder();
            queryStringBuilder.append("SELECT * FROM ");
            queryStringBuilder.append(table);

            Iterator keyIterator = filters.keySet().iterator();
            if (keyIterator.hasNext()) {
                queryStringBuilder.append(" WHERE ");
            }
            while (keyIterator.hasNext()) {
                String key = (String) keyIterator.next();

                queryStringBuilder.append(key);
                queryStringBuilder.append(" = '");
                queryStringBuilder.append(filters.get(key));
                queryStringBuilder.append("' ");
                if (keyIterator.hasNext()) {
                    queryStringBuilder.append(" AND ");
                }
            }

//            if (!filters.isEmpty()) {
//                queryStringBuilder.append(" WHERE ");
//
//                filters.forEach((key, value) -> {
//                    if (queryStringBuilder.indexOf("LIKE") != -1) {
//                        queryStringBuilder.append(" AND ");
//                    }
//                    queryStringBuilder.append(key)
//                            .append(" LIKE '%")
//                            .append(value)
//                            .append("%'");
//                });
//            }

            queryStringBuilder.append(" LIMIT ");
            queryStringBuilder.append(limit);
            queryStringBuilder.append(" OFFSET ");
            queryStringBuilder.append(offset);

            Query query = entityManager.createNativeQuery(queryStringBuilder.toString());

            logger.info("SQL: " + queryStringBuilder.toString());
            return query;
        } catch (IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
            throw new BusinessException(ExceptionStringConf.ERROR1);
        }
    }

    public static Query buildHQLQuery(String tableClass, Pagination pagination, HashMap<String, String> filters, EntityManager entityManager) throws BusinessException {
        try {
            StringBuilder queryStringBuilder = new StringBuilder();
            queryStringBuilder.append("FROM ");
            queryStringBuilder.append(tableClass);

            Iterator keyIterator = filters.keySet().iterator();
            if (keyIterator.hasNext()) {
                queryStringBuilder.append(" WHERE ");
            }
            while (keyIterator.hasNext()) {
                String key = (String) keyIterator.next();
                queryStringBuilder.append(key);
                queryStringBuilder.append(" = :");
                queryStringBuilder.append(key);
                if (keyIterator.hasNext()) {
                    queryStringBuilder.append(" AND ");
                }
            }

            Query query = entityManager.createQuery(queryStringBuilder.toString(), GenericEntity.class);
            for (String key : filters.keySet()) {
                query.setParameter(key, filters.get(key));
            }

            query.setFirstResult((pagination.getCurrentPage() - 1) * pagination.getPerPage());
            query.setMaxResults(pagination.getPerPage());

            logger.info("HQL: " + queryStringBuilder.toString());
            logger.info("Posizione del primo elemento: " + (pagination.getCurrentPage() - 1) * pagination.getPerPage());
            logger.info("Numero massimo di elementi da recuperare: " + pagination.getPerPage());

            return query;
        } catch (IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
            throw new BusinessException(ExceptionStringConf.ERROR1);
        }
    }

}
