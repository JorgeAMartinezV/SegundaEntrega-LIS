package co.edu.unicauca.api_rest_conference.capaAccesoADatos.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;
import java.util.Date;
import java.util.ArrayList;
@Getter
@Setter
@AllArgsConstructor
public class ConferenceEntity {
    private Integer id; /*Id de la conferencia */
    private String name; /*Nombre de la conferencia */
    private Date startDate; /*Fecha de inicio de la conferencia */
    private Date endDate; /*Fecha de fin de la conferencia */
    private float registrationCost; /*Costo de la inscripción a la conferencia */
    private String location; /*Ubicación de la conferencia */
    private List<String> topics;  /*Temas de la conferencia */
    private List<Integer> articles; /*Artículos asociados a la conferencia */

    public ConferenceEntity() {
        this.articles = new ArrayList<>();     // Inicializa articles como ArrayList
    }

    public void storeArticles(Integer... articleIds) {
        for (Integer articleId : articleIds) {
            articles.add(articleId);
        }
    }
    public Integer getId() {
        return id;
    }
    
}
