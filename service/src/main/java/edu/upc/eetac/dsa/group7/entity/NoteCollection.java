package edu.upc.eetac.dsa.group7.entity;

import edu.upc.eetac.dsa.group7.CommentResource;
import edu.upc.eetac.dsa.group7.LoginResource;
import edu.upc.eetac.dsa.group7.WhereRootAPIResource;
import org.glassfish.jersey.linking.Binding;
import org.glassfish.jersey.linking.InjectLink;
import org.glassfish.jersey.linking.InjectLinks;

import javax.ws.rs.core.Link;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by LENOVO on 2016-02-22.
 */
public class NoteCollection {
    @InjectLinks({})
    private List<Link> links;
    private long newestTimestamp;
    private long oldestTimestamp;
    private List<Note> notes = new ArrayList<>();

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

    public List<Note> getNotes() {
        return notes ;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }
}


