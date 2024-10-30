package co.edu.unicauca.api_rest_articulo.fachadaServices.services;

import java.util.List;

import co.edu.unicauca.api_rest_articulo.fachadaServices.DTO.ArticulosYConferenciasDTO.ArticulosConConferenciasDTO;
import co.edu.unicauca.api_rest_articulo.fachadaServices.DTO.ArticulosYConferenciasDTO.ConferenciaDTO;
import co.edu.unicauca.api_rest_articulo.fachadaServices.DTO.CRUDArticulosDTO.ArticuloDTO;

public interface IArticuloService {
    /**
     * Buscar todos los articulos
     * @return Lista de articulos
     */
    public List<ArticuloDTO> findAll();

    /**
     * Buscar un articulo por su id
     * @param id id del articulo
     * @return articulo
     */
    public ArticuloDTO findById(Integer id);

    /**
     * Guardar un articulo
     * @param articulo articulo a guardar en la base de datos
     * @return articulo guardado
     */
    public ArticuloDTO save(ArticuloDTO articulo);

    /**
     * Actualizar un articulo
     * @param id id del articulo
     * @param articulo articulo a actualizar
     * @return articulo actualizado
     */
    public ArticuloDTO update(Integer id, ArticuloDTO articulo);

    /**
     * Eliminar un articulo
     * @param id id del articulo
     * @return true si se elimino correctamente, false de lo contrario
     */
    public boolean delete(Integer id); 

    /**
     * Listar las conferencias de un articulo
     * @param idArticulo id del articulo
     * @return Lista de conferencias del articulo
     */
    public List<ConferenciaDTO> ListarConferenciasDeArticulo(Integer idArticulo);

    /**
     * Listar los datos de un articulo con sus conferencias
     * @param idArticulo id del articulo
     * @return Objeto de tipo ArticulosConConferenciasDTO
     */
    public ArticulosConConferenciasDTO listarDatosArticulosConSusConferencias(Integer idArticulo);

    /**
     * Metodo para verificar si un articulo existe
     * @param id Identificador del articulo
     * @return true si el articulo existe, false de lo contrario
     */
    public boolean articleExists(Integer id);
}
