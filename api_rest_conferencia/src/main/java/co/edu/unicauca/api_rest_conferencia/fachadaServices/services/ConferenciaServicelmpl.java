package co.edu.unicauca.api_rest_conferencia.fachadaServices.services;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicauca.api_rest_conferencia.capaAccesoADatos.repositories.ConferenciaRepository;
import co.edu.unicauca.api_rest_conferencia.fachadaServices.DTO.ConferenciaDTO;

import java.util.List;
import co.edu.unicauca.api_rest_conferencia.capaAccesoADatos.models.ConferenciaEntity;

@Service
public class ConferenciaServicelmpl implements IConferenciaService {

    @Autowired
    private ConferenciaRepository servicioAccesoBaseDatos;
    private ModelMapper modelMapper;

    public ConferenciaServicelmpl(ConferenciaRepository servicioAccesoBaseDatos, ModelMapper modelMapper) {
        this.servicioAccesoBaseDatos = servicioAccesoBaseDatos;
        this.modelMapper = modelMapper;
        this.modelMapper.typeMap(ConferenciaEntity.class, ConferenciaDTO.class).addMappings(mapper -> {
            mapper.map(ConferenciaEntity::getArticles, ConferenciaDTO::setArticles);
        });
    }

    @Override
    public List<ConferenciaDTO> findAll() {
        List<ConferenciaEntity> conferenciaEntity = this.servicioAccesoBaseDatos.findAll();
        List<ConferenciaDTO> conferenciaDTO = this.modelMapper.map(conferenciaEntity, new TypeToken<List<ConferenciaDTO>>() {
        }.getType());
        return conferenciaDTO;
    }

    @Override
    public ConferenciaDTO findById(Integer id) {
        ConferenciaEntity conferenciaEntity = this.servicioAccesoBaseDatos.findById(id);
        if(conferenciaEntity == null){
            return null;
        }
        ConferenciaDTO conferenciaDTO = this.modelMapper.map(conferenciaEntity,  ConferenciaDTO.class);
        return conferenciaDTO;
    }

    @Override
    public ConferenciaDTO save(ConferenciaDTO conferencia) {
        ConferenciaEntity conferenciaEntity = this.modelMapper.map(conferencia, ConferenciaEntity.class);
        ConferenciaEntity objConferenciaEntity = this.servicioAccesoBaseDatos.save(conferenciaEntity);
        ConferenciaDTO conferenciaDTO = this.modelMapper.map(objConferenciaEntity, ConferenciaDTO.class);
        return conferenciaDTO;
    }

    @Override
    public ConferenciaDTO update(ConferenciaDTO conferencia) {
        ConferenciaEntity conferenciaEntity = this.modelMapper.map(conferencia, ConferenciaEntity.class);
        ConferenciaEntity objConferenciaEntity = this.servicioAccesoBaseDatos.update(conferenciaEntity);
        if(objConferenciaEntity == null) {
            return null;
        }
        ConferenciaDTO conferenciaDTO = this.modelMapper.map(objConferenciaEntity, ConferenciaDTO.class);
        return conferenciaDTO;
    }

    @Override
    public int getCantMaxArticulos(Integer id) {
        int cantArticulos = this.servicioAccesoBaseDatos.getCantMaxArticulos(id);
        return cantArticulos;
    }

    @Override
    public List<ConferenciaDTO> obtenerConferenciasDeArticulo(Integer idArticulo) {
        List<ConferenciaEntity> listaConferencias = this.servicioAccesoBaseDatos.obtenerConferenciasDeArticulo(idArticulo);
        List<ConferenciaDTO> conferenciasDTO = this.modelMapper.map(listaConferencias, new TypeToken<List<ConferenciaDTO>>() {
        }.getType());
        return conferenciasDTO;
    }

    @Override
    public boolean delete(Integer id) {
        return this.servicioAccesoBaseDatos.delete(id);
    }
    
}
