package edu.upc.eetac.dsa.group7.dao;

import edu.upc.eetac.dsa.group7.db.Database;

import edu.upc.eetac.dsa.group7.entity.Note;
import edu.upc.eetac.dsa.group7.entity.NoteCollection;


import javax.ws.rs.BadRequestException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by LENOVO on 2016-02-22.
 */
public class NoteDAOImp implements NoteDAO {
    @Override
    //Function to create a notes giving user identifier, restaurant categories, comment
    public Note createNote(float lng, float lat, String id_kat, String name, String uwaga, String id_wlas) throws SQLException {
        //initiation of variables and prepare the connection
        Connection connection = null;
        PreparedStatement stmt = null;
        String id = null;
        String id_katid = null;
        //String response = "";
        try {
            //try the database connection
            connection = Database.getConnection();
            //create the comment ID
            stmt = connection.prepareStatement(NoteDAOQuery.UUID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next())
                id = rs.getString(1);
            else
                throw new SQLException();
            // stmt = null;
            //check if this user has commented before this comments
            // stmt = connection.prepareStatement(NoteDAOQuery.CHECK_VALORATION);
            //stmt.setString(1, id_wlas);
            //ResultSet rs2 = stmt.executeQuery();
            // if (rs2.next()) {
            //categoryid = rs2.getString(1);
            // if (categoryid.equals(category))
            //  throw new BadRequestException("You cannot comment a restaurant twice");
            //  }
            stmt = null;
            //Store the comment in database
            stmt = connection.prepareStatement(NoteDAOQuery.CREATE_NOTE);
            stmt.setString(1, id);
            stmt.setFloat(2, lng);
            stmt.setFloat(3, lat);
            stmt.setString(4, id_kat);
            stmt.setString(5, name);
            stmt.setString(6, uwaga);
            stmt.setString(7, id_wlas);

            stmt.executeUpdate();
            // stmt = null;
            //Store the valoration in the database
            //stmt = connection.prepareStatement(NoteDAOQuery.VALORATION);
            //stmt.setString(1, id_wlas);
            //stmt.setString(2, id_kat);
            // stmt.executeUpdate();
            stmt = null;
        } catch (SQLException e) {
            throw e;
            //thow an error if anything fails
        } finally {
            if (stmt != null) stmt.close();
            if (connection != null) {
                //close the connection
                connection.setAutoCommit(true);
                connection.close();
            }
        }
        //return the comment
        return getNoteById(id);
    }

    @Override
    public Note getNoteById(String id) throws SQLException {
        Note note = null;
        //initiate variables and the connection
        Connection connection = null;
        PreparedStatement stmt = null;
        try {
            connection = Database.getConnection();
            //try the connection
            stmt = connection.prepareStatement(NoteDAOQuery.GET_NOTE_BY_ID);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                //store data from database
                note = new Note();
                note.setId(rs.getString("id"));
                note.setLng(rs.getFloat("lng"));
                note.setLat(rs.getFloat("lat"));
                note.setId_kat(rs.getString("id_kat"));
                note.setName(rs.getString("name"));
                note.setUwaga(rs.getString("uwaga"));
                note.setId_wlas(rs.getString("id_wlas"));

            }
        } catch (SQLException e) {
            throw e;
            //throw an error if the query fails
        } finally {
            //close the connection
            if (stmt != null) stmt.close();
            if (connection != null) connection.close();
        }
        return note;
        //return the comment from the database
    }

    @Override
    public NoteCollection getNotes(String id_katid) throws SQLException {
        NoteCollection noteCollection = new NoteCollection();
        //prepare the conection
        Connection connection = null;
        PreparedStatement stmt = null;
        try {
            connection = Database.getConnection();
            stmt = connection.prepareStatement(NoteDAOQuery.GET_NOTES);
            stmt.setString(1, id_katid);
            ResultSet rs = stmt.executeQuery();
            boolean first = true;
            while (rs.next()) {
                //use a loop to store all the comments
                Note note = new Note();
                note.setId(rs.getString("id"));
                note.setLng(rs.getFloat("lng"));
                note.setLat(rs.getFloat("lat"));
                note.setId_kat(rs.getString("id_kat"));
                note.setName(rs.getString("name"));
                note.setUwaga(rs.getString("uwaga"));
                note.setId_wlas(rs.getString("id_wlas"));
                note.setCreation_timestamp(rs.getTimestamp("creation_timestamp").getTime());
                noteCollection.getNotes().add(note);
            }
        } catch (SQLException e) {
            throw e;
            //throw an error if anything fails
        } finally {
            //close the connection
            if (stmt != null) stmt.close();
            if (connection != null) connection.close();
        }
        return noteCollection;
        //return the comment collection
    }


    
}

    //@Override
  // public void responseComment(String id, String response) throws SQLException {
     //   Comment comment = null;
        ///initiate variables and database connection
        //Connection connection = null;
       // PreparedStatement stmt = null;
        //try {
            //connection = Database.getConnection();
            //call the SQL Query to store the response
           // stmt = connection.prepareStatement(CommentDAOQuery.RESPONSE_COMMENT);
            //stmt.setString(1, response);
            //stmt.setString(2, id);
            //int rows = stmt.executeUpdate();
           // if (rows == 1)
                //comment = getCommentById(id);
        //} catch (SQLException e) {
           // throw e;
            //throw error if it fails
       // } finally {
            //close the connection
           // if (stmt != null) stmt.close();
           // if (connection != null) connection.close();
       // }
       // //return the comment to print it
       // return;
   // }




