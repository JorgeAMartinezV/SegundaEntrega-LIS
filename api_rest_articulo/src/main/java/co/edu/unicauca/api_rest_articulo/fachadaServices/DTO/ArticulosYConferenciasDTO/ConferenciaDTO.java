package co.edu.unicauca.api_rest_articulo.fachadaServices.DTO.ArticulosYConferenciasDTO;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ConferenciaDTO {
    private int id; /*Id de la conferencia */
    private String name; /*Nombre de la conferencia */
    private Date startDate; /*Fecha de inicio de la conferencia */
    private Date endDate; /*Fecha de fin de la conferencia */
    private float registrationCost; /*Costo de la inscripción a la conferencia */
    private String location; /*Ubicación de la conferencia */
    private int cantMaxArticulos; /*Cantidad máxima de artículos que se pueden inscribir en la conferencia */

    public ConferenciaDTO() {
    }
}
