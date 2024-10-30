package co.edu.unicauca.api_rest_articulo.fachadaServices.services;

import java.util.List;

import co.edu.unicauca.api_rest_articulo.fachadaServices.DTO.ArticulosYConferenciasDTO.ArticulosConConferenciasDTO;
import co.edu.unicauca.api_rest_articulo.fachadaServices.DTO.ArticulosYConferenciasDTO.ConferenciaDTO;
import co.edu.unicauca.api_rest_articulo.fachadaServices.DTO.CRUDArticulosDTO.ArticuloDTO;

public interface IArticuloService {
    public List<ArticuloDTO> findAll();

    public ArticuloDTO findById(Integer id);

    public ArticuloDTO save(ArticuloDTO articulo);

    public ArticuloDTO update(Integer id, ArticuloDTO articulo);

    public boolean delete(Integer id); 

    public List<ConferenciaDTO> ListarConferenciasDeArticulo(Integer idArticulo);

    public ArticulosConConferenciasDTO listarDatosArticulosConSusConferencias(Integer idArticulo);
}
