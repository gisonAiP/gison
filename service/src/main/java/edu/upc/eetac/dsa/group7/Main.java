package edu.upc.eetac.dsa.group7;

import org.glassfish.grizzly.http.server.HttpHandler;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.grizzly.http.server.NetworkListener;
import org.glassfish.grizzly.http.server.StaticHttpHandler;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * Main class.
 *
 */
public class Main {


    // Base URI the Grizzly HTTP server will listen on
    private static String baseURI;

    public final static String getBaseURI() {
        if (baseURI == null) {
            PropertyResourceBundle prb = (PropertyResourceBundle) ResourceBundle.getBundle("where");
            baseURI = prb.getString("where.context");
        }
        return baseURI;
    }

    /**
     * Starts Grizzly HTTP server exposing JAX-RS resources defined in this application.
     * @return Grizzly HTTP server.
     */
    public static HttpServer startServer() {
        // create a resource config that scans for JAX-RS resources and providers
        // in edu.upc.eetac.dsa.where package
        /*final ResourceConfig rc = new WhereResourceConfig();
        HttpServer httpServer = GrizzlyHttpServerFactory.createHttpServer(URI.create(getBaseURI()), rc);
        HttpHandler httpHandler = new StaticHttpHandler("../web");
        httpServer.getServerConfiguration().addHttpHandler(httpHandler, "/");
        for (NetworkListener l : httpServer.getListeners()){
            l.getFileCache().setEnabled(false);
        }
        return httpServer;*/
        final ResourceConfig rc = new WhereResourceConfig();
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(getBaseURI()), rc);

    }
    /**
     * Main method.
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        final HttpServer server = startServer();
    }
}

