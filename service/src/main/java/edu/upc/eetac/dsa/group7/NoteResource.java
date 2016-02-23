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
    //Create a restaurant giving title, comment and like/dislike (+1/-1)
    public Response createNote(@PathParam("id_katid") String id_katid, @FormParam("title") String title, @FormParam("note") String noteBody, @Context UriInfo uriInfo) throws URISyntaxException {
        if (title == null || noteBody == null) {
            //check if all the parameters aren't null
            throw new BadRequestException("all parameters are mandatory");
        }
        //??? cos tu bedzie nie tak

        //initiates all the variables
        NoteDAO noteDAO = new NoteDAOImp();
        Note note = null;
        //RestaurantDAO restaurantDAO = new RestaurantDAOImpl();
       // Restaurant restaurant = null;
        AuthToken authenticationToken = null;
        try {
            //call the method to create a restaurant
            //using the securityContext we can extract the id of the creator
            note = noteDAO.createNote(securityContext.getUserPrincipal().getName(), id_katid, title, noteBody);
            restaurant = restaurantDAO.voteRestaurant(id_katid, likes);
        } catch (SQLException e) {
            //send an error if the insertion fails
            throw new InternalServerErrorException();
        }
        URI uri = new URI(uriInfo.getAbsolutePath().toString() + "/" + note.getId());
        //send back the created comment
        return Response.created(uri).type(WhereMediaType.WHERE_COMMENT).entity(note).build();
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