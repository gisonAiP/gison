package edu.upc.eetac.dsa.group7.dao;

/**
 * Created by LENOVO on 2016-02-22.
 */
public class NoteDAOQuery {
    public final static String UUID = "select REPLACE(UUID(),'-','')";
    public final static String CREATE_NOTE = "insert into notes (id, lng, lat,id_kat,name,uwaga,id_wlas) values (UNHEX(?), UNHEX(?), UNHEX(?), ?, ?, ?, ?)";
    public final static String GET_NOTE_BY_ID = "select hex(id) as id, hex(id_kat) as id_kat, hex(id_wlas) as id_wlas,hex(name) as name, lng, lat,uwaga, creation_timestamp from notes where id=unhex(?)";
    public final static String GET_NOTES = "select hex(id) as id, hex(id_kat) as id_kat, hex(id_wlas) as id_wlas, hex(name) as name, lng, lat,uwaga, creation_timestamp from notes where id_kat=unhex(?)order by creation_timestamp limit 5";
    //public final static String RESPONSE_COMMENT = "update comments set response=? where id=unhex(?) ";
    //public final static String DELETE_COMMENT = "delete from comments where id=unhex(?)";
    //public final static String VALORATION = "insert into like_restaurant (restaurant, user) values (UNHEX(?), UNHEX(?))";
   // public final static String CHECK_VALORATION = "select hex(restaurant) from like_restaurant where user=unhex(?)";
    //public final static String REMOVE_VALORATION = "delete from like_restaurant where restaurant=unhex(?) and user=unhex(?)";
}
