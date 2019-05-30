package it.thinkopen.accessodb.Utils;

import it.thinkopen.accessodb.entity.GenericEntity;
import it.thinkopen.accessodb.entity.HotelEntity;
import it.thinkopen.accessodb.exceptions.BusinessException;
import it.thinkopen.accessodb.request_response.Pagination;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.Iterator;

public final class QueryBuilder {

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

            System.out.println("SQL: " + queryStringBuilder.toString());
            return query;
        } catch (IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
            throw new BusinessException("Errore: stringa che compone la query invalida.");
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

            System.out.println("HQL: " + queryStringBuilder.toString());
            System.out.println("Posizione del primo elemento: " + (pagination.getCurrentPage() - 1) * pagination.getPerPage());
            System.out.println("Numero massimo di elementi da recuperare: " + pagination.getPerPage());
            return query;
        } catch (IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
            throw new BusinessException("Errore: stringa che compone la query invalida.");
        }
    }

}
