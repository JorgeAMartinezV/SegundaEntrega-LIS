package co.edu.unicauca.microservicio_gestion_articulos.fachadaServices.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import co.edu.unicauca.microservicio_gestion_articulos.capaAccesoADatos.models.ArticleEntity;
import co.edu.unicauca.microservicio_gestion_articulos.capaAccesoADatos.repositories.ArticleRepository;
import co.edu.unicauca.microservicio_gestion_articulos.fachadaServices.DTO.ArticleDTO;
import co.edu.unicauca.microservicio_gestion_articulos.fachadaServices.rabbit.MessageProducer;


@Service
public class ArticleServiceImpl implements IArticleService{
    private ArticleRepository servicioAccesoBaseDatos;
    private ModelMapper modelMapper;
	private MessageProducer servicioEnviarCorreo;

    public ArticleServiceImpl(ArticleRepository servicioAccesoBaseDatos, ModelMapper modelMapper, MessageProducer servicioEnviarCorreo) {
		this.servicioAccesoBaseDatos = servicioAccesoBaseDatos;
		this.modelMapper = modelMapper;
		this.servicioEnviarCorreo = servicioEnviarCorreo;
	}

    @Override
	public List<ArticleDTO> findAll() {

		List<ArticleEntity> articulosEntity = this.servicioAccesoBaseDatos.findAll();
		List<ArticleDTO> articulosDTO = this.modelMapper.map(articulosEntity, new TypeToken<List<ArticleDTO>>() {
		}.getType());
		return articulosDTO;
	}

    @Override
	public ArticleDTO findById(Integer id) {
		ArticleEntity objArticleEntity = this.servicioAccesoBaseDatos.findById(id);
		if(objArticleEntity == null){
			return null;
		}
		ArticleDTO articleDTO = this.modelMapper.map(objArticleEntity, ArticleDTO.class);
		return articleDTO;
	}

    @Override
	public ArticleDTO save(ArticleDTO articulo) {
		ArticleEntity articuloEntity = this.modelMapper.map(articulo, ArticleEntity.class);
		ArticleEntity objArticleEntity = this.servicioAccesoBaseDatos.save(articuloEntity);
		ArticleDTO articuloDTO = this.modelMapper.map(objArticleEntity, ArticleDTO.class);
		servicioEnviarCorreo.sendMessage(articuloDTO);
		return articuloDTO;
	}

    @Override
	public ArticleDTO update(Integer id, ArticleDTO articulo) {
		ArticleEntity articleEntity = this.modelMapper.map(articulo, ArticleEntity.class);
		ArticleEntity articleEntityActualizado = this.servicioAccesoBaseDatos.update(id, articleEntity);
		ArticleDTO articleDTO = this.modelMapper.map(articleEntityActualizado, ArticleDTO.class);
		return articleDTO;
	}

    @Override
	public boolean delete(Integer id) {
		return this.servicioAccesoBaseDatos.delete(id);
	}
}
