package edu.upc.eetac.dsa.group7.dao;



import edu.upc.eetac.dsa.group7.entity.Category;
import edu.upc.eetac.dsa.group7.entity.CategoryCollection;

import java.sql.SQLException;

/**
 * Created by LENOVO on 2016-02-22.
 */
public interface CategoryDAO {
    //public Category createCategory(String id,String name) throws SQLException;
    //public Category getCategoryById(String id) throws SQLException;
    public CategoryCollection getCategories() throws SQLException;
    //public boolean deleteCategory(String id) throws SQLException;
   // public Restaurant voteRestaurant(String id, int likes) throws SQLException;
   // public RestaurantCollection searchRestaurant(String word) throws SQLException;
}
