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
    @InjectLinks({})
    private List<Link> links;
    private String id;
    private float lng;
    private float lat;
    private String id_kat;
    private String uwaga;
    private String id_wlas;


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


}
