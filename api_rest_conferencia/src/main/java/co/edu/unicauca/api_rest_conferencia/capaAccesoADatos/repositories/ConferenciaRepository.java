package co.edu.unicauca.api_rest_conferencia.capaAccesoADatos.repositories;

import org.springframework.stereotype.Repository;

import co.edu.unicauca.api_rest_conferencia.capaAccesoADatos.models.ArticuloEntity;
import co.edu.unicauca.api_rest_conferencia.capaAccesoADatos.models.ConferenciaEntity;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ConferenciaRepository {
    private ArrayList<ConferenciaEntity> listaConferencias;
    private int pos;

    public ConferenciaRepository() {
        this.listaConferencias = new ArrayList<ConferenciaEntity>();
        //cargarConferencias();
        pos=this.listaConferencias.size()+1;
    }

    public ArrayList<ConferenciaEntity> findAll() {
        System.out.println("Invocando a listarConferencias");
        return this.listaConferencias;
    }

    public ConferenciaEntity findById(Integer id) {
        System.out.println("Invocando a consultar una conferencia");
        ConferenciaEntity objConferencia = null;
        for (ConferenciaEntity conferencia : listaConferencias) {
            if (conferencia.getId() == id) {
                System.out.println("Conferencia encontrada: " + conferencia.getName());
                objConferencia = conferencia;
                break;
            }
        }
        return objConferencia;
    }

    public ConferenciaEntity save(ConferenciaEntity conferencia) {
        System.out.println("Invocando a registrar conferencia");
        ConferenciaEntity objConferencia = null;
        conferencia.setId(pos);
        if (this.listaConferencias.add(conferencia)) {
            objConferencia = conferencia;
            pos++;
        }
        return objConferencia;
    }

    public int getCantMaxArticulos(Integer id) {
        System.out.println("Invocando a consultar la cantidad maxima de articulos de una conferencia");
        int cantMaxArticulos = 0;
        for (ConferenciaEntity conferencia : listaConferencias) {
            if (conferencia.getId() == id) {
                cantMaxArticulos = conferencia.getCantMaxArticles();
                break;
            }
        }
        return cantMaxArticulos;
    }

    public ConferenciaEntity update(ConferenciaEntity conferencia) {
        System.out.println("Invocando a actualizar conferencia");
        ConferenciaEntity objConferencia = null;
        for (ConferenciaEntity conferenciaAux : listaConferencias) {
            if (conferenciaAux.getId() == conferencia.getId()) {
                conferenciaAux.setName(conferencia.getName());
                conferenciaAux.setStartDate(conferencia.getStartDate());
                conferenciaAux.setEndDate(conferencia.getEndDate());
                conferenciaAux.setRegistrationCost(conferencia.getRegistrationCost());
                conferenciaAux.setLocation(conferencia.getLocation());
                conferenciaAux.setCantMaxArticles(conferencia.getCantMaxArticles());
                conferenciaAux.setArticles(conferencia.getArticles());
                objConferencia = conferenciaAux;
                break;
            }
        }
        return objConferencia;
    }

    public List<ConferenciaEntity> obtenerConferenciasDeArticulo(Integer idArticulo) {
        System.out.println("Invocando a obtener conferencias de un articulo");
        ArrayList<ConferenciaEntity> listaConferenciasArticulo = new ArrayList<>();
        for(int i = 0; i < this.listaConferencias.size(); i++){
            List<ArticuloEntity> listaArticulos = listaConferencias.get(i).getArticles();
            for(int j = 0; j < listaArticulos.size(); j++){
                if(listaArticulos.get(j).getId() == idArticulo){
                    listaConferenciasArticulo.add(this.listaConferencias.get(i));
                    System.out.println("Conferencia encontrada: " + this.listaConferencias.get(i).getName());
                    break;
                }
            }
        }
        System.out.println("Lista retornada: " + listaConferenciasArticulo.size());
        return listaConferenciasArticulo;
    }

    public boolean delete(Integer id) {
        System.out.println("Invocando a eliminar conferencia");
        ConferenciaEntity objConferencia = null;
        for (ConferenciaEntity conferencia : listaConferencias) {
            if (conferencia.getId() == id) {
                objConferencia = conferencia;
                break;
            }
        }
        if (objConferencia != null) {
            this.listaConferencias.remove(objConferencia);
            return true;
        }
        return false;
    }

    /*private void cargarConferencias() {
        System.out.println("Cargando conferencias");
        ArrayList<ArticuloEntity> listaDeArticulosConferencia1 = new ArrayList<>();
        ArticuloEntity articulo1 = new ArticuloEntity(1);
        ArticuloEntity articulo2 = new ArticuloEntity(2);
        listaDeArticulosConferencia1.add(articulo1);
        listaDeArticulosConferencia1.add(articulo2);
        this.listaConferencias.add(new ConferenciaEntity(1, "Conferencia 1", 10, listaDeArticulosConferencia1));
        ArrayList<ArticuloEntity> listaDeArticulosConferencia2 = new ArrayList<>();
        ArticuloEntity articulo3 = new ArticuloEntity(1);
        ArticuloEntity articulo4 = new ArticuloEntity(3);
        listaDeArticulosConferencia2.add(articulo3);
        listaDeArticulosConferencia2.add(articulo4);
        this.listaConferencias.add(new ConferenciaEntity(2, "Conferencia 2", 20, listaDeArticulosConferencia2));
        ArrayList<ArticuloEntity> listaDeArticulosConferencia3 = new ArrayList<>();
        ArticuloEntity articulo5 = new ArticuloEntity(4);
        ArticuloEntity articulo6 = new ArticuloEntity(5);
        listaDeArticulosConferencia3.add(articulo5);
        listaDeArticulosConferencia3.add(articulo6);
        this.listaConferencias.add(new ConferenciaEntity(3, "Conferencia 3", 30, listaDeArticulosConferencia3));
        ArrayList<ArticuloEntity> listaDeArticulosConferencia4 = new ArrayList<>();
        ArticuloEntity articulo7 = new ArticuloEntity(5);
        ArticuloEntity articulo8 = new ArticuloEntity(2);
        listaDeArticulosConferencia4.add(articulo7);
        listaDeArticulosConferencia4.add(articulo8);
        this.listaConferencias.add(new ConferenciaEntity(4, "Conferencia 4", 40, listaDeArticulosConferencia4));
    }
    */
}
