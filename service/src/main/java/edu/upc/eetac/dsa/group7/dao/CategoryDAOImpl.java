package edu.upc.eetac.dsa.group7.dao;

import edu.upc.eetac.dsa.group7.db.Database;
import edu.upc.eetac.dsa.group7.entity.*;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Created by LENOVO on 2016-02-22.
 */
public class CategoryDAOImpl implements CategoryDAO {


    @Override
    public CategoryCollection getCategories() throws SQLException {

        CategoryCollection categoryCollection = new  CategoryCollection();
        //initiate variables and database connection
        Connection connection = null;
        PreparedStatement stmt = null;
        try {
            connection = Database.getConnection();
            //call the SQL Query to store the response
            stmt = connection.prepareStatement(CategoryDAOQuery.GET_CATEGORIES);



            //Using a while to store all the data from database
            ResultSet rs = stmt.executeQuery();
            boolean first = true;
            while (rs.next()) {

                Category category = new Category();
                category.setId(rs.getString("id"));
                category.setName(rs.getString("name"));
                categoryCollection.getCategories().add(category);
            }

        } catch (SQLException e) {
            throw e;
            //throw error if it fails
        } finally {
            //close the connection
            if (stmt != null) stmt.close();
            if (connection != null) connection.close();
        }
        //return the comment to print it
        return categoryCollection;


    }






}

