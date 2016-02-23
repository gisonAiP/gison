package edu.upc.eetac.dsa.group7;

import edu.upc.eetac.dsa.group7.dao.NoteDAO;
import edu.upc.eetac.dsa.group7.dao.NoteDAOImp;

import edu.upc.eetac.dsa.group7.entity.AuthToken;
import edu.upc.eetac.dsa.group7.entity.Note;
import edu.upc.eetac.dsa.group7.entity.NoteCollection;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.*;
import javax.ws.rs.core.SecurityContext;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;

/**
 * Created by LENOVO on 2016-02-23.
 */
//Methods related to comments
//Path with the commented restaurant identifier
@Path("/id_kat/{id_katid}/notes")
public class NoteResource {
    @Context
    private SecurityContext securityContext;

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(WhereMediaType.WHERE_NOTE)

    public Note createNote(@FormParam("lng") Float lng, @FormParam("lat") Float lat, @FormParam("name") String name, @FormParam("uwaga") String uwaga, @Context UriInfo uriInfo) throws URISyntaxException {
        if (lng == null || lat == null || name == null || uwaga == null) {
            throw new BadRequestException("all parameters are mandatory");
            //check if all the parameters are correct
        }


        //nitiate the needed objects
        NoteDAO noteDAO = new NoteDAOImp();
        //UserDAO userDAO = new UserDAOImpl();
        Note note;
        AuthToken authenticationToken = null;
        //try {
         //if (userDAO.owner(securityContext.getUserPrincipal().getName()) == true || userDAO.admin(securityContext.getUserPrincipal().getName()) == true) {
        //call the function to add the restaurant to database
          //  restaurant = restaurantDAO.createRestaurant(name, description, avgprice, securityContext.getUserPrincipal().getName(), address, phone, lat, lng);
        // } else {
             //throw an error if you don't have a owner profile
         //throw new BadRequestException("You must have an owner profile to create a restaurant!");
        // }


        //URI uri = new URI(uriInfo.getAbsolutePath().toString() + "/" + restaurant.getId());
         return note;

    }


    @GET
    @Produces(WhereMediaType.WHERE_NOTE_COLLECTION)
    //method to get all the comments
    public NoteCollection getNotes(@PathParam("id_katid") String id_katid) {
        //initiates variables and call the function to print all the comments of the restaurant
        NoteCollection noteCollection = null;
        NoteDAO noteDAO = new NoteDAOImp();
        try {
            noteCollection = noteDAO.getNotes(id_katid);
        } catch (SQLException e) {
            throw new InternalServerErrorException();
        }
        //return all the comments of this restaurant
        return noteCollection;
    }

    @Path("/{id}")
    @GET
    @Produces(WhereMediaType.WHERE_NOTE)
    //method to get the only one comment giving its id
    public Note getNote(@PathParam("id") String id) {
        Note note = null;
        NoteDAO noteDAO = new NoteDAOImp();
        try {
            //try to search a commment with this id
            note = noteDAO.getNoteById(id);
            if (note == null)
                //return an error if not exists
                throw new NotFoundException("Comment with id = " + id + " doesn't exist");
        } catch (SQLException e) {
            //return an error if the sql query fails
            throw new InternalServerErrorException();
        }
        return note;
    }
}