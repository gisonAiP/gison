package edu.upc.eetac.dsa.group7.dao;

import edu.upc.eetac.dsa.group7.entity.Restaurant;

/**
 * Created by LENOVO on 2016-02-22.
 */
public interface CategoryDAO {
    public Restaurant createRestaurant(String name, String description, Float avgprice, String owner, String address, String phone, float lat, float lng) throws SQLException;
    public Restaurant getRestaurantById(String id) throws SQLException;
    public RestaurantCollection getRestaurants() throws SQLException;
    public Restaurant updateRestaurant(String id, String description, Float avgprice, String phone) throws SQLException;
    public boolean deleteRestaurant(String id) throws SQLException;
    public Restaurant voteRestaurant(String id, int likes) throws SQLException;
    public RestaurantCollection searchRestaurant(String word) throws SQLException;
}
