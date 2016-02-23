package edu.upc.eetac.dsa.group7.dao;

/**
 * Created by LENOVO on 2016-02-22.
 */
public interface CategoryDAOQuery {
    public final static String GET_CATEGORIES = "select hex(id) as id, hex(name) as name from categories order by name";
}
