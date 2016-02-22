package edu.upc.eetac.dsa.group7.dao;



import edu.upc.eetac.dsa.group7.entity.Note;
import edu.upc.eetac.dsa.group7.entity.NoteCollection;

import java.sql.SQLException;

/**
 * Created by LENOVO on 2016-02-22.
 */
public interface NoteDAO {
    public Note createNote(float lng,float lat,String id_kat,String uwaga,String id_wlas ) throws SQLException;
    public Note getNoteById(String id) throws SQLException;
    public NoteCollection getNotes(String categoryid) throws SQLException;
    public void responseComment(String id, String response) throws SQLException;
    public boolean deleteComment(String id) throws SQLException;
}
