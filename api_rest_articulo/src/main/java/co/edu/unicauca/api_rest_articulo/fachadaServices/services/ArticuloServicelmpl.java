package co.edu.unicauca.api_rest_articulo.fachadaServices.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import co.edu.unicauca.api_rest_articulo.capaAccesoADatos.models.ArticuloEntity;
import co.edu.unicauca.api_rest_articulo.capaAccesoADatos.repositories.ArticuloRepository;
import co.edu.unicauca.api_rest_articulo.fachadaServices.DTO.ArticulosYConferenciasDTO.ArticulosConConferenciasDTO;
import co.edu.unicauca.api_rest_articulo.fachadaServices.DTO.ArticulosYConferenciasDTO.ConferenciaDTO;
import co.edu.unicauca.api_rest_articulo.fachadaServices.DTO.CRUDArticulosDTO.ArticuloDTO;
import co.edu.unicauca.api_rest_articulo.fachadaServices.rabbit.MessageProducer;

@Service
public class ArticuloServicelmpl implements IArticuloService {

    private ArticuloRepository servicioAccesoBaseDatos;
    private ModelMapper modelMapper;
    private ConferenciasService servicioConsumirObtencionConferencias;
    private final MessageProducer servicioEnviarCorreo;

    public ArticuloServicelmpl(ArticuloRepository servicioAccesoBaseDatos, ModelMapper modelMapper, ConferenciasService servicioConsumirObtencionConferencias, MessageProducer servicioEnviarCorreo) {
        this.servicioAccesoBaseDatos = servicioAccesoBaseDatos;
        this.modelMapper = modelMapper;
        this.servicioConsumirObtencionConferencias = servicioConsumirObtencionConferencias;
        this.servicioEnviarCorreo = servicioEnviarCorreo;
    }

    @Override
    public List<ArticuloDTO> findAll() {
        List<ArticuloEntity> articuloEntity = this.servicioAccesoBaseDatos.findAll();
        List<ArticuloDTO> articuloDTO = this.modelMapper.map(articuloEntity, new TypeToken<List<ArticuloDTO>>() {
        }.getType());
        return articuloDTO;
    }

    @Override
    public ArticuloDTO findById(Integer id) {
        ArticuloEntity objArticuloEntity = this.servicioAccesoBaseDatos.findById(id);
        if(objArticuloEntity == null){
            return null;
        }
        ArticuloDTO articuloDTO = this.modelMapper.map(objArticuloEntity,  ArticuloDTO.class);           
        return articuloDTO;
    }

    @Override
    public ArticuloDTO save(ArticuloDTO articulo) {
        ArticuloEntity articuloEntity = this.modelMapper.map(articulo, ArticuloEntity.class);
        ArticuloEntity objArticuloEntity = this.servicioAccesoBaseDatos.save(articuloEntity);
        ArticuloDTO articuloDTO = this.modelMapper.map(objArticuloEntity, ArticuloDTO.class);
        servicioEnviarCorreo.sendMessage(articuloDTO);
        return articuloDTO;
    }

    @Override
    public ArticuloDTO update(Integer id, ArticuloDTO articulo) {
        ArticuloEntity articuloEntity = this.modelMapper.map(articulo, ArticuloEntity.class);
        ArticuloEntity articuloEntityActualizado = this.servicioAccesoBaseDatos.update(id, articuloEntity);
        ArticuloDTO articuloDTO = this.modelMapper.map(articuloEntityActualizado, ArticuloDTO.class);
        servicioEnviarCorreo.sendMessage(articuloDTO);
        return articuloDTO;
    }

    @Override
    public boolean delete(Integer id) {
        return this.servicioAccesoBaseDatos.delete(id);
    }

    @Override
    public List<ConferenciaDTO> ListarConferenciasDeArticulo(Integer idArticulo) {
        return this.servicioConsumirObtencionConferencias.obtenerConferenciasDeArticulo(idArticulo);
    }
    
    @Override
    public ArticulosConConferenciasDTO listarDatosArticulosConSusConferencias(Integer idArticulo) {
        List<ConferenciaDTO> listaDeConferencias = this.servicioConsumirObtencionConferencias.obtenerConferenciasDeArticulo(idArticulo);
        ArticuloEntity objArticuloEntity = this.servicioAccesoBaseDatos.findById(idArticulo);
        ArticuloDTO objArticuloDTO = this.modelMapper.map(objArticuloEntity, ArticuloDTO.class);
        ArticulosConConferenciasDTO objArticuloConferencia = new ArticulosConConferenciasDTO(objArticuloDTO, listaDeConferencias);
        return objArticuloConferencia;
    }
}
