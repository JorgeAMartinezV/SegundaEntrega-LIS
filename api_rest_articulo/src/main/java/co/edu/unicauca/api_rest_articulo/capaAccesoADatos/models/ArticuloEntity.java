package co.edu.unicauca.api_rest_articulo.capaAccesoADatos.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ArticuloEntity {
    private Integer id; //Id del articulo
    private String title; // Titulo del articulo
    private String journal; // Revista del articulo
    private String abstractText; // Resumen del articulo
    private String keywords; // Palabras clave del articulo
    private Integer cantAuthors; // Cantidad de autores del articulo

    public ArticuloEntity() {
    }
}
