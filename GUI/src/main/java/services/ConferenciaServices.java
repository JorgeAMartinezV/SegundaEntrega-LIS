package services;

import infraestructura.Subject;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import models.Articulo;
import models.Conferencia;

public class ConferenciaServices extends Subject {
    private final String endPoint;
    private final Client clientReqObj;

    public ConferenciaServices() {
        this.endPoint = "http://localhost:8080/api/conferences";
        this.clientReqObj = ClientBuilder.newClient();
    }

    // Method to save a new conference
    public Conferencia save(Conferencia conference) {
        Conferencia storedConference = clientReqObj
                .target(endPoint)
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(conference, MediaType.APPLICATION_JSON), Conferencia.class);

        notifyAllObservers();
        return storedConference;
    }

    // Method to find a conference by ID
    public Conferencia findById(int id) {
        return clientReqObj
                .target(endPoint + "/" + id)
                .request(MediaType.APPLICATION_JSON)
                .get(Conferencia.class);
    }

    // Method to list all conferences
    public List<Conferencia> findAll() {
        return clientReqObj
                .target(endPoint + "/list")
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<Conferencia>>() {});
    }

    // Method to update a conference by ID
    public Conferencia update(int id, Conferencia newConference) {
        Conferencia updateConference = clientReqObj
                .target(endPoint + "/" + id)
                .request(MediaType.APPLICATION_JSON)
                .put(Entity.entity(newConference, MediaType.APPLICATION_JSON), Conferencia.class);
        notifyAllObservers();
        return updateConference;
    }

    // Method to delete a conference by ID
    public boolean delete(int id) {
        Response response = clientReqObj
                .target(endPoint + "/" + id)
                .request(MediaType.APPLICATION_JSON)
                .delete();
        notifyAllObservers();
        return response.getStatus() == 200;
    }

    // Method to verify if a conference exists by ID
    public boolean exists(int id) {
        return clientReqObj
                .target(endPoint + "/exists")
                .queryParam("id", id)
                .request(MediaType.APPLICATION_JSON)
                .get(Boolean.class);
    }

    // Method to get articles by conference ID
    public List<Articulo> getArticlesByConferenceId(int idConference) {
        return clientReqObj
                .target(endPoint + "/getArticles/" + idConference)
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<Articulo>>() {});
    }

    // Method to add an article to a conference
    public boolean addArticleToConference(int idConference, int idArticle) {
        Response response = clientReqObj
                .target(endPoint + "/article/" + idConference + "/" + idArticle)
                .request(MediaType.APPLICATION_JSON)
                .put(Entity.text(""));

        notifyAllObservers();
        return response.getStatus() == 200;
    }
}
