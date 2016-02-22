package edu.upc.eetac.dsa.group7.dao;

/**
 * Created by LENOVO on 2016-02-22.
 */
public class NoteDAOQuery {
    public final static String UUID = "select REPLACE(UUID(),'-','')";
    public final static String CREATE_NOTE = "insert into comments (id, creator, restaurant, title, comment, likes, response) values (UNHEX(?), UNHEX(?), UNHEX(?), ?, ?, ?, ?)";
    public final static String GET_NOTE_BY_ID = "select hex(id) as id, hex(creator) as creator, hex(restaurant) as restaurant, title, comment, likes, response, creation_timestamp from comments where id=unhex(?)";
    public final static String GET_NOTES = "select hex(id) as id, hex(creator) as creator, hex(restaurant) as restaurant, title, comment, likes, response, creation_timestamp from comments where restaurant=unhex(?)order by creation_timestamp limit 5";
    //public final static String RESPONSE_COMMENT = "update comments set response=? where id=unhex(?) ";
    //public final static String DELETE_COMMENT = "delete from comments where id=unhex(?)";
    //public final static String VALORATION = "insert into like_restaurant (restaurant, user) values (UNHEX(?), UNHEX(?))";
   // public final static String CHECK_VALORATION = "select hex(restaurant) from like_restaurant where user=unhex(?)";
    //public final static String REMOVE_VALORATION = "delete from like_restaurant where restaurant=unhex(?) and user=unhex(?)";
}
