package it.thinkopen.accessodb.utils;

import it.thinkopen.accessodb.LocalDBConf;
import it.thinkopen.accessodb.entity.Pagination;
import java.util.HashMap;
import java.util.Iterator;

public class QueryBuilder
{
    public String buildSelectQuery(Pagination pagination, HashMap<String, String> filters, String table)
    {
        StringBuilder query = new StringBuilder("SELECT t.* FROM ");
        query.append(LocalDBConf.SCHEMA_NAME).append(".").append(table).append(" t");

        if (!filters.isEmpty())
        {
            query.append(" WHERE ");
            Iterator iterator = filters.keySet().iterator();
            while (iterator.hasNext())
            {
                String key = (String) iterator.next();
                query.append(key)
                        .append(" LIKE '%")
                        .append(filters.get(key))
                        .append("%'");
                if (iterator.hasNext())
                {
                    query.append(" AND ");
                }
            }
        }
        return query.toString();
    }
}
