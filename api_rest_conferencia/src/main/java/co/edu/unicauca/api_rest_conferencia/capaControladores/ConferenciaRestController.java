package co.edu.unicauca.api_rest_conferencia.capaControladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.api_rest_conferencia.fachadaServices.DTO.ConferenciaDTO;
import co.edu.unicauca.api_rest_conferencia.fachadaServices.services.IConferenciaService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api")
public class ConferenciaRestController {
    @Autowired
    private IConferenciaService conferenciaService;

    // Este servicio REST permite crear una conferencia
    @PostMapping("/conferencias")
    public ConferenciaDTO crearConferencia(@RequestBody ConferenciaDTO conferencia) {
        ConferenciaDTO objConferencia = conferenciaService.save(conferencia);
        return objConferencia;
    }

    // Este servicio REST permite listar todas las conferencias
    @GetMapping("/conferencias")
    public List<ConferenciaDTO> listarConferencias() {
        return conferenciaService.findAll();
    }

    // Este servicio REST permite consultar una conferencia por su id
    @GetMapping("/conferencias/{id}")
    public ConferenciaDTO consultarConferenciaPorId(@PathVariable Integer id) {
        ConferenciaDTO objConferencia = conferenciaService.findById(id);
        if(objConferencia == null){
            return null;
        }
        return objConferencia;
    }

    // Este servicio REST permite actualizar una conferencia
    @PutMapping("/conferencias/{id}")
    public ConferenciaDTO actualizarConferencia(@PathVariable Integer id, @RequestBody ConferenciaDTO conferencia) {
        conferencia.setId(id);
        ConferenciaDTO objConferencia = conferenciaService.update(conferencia);
        return objConferencia;
    }

    // Este servicio REST permite eliminar una conferencia
    @DeleteMapping("/conferencias/{id}")
    public boolean eliminarConferencia(@PathVariable Integer id) {
        return conferenciaService.delete(id);
    }
    
    // Este servicio REST permite consultar la cantidad maxima de articulos que puede tener una conferencia
    @GetMapping("/conferencias/cantMaxArticulos/{id}")
    public int consultarArticulosMaximos(@PathVariable Integer id) {
        return conferenciaService.getCantMaxArticulos(id);
    }
    
    // Este servicio REST permite listar las conferencias de un articulo
    @GetMapping("/conferencias/articulos/{id}")
    public List<ConferenciaDTO> consultarArticulosDeConferencia(@PathVariable Integer id) {
        System.out.println("Consumiendo servicio de articulos de conferencia con id: " + id);
        return conferenciaService.obtenerConferenciasDeArticulo(id);
    }

    // Este servicio REST permite consultar una conferencia por su id y retorna si existe o no
    @GetMapping("/conferencias/existe/{id}")
    public boolean consultarConferencia(@PathVariable Integer id) {
        return conferenciaService.existConference(id);
    }

    // Este servicio REST permite consultar la cantidad de articulos de una conferencia
    @GetMapping("/conferencias/cantArticulos/{id}")
    public int consultarArticulosConferencia(@PathVariable Integer id) {
        return conferenciaService.getCantArticulos(id);
    }
}