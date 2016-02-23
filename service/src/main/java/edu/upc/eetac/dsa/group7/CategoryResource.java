package edu.upc.eetac.dsa.group7;

/**
 * Created by student on 2016-02-23.
 */

import edu.upc.eetac.dsa.group7.dao.*;
import edu.upc.eetac.dsa.group7.entity.AuthToken;
import edu.upc.eetac.dsa.group7.entity.CategoryCollection;
import edu.upc.eetac.dsa.group7.entity.Restaurant;
import edu.upc.eetac.dsa.group7.entity.RestaurantCollection;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;

@Path("categories")
//methods related to restaurants
public class CategoryResource {
    @Context
    private SecurityContext securityContext;


    @GET
    @Produces(WhereMediaType.WHERE_CATEGORY_COLLECTION)
    public CategoryCollection getCategories() {
        //gets all the restaurants
        CategoryCollection categoryCollection = null;
        CategoryDAO categoryDAO = new CategoryDAOImpl();
        try {
            categoryCollection = categoryDAO.getCategories();
        } catch (SQLException e) {
            //catch SQL errors sends from DAOImpl
            throw new InternalServerErrorException();
        }
        //Return the collection
        return categoryCollection;
    }

}

