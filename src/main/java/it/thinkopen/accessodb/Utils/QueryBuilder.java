package it.thinkopen.accessodb.Utils;

import it.thinkopen.accessodb.request_response.Pagination;

import java.util.HashMap;
import java.util.Iterator;

public final class QueryBuilder {

    public final static String buildQuery(String table, Pagination pagination, HashMap<String, String> filters) {
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

        queryStringBuilder.append(" LIMIT ");
        queryStringBuilder.append(limit);
        queryStringBuilder.append(" OFFSET ");
        queryStringBuilder.append(offset);

        return queryStringBuilder.toString();
    }

}
