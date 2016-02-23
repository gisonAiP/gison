package edu.upc.eetac.dsa.group7.entity;

import edu.upc.eetac.dsa.group7.*;
import org.glassfish.jersey.linking.Binding;
import org.glassfish.jersey.linking.InjectLink;
import org.glassfish.jersey.linking.InjectLinks;

import javax.ws.rs.core.Link;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by LENOVO on 2016-02-22.
 */
public class Note {
    @InjectLinks({

            @InjectLink(resource = WhereRootAPIResource.class, style = InjectLink.Style.ABSOLUTE, rel = "home", title = "Where Root API"),
            @InjectLink(resource = NoteResource.class, style = InjectLink.Style.ABSOLUTE, rel = "current-notes", title = "Current notes"),
            @InjectLink(resource = NoteResource.class, style = InjectLink.Style.ABSOLUTE, rel = "create-notes", title = "Create notes", type = MediaType.APPLICATION_FORM_URLENCODED),
            @InjectLink(resource = NoteResource.class, method = "getNote", style = InjectLink.Style.ABSOLUTE, rel = "self note", title = "Note", bindings = @Binding(name = "id", value = "${instance.id}")),
            @InjectLink(resource = LoginResource.class, style = InjectLink.Style.ABSOLUTE, rel = "logout", title = "Logout"),
            @InjectLink(resource = UserResource.class, method = "getUser", style = InjectLink.Style.ABSOLUTE, rel = "user-profile", title = "User profile", bindings = @Binding(name = "id_wlas", value = "${instance.creator}")),
           // @InjectLink(resource = RestaurantResource.class, method = "getRestaurant", style = InjectLink.Style.ABSOLUTE, rel = "restaurant-profile", title = "Restaurant profile", bindings = @Binding(name = "restaurant", value = "${instance.restaurant}")),
            @InjectLink(resource = NoteResource.class, method = "getComments", style = InjectLink.Style.ABSOLUTE, rel = "next", title = "Newer comments", bindings = {@Binding(name = "timestamp", value = "${instance.creation_timestamp}"), @Binding(name = "before", value = "false")}),
            @InjectLink(resource = NoteResource.class, method = "getComments", style = InjectLink.Style.ABSOLUTE, rel = "previous", title = "Older comments", bindings = {@Binding(name = "timestamp", value = "${instance.creation_timestamp}"), @Binding(name = "before", value = "true")}),



    })
    private List<Link> links;
    private String id;
    private float lng;
    private float lat;
    private String id_kat;
    private String name;
    private String uwaga;
    private String id_wlas;
    private long creation_timestamp;


    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLng() {
        return lng;
    }

    public void setLng(float lng) {
        this.lng = lng;
    }

    public String getId_kat() {
        return id_kat;
    }

    public void setId_kat(String id_kat) {
        this.id_kat = id_kat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getUwaga() {
        return uwaga;
    }

    public void setUwaga(String uwaga) {
        this.uwaga = uwaga;
    }

    public String getId_wlas() {
        return id_wlas;
    }

    public void setId_wlas(String id_wlas) {
        this.id_wlas = id_wlas;
    }


    public void setCreation_timestamp(long creation_timestamp) {
        this.creation_timestamp = creation_timestamp;
    }
}
