package co.edu.unicauca.microservicio_gestion_articulos.fachadaServices.services;

import java.util.List;

import co.edu.unicauca.microservicio_gestion_articulos.fachadaServices.DTO.ArticleDTO;

public interface IArticleService {
	/**
	 * @brief Lista de todos los articulos
	 * @return lista de todos los articulos
	 */
    public List<ArticleDTO> findAll();

	/**
	 * @brief Buscar articulo especifico
	 * @param id
	 * @return articulo
	 */
	public ArticleDTO findById(Integer id);

	/**
	 * @brief Almacenar un articulo
	 * @param article
	 * @return articulo almacenado
	 */
	public ArticleDTO save(ArticleDTO article);

	/**
	 * @brief actualizar articulo
	 * @param id
	 * @param cliente
	 * @return articulo actulziado
	 */
	public ArticleDTO update(Integer id, ArticleDTO cliente);

	/**
	 * @brief Eliminar articulo
	 * @param id
	 * @return true/false
	 */
	public boolean delete(Integer id);
}
