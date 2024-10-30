package co.edu.unicauca.api_rest_conferencia.fachadaServices.services;

import java.util.List;
import co.edu.unicauca.api_rest_conferencia.fachadaServices.DTO.ConferenciaDTO;

public interface IConferenciaService {
    /**
     * Buscar todas las conferencias
     * @return lista de conferencias
     */
    public List<ConferenciaDTO> findAll();

    /**
     * Buscar una conferencia por su id
     * @param id id de la conferencia
     * @return conferencia, o null si no se encuentra
     */
    public ConferenciaDTO findById(Integer id);

    /**
     * Guardar una conferencia
     * @param conferencia conferencia a guardar en la base de datos
     * @return conferencia guardada
     */
    public ConferenciaDTO save(ConferenciaDTO conferencia);

    /**
     * Actualizar una conferencia
     * @param conferencia conferencia a actualizar
     * @return conferencia actualizada
     */
    public ConferenciaDTO update(ConferenciaDTO conferencia);

    /**
     * Consultar la cantidad maxima de articulos que puede tener una conferencia
     * @param id id de la conferencia
     * @return cantidad maxima de articulos
     */
    public int getCantMaxArticulos(Integer id);

    /**
     * Listar las conferencias de un articulo
     * @param idArticulo id del articulo
     * @return Lista de conferencias del articulo
     */
    public List<ConferenciaDTO> obtenerConferenciasDeArticulo(Integer idArticulo);

    /**
     * Eliminar una conferencia
     * @param id id de la conferencia
     * @return true si se elimino correctamente, false de lo contrario
     */
    public boolean delete(Integer id);

    /**
     * Verificar si existe una conferencia
     * @param id id de la conferencia
     * @return true si existe, false de lo contrario
     */
    public boolean existConference(Integer id);

    /**
     * Consultar la cantidad de articulos de una conferencia
     * @param id id de la conferencia
     * @return cantidad de articulos
     */
    public int getCantArticulos(Integer id);
}
