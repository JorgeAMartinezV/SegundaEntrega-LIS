package co.edu.unicauca.api_rest_articulo.fachadaServices.DTO.CRUDArticulosDTO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter 
public class ArticuloDTO {
    private Integer id; //Id del articulo
    private String title; // Titulo del articulo
    private String journal; // Revista del articulo
    private String abstractText; // Resumen del articulo
    private String keywords; // Palabras clave del articulo
    private Integer cantAuthors; // Cantidad de autores del articulo
    List<ConferenciaDTO> conferencias; // Lista de conferencias

    public ArticuloDTO() {
    }
}
