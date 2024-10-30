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
        //cargarArticulos();
        pos=this.listaArticulos.size()+1;
    }

    public List<ArticuloEntity> findAll() {
        System.out.println("Invocando a listarArticulos");
        return this.listaArticulos;
    }

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

    /*private void cargarArticulos() {
        listaArticulos.add(new ArticuloEntity(1, "Articulo 1", "Revista 1", "Autor 1", 1));
        listaArticulos.add(new ArticuloEntity(2, "Articulo 2", "Revista 2", "Autor 2", 1));
        listaArticulos.add(new ArticuloEntity(3, "Articulo 3", "Revista 3", "Autor 3", 1));
    }*/
}
