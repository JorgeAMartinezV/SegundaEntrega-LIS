package co.edu.unicauca.api_rest_conferencia.fachadaServices.services;

import java.util.List;
import co.edu.unicauca.api_rest_conferencia.fachadaServices.DTO.ConferenciaDTO;

public interface IConferenciaService {
    public List<ConferenciaDTO> findAll();
    public ConferenciaDTO findById(Integer id);
    public ConferenciaDTO save(ConferenciaDTO conferencia);
    public ConferenciaDTO update(ConferenciaDTO conferencia);
    public int getCantMaxArticulos(Integer id);
    public List<ConferenciaDTO> obtenerConferenciasDeArticulo(Integer idArticulo);
    public boolean delete(Integer id);
}
