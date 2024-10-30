package co.edu.unicauca.api_rest_articulo.capaAccesoADatos.repositories;

import java.util.ArrayList;
import java.util.List;
import co.edu.unicauca.api_rest_articulo.capaAccesoADatos.models.ArticuloEntity;

import org.springframework.stereotype.Repository;
 
@Repository
public class ArticuloRepository {
    private ArrayList<ArticuloEntity> listaArticulos;
    private int pos;

    public ArticuloRepository() {
        this.listaArticulos = new ArrayList<ArticuloEntity>();
        cargarArticulos();
        pos=this.listaArticulos.size()+1;
    }

    /**
     * Metodo para listar todos los articulos 
     */
    public List<ArticuloEntity> findAll() {
        System.out.println("Invocando a listarArticulos");
        return this.listaArticulos;
    }

    /**
     * Metodo para buscar un articulo por su id
     * @param id Identificador del articulo    
    */
    public ArticuloEntity findById(Integer id) {
        System.out.println("Invocando a consultar un articulo");
        ArticuloEntity objArticulo = null;
        for (ArticuloEntity articulo : listaArticulos) {
            if (articulo.getId() == id) {
                objArticulo = articulo;
                break;
            }
        }
        return objArticulo;
    }

    /**
     * Metodo para registrar un articulo
     * @param articulo Objeto de tipo ArticuloEntity
     */
    public ArticuloEntity save(ArticuloEntity articulo) {
        System.out.println("Invocando a registrar articulo");
        ArticuloEntity objArticulo = null;
        articulo.setId(pos);
        if (this.listaArticulos.add(articulo)) {
            objArticulo = articulo;
            pos++;
        }
        return objArticulo;
    }

    /**
     * Metodo para actualizar un articulo
     * @param id Identificador del articulo a actualizar
     * @param articulo Objeto de tipo ArticuloEntity
     */
    public ArticuloEntity update(Integer id, ArticuloEntity articulo) {
        System.out.println("Invocando a actualizar articulo");
        ArticuloEntity objArticulo = null;
        for (ArticuloEntity articuloTemp : listaArticulos) {
            if (articuloTemp.getId() == id) {
                articuloTemp.setTitle(articulo.getTitle());
                articuloTemp.setJournal(articulo.getJournal());
                articuloTemp.setAbstractText(articulo.getAbstractText());
                articuloTemp.setKeywords(articulo.getKeywords());
                articuloTemp.setCantAuthors(articulo.getCantAuthors());
                objArticulo = articuloTemp;
                break;
            }
        }
        return objArticulo;
    }

    /**
     * Metodo para eliminar un articulo
     * @param id Identificador del articulo a eliminar
     */
    public boolean delete(Integer id) {
        System.out.println("Invocando a eliminar articulo");
        boolean result = false;
        ArticuloEntity objArticulo = null;
        objArticulo = findById(id);
        if (objArticulo != null) {
            result = listaArticulos.remove(objArticulo);
        }
        return result;
    }

    /**
     * Metodo para verificar si un articulo existe
     * @param id Identificador del articulo
     */
    public boolean articleExist(Integer id) {
        boolean result = false;
        for (ArticuloEntity articulo : listaArticulos) {
            if (articulo.getId() == id) {
                result = true;
                break;
            }
        }
        return result;
    }

    private void cargarArticulos() {
        listaArticulos.add(new ArticuloEntity(1, "Articulo 1", "Revista 1", "Articulo para prueba numero 1", "Prueba, Articulo", 15));
        listaArticulos.add(new ArticuloEntity(2, "Articulo 2", "Revista 2", "Articulo para prueba numero 2", "Prueba2, Articulo2", 20));
        listaArticulos.add(new ArticuloEntity(3, "Articulo 3", "Revista 3", "Articulo para prueba numero 3", "Prueba3, Articulo3", 5));
    }
}
