package services;

import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import models.Conferencia;

public class ConferenciaServices {
    private final String endPoint;
    private final Client clientReqObj;

    public ConferenciaServices() {
        this.endPoint = "http://localhost:8080/api/conferencias";
        this.clientReqObj = ClientBuilder.newClient();
    }

    // Method to save a new conference
    public Conferencia save(Conferencia conference) {
        Conferencia storedConference = clientReqObj
                .target(endPoint)
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(conference, MediaType.APPLICATION_JSON), Conferencia.class);
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
                .target(endPoint)
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<Conferencia>>() {});
    }

    // Method to update a conference by ID
    public Conferencia update(int id, Conferencia newConference) {
        Conferencia updateConference = clientReqObj
                .target(endPoint + "/" + id)
                .request(MediaType.APPLICATION_JSON)
                .put(Entity.entity(newConference, MediaType.APPLICATION_JSON), Conferencia.class);
        return updateConference;
    }

    // Method to delete a conference by ID
    public boolean delete(Integer id) {
        Response response = clientReqObj
                .target(endPoint + "/" + id)
                .request(MediaType.APPLICATION_JSON)
                .delete();
        return response.getStatus() == 200;
    }
    
    public int getCantMaxArticles(Integer id) {
        return clientReqObj
                .target(endPoint + "/cantMaxArticulos/" + id)
                .request(MediaType.APPLICATION_JSON)
                .get(int.class);
    }
}
