package edu.upc.eetac.dsa.group7;

import edu.upc.eetac.dsa.group7.dao.AuthTokenDAO;
import edu.upc.eetac.dsa.group7.dao.AuthTokenDAOImpl;
import edu.upc.eetac.dsa.group7.dao.UserDAO;
import edu.upc.eetac.dsa.group7.dao.UserDAOImpl;
import edu.upc.eetac.dsa.group7.entity.AuthToken;
import edu.upc.eetac.dsa.group7.entity.User;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import java.sql.SQLException;

/**
 * Created by Alex on 6/12/15.
 */
@Path("login")
public class LoginResource {
    @Context
    SecurityContext securityContext;

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(WhereMediaType.WHERE_AUTH_TOKEN)
    public AuthToken login(@FormParam("login") String loginid, @FormParam("password") String password) {
        if(loginid == null || password == null)
            throw new BadRequestException("all parameters are mandatory");

        User user = null;
        AuthToken authToken = null;
        try{
            UserDAO userDAO = new UserDAOImpl();
            user = userDAO.getUserByLoginid(loginid);
            if(user == null)
                throw new BadRequestException("loginid " + loginid + " not found.");
            if(!userDAO.checkPassword(user.getId(), password))
                throw new BadRequestException("incorrect password");

            AuthTokenDAO authTokenDAO = new AuthTokenDAOImpl();
            authTokenDAO.deleteToken(user.getId());
            authToken = authTokenDAO.createAuthToken(user.getId());
        }catch(SQLException e){
            throw new InternalServerErrorException();
        }
        return authToken;
    }

    @DELETE
    public void logout(){
        String userid = securityContext.getUserPrincipal().getName();
        AuthTokenDAO authTokenDAO = new AuthTokenDAOImpl();
        try {
            authTokenDAO.deleteToken(userid);
        } catch (SQLException e) {
            throw new InternalServerErrorException();
        }
    }

    @Path("/{id}")
    @GET
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(WhereMediaType.WHERE_AUTH_TOKEN)
    public User check(@PathParam("id") String loginid) {
        if(loginid == null)
            throw new BadRequestException("all parameters are mandatory");
        User user = null;
        //AuthToken authToken = null;
        try{
            UserDAO userDAO = new UserDAOImpl();
            user = userDAO.getUserById(loginid);
            if(user == null)
                throw new BadRequestException("loginid " + loginid + " not found.");
            if (!(userDAO.owner(securityContext.getUserPrincipal().getName()) == true || userDAO.admin(securityContext.getUserPrincipal().getName()) == true)) {
                //call the function to add the restaurant to database
                // restaurant = restaurantDAO.createRestaurant(name, description, avgprice, securityContext.getUserPrincipal().getName(), address, phone, lat, lng);
                // } else {
                //throw an error if you don't have a owner profile
                throw new BadRequestException("You must have an owner profile to create a restaurant!");
            }
            // AuthTokenDAO authTokenDAO = new AuthTokenDAOImpl();
            // authTokenDAO.deleteToken(user.getId());
            // authToken = authTokenDAO.createAuthToken(user.getId());
        }catch(SQLException e){
            throw new InternalServerErrorException();
        }
        return user;
    }
}
