package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Conferencia {
    private Integer id; /*Id de la conferencia */
    private String name; /*Nombre de la conferencia */
    private Date startDate; /*Fecha de inicio de la conferencia */
    private Date endDate; /*Fecha de fin de la conferencia */
    private float registrationCost; /*Costo de la inscripción a la conferencia */
    private String location; /*Ubicación de la conferencia */
    private int cantMaxArticles;
    private List<Articulo> articles; /*Artículos asociados a la conferencia */


    public Conferencia(String name, Date startDate, Date endDate, float registrationCost, String location, int cantMaxArticles) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.registrationCost = registrationCost;
        this.location = location;
        this.cantMaxArticles = cantMaxArticles;
        this.articles = new ArrayList<>();
        this.id = 0;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Articulo> getArticles() {
        return articles;
    }

    public int getCantMaxArticles() {
        return cantMaxArticles;
    }

    public void setCantMaxArticles(int cantMaxArticles) {
        this.cantMaxArticles = cantMaxArticles;
    }
    
    @Override
    public String toString() {
        return this.name; // o el atributo que quieres mostrar en el JComboBox
    }
}
