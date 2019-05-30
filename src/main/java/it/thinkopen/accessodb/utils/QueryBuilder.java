package it.thinkopen.accessodb.utils;

import it.thinkopen.accessodb.LocalDBConf;
import it.thinkopen.accessodb.entity.Pagination;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Iterator;

@Component
public class QueryBuilder
{
    public String buildSelectQuery(Pagination pagination, HashMap<String, String> filters, String table)
    {
        StringBuilder query = new StringBuilder("SELECT t.* FROM ");
        query.append(LocalDBConf.SCHEMA_NAME).append(".").append(table).append(" t");

        int limit = pagination.getPerPage();
        int offset = (pagination.getCurrentPage() - 1) * pagination.getPerPage();

        if (!filters.isEmpty())
        {
            query.append(" WHERE ");

            filters.forEach((key, value) ->
                    query.append(key)
                            .append(" LIKE '%")
                            .append(value)
                            .append("%'"));

            if (!filters.isEmpty())
            {
                query.append(" AND");
            }

            query.append(" LIMIT ");
            query.append(limit);
            query.append(" OFFSET ");
            query.append(offset);

        }
        return query.toString();
    }
}