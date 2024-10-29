
package co.edu.unicauca.microservicio_gestion_articulos.capaAccesoADatos.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter; 

@Getter //genera todos los gets para todos los atributos
@Setter //genera todos los sets para todos los atributos
@AllArgsConstructor //genera todos los constructores para todos los atributos combinados, menos el vacio
public class ArticleEntity {
    private Integer id;
    private String title;
    private String journal;
    private String abstractText;
    private String keywords;
    private Integer cantAuthors;

    public ArticleEntity(){
    }
}

