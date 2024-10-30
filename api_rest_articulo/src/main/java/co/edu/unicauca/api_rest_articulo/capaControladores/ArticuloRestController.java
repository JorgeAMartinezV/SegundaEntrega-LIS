package co.edu.unicauca.api_rest_articulo.capaControladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.api_rest_articulo.fachadaServices.DTO.ArticulosYConferenciasDTO.ArticulosConConferenciasDTO;
import co.edu.unicauca.api_rest_articulo.fachadaServices.DTO.ArticulosYConferenciasDTO.ConferenciaDTO;
import co.edu.unicauca.api_rest_articulo.fachadaServices.DTO.CRUDArticulosDTO.ArticuloDTO;
import co.edu.unicauca.api_rest_articulo.fachadaServices.services.IArticuloService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api")
public class ArticuloRestController {
    @Autowired
    private IArticuloService articuloService;

    // Este servicio REST permite crear un articulo
    @PostMapping("/articulos")
    public ArticuloDTO crearArticulo(@RequestBody ArticuloDTO articulo) {
        ArticuloDTO objArticulo = articuloService.save(articulo);
        return objArticulo;
    }

    // Este servicio REST permite listar todos los articulos
    @GetMapping("/articulos")
    public List<ArticuloDTO> listarArticulos() {
        return articuloService.findAll();
    }

    // Este servicio REST permite consultar un articulo por su id
    @GetMapping("/articulos/{id}")
    public ArticuloDTO consultarArticulo(@PathVariable Integer id) {
        ArticuloDTO objArticulo = articuloService.findById(id);
        return objArticulo;
    }

    // Este servicio REST permite actualizar un articulo
    @PutMapping("/articulos/{id}")
    public ArticuloDTO actualizarArticulo(@PathVariable Integer id, @RequestBody ArticuloDTO articulo) {
        if(articuloService.findById(id) == null){
            return null;
        }
        ArticuloDTO objArticulo = articuloService.update(id, articulo);
        return objArticulo;
    }

    // Este servicio REST permite eliminar un articulo
    @DeleteMapping("/articulos/{id}")
    public boolean eliminarArticulo(@PathVariable Integer id) {
        return articuloService.delete(id);
    }

    // Este servicio REST permite consultar un articulo por su id y retorna un booleano
    @GetMapping("/articulos2")
    public boolean consultarArticulo2(@RequestParam Integer id) {
        ArticuloDTO objArticulo = articuloService.findById(id);
        if(objArticulo == null){
            return false;
        }
        return true;
    }

    // Este servicio REST permite listar las conferencias de un articulo
    @GetMapping("/articulos/conferencias/{idArticulo}")
    public List<ConferenciaDTO> listarConferenciasDeArticulo(@PathVariable Integer idArticulo) {
        return articuloService.ListarConferenciasDeArticulo(idArticulo);
    }

    // Este servicio REST permite listar los datos de un articulo con sus conferencias
    @GetMapping("/articulos/articulosyconferencias/{idArticulo}")
    public ArticulosConConferenciasDTO listarDatosArticulosConSusConferencias(@PathVariable Integer idArticulo) {
        return articuloService.listarDatosArticulosConSusConferencias(idArticulo);
    }

    // Este servicio REST permite verificar si un articulo existe
    @GetMapping("/articulos/existe/{id}")
    public boolean existeArticulo(@PathVariable Integer id) {
        return articuloService.findById(id) != null;
    }
}
