package co.edu.unicauca.microservicio_gestion_articulos.capaAccesoADatos.repositories;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import co.edu.unicauca.microservicio_gestion_articulos.capaAccesoADatos.models.ArticleEntity;


@Repository
public class ArticleRepository {
    private ArrayList<ArticleEntity> listaDeArticulos;
	private int pos;

	public ArticleRepository() {
		this.listaDeArticulos = new ArrayList<ArticleEntity>();
		pos = this.listaDeArticulos.size()+1;
		//cargarArticulos();
	}
 
	/**
	 * @brief Retorna toda la lista de articulos
	 * @return lista de articulos
	 */
	public List<ArticleEntity> findAll() {
		System.out.println("Invocando a listar todos articulos");
		return this.listaDeArticulos;
	}

	/**
	 * @brief Retorna un articulo especifico
	 * @param id id del articulo
	 * @return articulo especifico
	 */
	public ArticleEntity findById(Integer id) {
		System.out.println("Invocando a consultar un articulo por id");
		ArticleEntity objArticulo = null;
		
		for (ArticleEntity articulo : listaDeArticulos) {
			if (articulo.getId() == id) {
				objArticulo = articulo;
				break;
			}
		}
		if(objArticulo == null){
			System.out.println("Article not found");
		}
		return objArticulo;
	}

	/**
	 * @brief almacenar articulo
	 * @param articulo articulo
	 * @return retorna el articulo almacenado
	 */
	public ArticleEntity save(ArticleEntity articulo) {
		System.out.println("Invocando a almacenar un articulo");
		articulo.setId(pos);
		ArticleEntity objArticulo = null;
		if (this.listaDeArticulos.add(articulo)) {
			objArticulo = articulo;
			pos++;
		}

		return objArticulo;
	}

	/**
	 * @brief actualza un articulo especifico
	 * @param id
	 * @param articulo
	 * @return retorna el articulo actualizado
	 */
	public ArticleEntity update(Integer id, ArticleEntity articulo) {
		System.out.println("Invocando a actualizar un articulo");
		ArticleEntity objArticulo = null;

		for (int i = 0; i < this.listaDeArticulos.size(); i++) {
			if (this.listaDeArticulos.get(i).getId().equals(id)) {
				this.listaDeArticulos.set(i, articulo);
				objArticulo = articulo;
				break;
			}
		}

		return objArticulo;
	}

	/**
	 * @brief Elimina un articulo especifico
	 * @param id
	 * @return true/false 
	 */
	public boolean delete(Integer id) {
		System.out.println("Invocando a eliminar un articulo");
		boolean bandera = false;
		for (int i = 0; i < this.listaDeArticulos.size(); i++) {
			if (this.listaDeArticulos.get(i).getId().equals(id)) {
				this.listaDeArticulos.remove(i);
				bandera = true;
				break;
			}
		}

		return bandera;
	}

	 /* 
	private void cargarArticulos() {
		ArticleEntity article1 = new ArticleEntity();
		article1.setId(1001);
		article1.setTitle("Advances in Artificial Intelligence");
		article1.setJournal("Journal of AI Research");
		article1.setAbstractText("This paper explores the latest advancements in artificial intelligence technologies...");
		article1.setKeywords("AI, Machine Learning, Deep Learning");
		article1.setListAuthors(Arrays.asList(301));
		article1.setListEvaluators(Arrays.asList(401, 402));
		ArticleEntity article2 = new ArticleEntity();
		article2.setId(1002);
		article2.setTitle("Blockchain Applications in Healthcare");
		article2.setJournal("Healthcare Technology Review");
		article2.setAbstractText("This study investigates how blockchain can revolutionize healthcare data management...");
		article2.setKeywords("Blockchain, Healthcare, Data Security");
		article2.setListAuthors(Arrays.asList(303, 301));
		article2.setListEvaluators(Arrays.asList(403, 402));
		ArticleEntity article3 = new ArticleEntity();
		article3.setId(1003);
		article3.setTitle("Sustainable Energy Solutions for the Future");
		article3.setJournal("Journal of Renewable Energy");
		article3.setAbstractText("This article provides a comprehensive review of sustainable energy technologies...");
		article3.setKeywords("Renewable Energy, Sustainability, Green Technology");
		article3.setListAuthors(Arrays.asList(301, 302));
		article3.setListEvaluators(Arrays.asList(401));
		this.listaDeArticulos.add(article1);
		this.listaDeArticulos.add(article2);
		this.listaDeArticulos.add(article3);
	}*/
}
