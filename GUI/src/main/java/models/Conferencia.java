package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Conferencia {
    private int id; /*Id de la conferencia */
    private String name; /*Nombre de la conferencia */
    private Date startDate; /*Fecha de inicio de la conferencia */
    private Date endDate; /*Fecha de fin de la conferencia */
    private float registrationCost; /*Costo de la inscripción a la conferencia */
    private String location; /*Ubicación de la conferencia */
    private List<String> topics;  /*Temas de la conferencia */
    private List<Integer> articles; /*Artículos asociados a la conferencia */


    public Conferencia(String name, Date startDate, Date endDate, float registrationCost, String location, List<String> topics) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.registrationCost = registrationCost;
        this.location = location;
        this.topics = topics;
        this.articles = new ArrayList<>();
    }

    public Conferencia() {}

    public String getName() {
        return name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public float getRegistrationCost() {
        return registrationCost;
    }

    public String getLocation() {
        return location;
    }

    public List<String> getTopics() {
        return topics;
    }

    public void setTopics(List<String> topics) {
        this.topics = topics;
    }

    public String topicsToString() {
        if (topics.isEmpty()) 
            return ""; 

        return String.join(", ", topics);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Integer> getArticles() {
        return articles;
    }
}
