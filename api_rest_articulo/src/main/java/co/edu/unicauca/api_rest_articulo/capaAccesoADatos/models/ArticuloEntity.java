package co.edu.unicauca.api_rest_articulo.capaAccesoADatos.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ArticuloEntity {
    private Integer id;
    private String title;
    private String journal;
    private String abstractText;
    private String keywords;
    private Integer cantAuthors;

    public ArticuloEntity() {
    }
}
