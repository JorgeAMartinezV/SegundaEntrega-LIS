package co.edu.unicauca.microservicio_gestion_articulos.fachadaServices.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

//esta clase encapsula datos que viajan de articulo al servidor
@Getter
@Setter
@AllArgsConstructor
public class ArticleDTO {
    private Integer id;
    private String title;
    private String journal;
    private String abstractText;
    private String keywords;
    private Integer cantAuthors;

    public ArticleDTO(){
    
    }
}
