package edu.upc.eetac.dsa.group7.entity;

import org.glassfish.jersey.linking.InjectLinks;

import javax.ws.rs.core.Link;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by LENOVO on 2016-02-22.
 */
public class CategoryCollection {
    @InjectLinks({})
    private List<Link> links;
    private long newestTimestamp;
    private long oldestTimestamp;
    private List<Category> categories = new ArrayList<>();

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public long getNewestTimestamp() {
        return newestTimestamp;
    }

    public void setNewestTimestamp(long newestTimestamp) {
        this.newestTimestamp = newestTimestamp;
    }

    public long getOldestTimestamp() {
        return oldestTimestamp;
    }

    public void setOldestTimestamp(long oldestTimestamp) {
        this.oldestTimestamp = oldestTimestamp;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setRestaurants(List<Category> categories) {
        this.categories= categories;
    }
}


