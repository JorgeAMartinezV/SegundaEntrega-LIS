package services;

import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import models.Articulo;
import models.Conferencia;
import org.glassfish.jersey.jackson.JacksonFeature;

public class ArticuloServices {
    private String endPoint; // Store the response from the web service listening in a port
    private Client clientReqObj; // Reference of an object that sends requests

    public ArticuloServices() {
        this.endPoint = "http://localhost:5000/api/articulos";
        this.clientReqObj = ClientBuilder.newClient().register(new JacksonFeature());
    }

    public Articulo storeArticle(Articulo article) {
        WebTarget target = clientReqObj.target(endPoint);
        Entity<Articulo> articleFormatted = Entity.entity(article, MediaType.APPLICATION_JSON);
        Invocation.Builder requestObj = target.request(MediaType.APPLICATION_JSON);

        Articulo storedArticle = requestObj.post(articleFormatted, Articulo.class);
        return storedArticle;
    }

    // Method to find an article by its ID
    public Articulo findById(int id) {
        WebTarget target = clientReqObj.target(endPoint + "/" + id);
        Invocation.Builder requestObj = target.request(MediaType.APPLICATION_JSON);
        return requestObj.get(Articulo.class);
    }

    // Method to find all articles
    public List<Articulo> findAll() {
        WebTarget target = clientReqObj.target(endPoint);
        Invocation.Builder requestObj = target.request(MediaType.APPLICATION_JSON);
        return requestObj.get(new GenericType<List<Articulo>>() {});
    }

    // Method to update an article
    public Articulo update(int id, Articulo article) {
        WebTarget target = clientReqObj.target(endPoint + "/" + id);
        Entity<Articulo> articleFormatted = Entity.entity(article, MediaType.APPLICATION_JSON);
        Invocation.Builder requestObj = target.request(MediaType.APPLICATION_JSON);
        return requestObj.put(articleFormatted, Articulo.class);
    }

    // Method to delete an article by its ID
    public boolean delete(Integer id) {
        WebTarget target = this.clientReqObj.target(endPoint + "/" + id);
        Invocation.Builder requestObj = target.request(MediaType.APPLICATION_JSON_TYPE);
        Response response = requestObj.delete();
        return response.getStatus() == Response.Status.NO_CONTENT.getStatusCode();
    }

    // Method to check if an article exists
    public boolean exists(int id) {
        Articulo article = findById(id);
        return article != null;
    }
}
