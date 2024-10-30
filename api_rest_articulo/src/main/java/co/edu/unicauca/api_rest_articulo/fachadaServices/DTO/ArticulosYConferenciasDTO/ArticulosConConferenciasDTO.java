package co.edu.unicauca.api_rest_articulo.fachadaServices.DTO.ArticulosYConferenciasDTO;

import java.util.List;

import co.edu.unicauca.api_rest_articulo.fachadaServices.DTO.CRUDArticulosDTO.ArticuloDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ArticulosConConferenciasDTO {
    private ArticuloDTO objArticuloDTO;
    private List<ConferenciaDTO> conferencias;
}
