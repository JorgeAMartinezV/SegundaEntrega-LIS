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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api")
public class ConferenciaRestController {
    @Autowired
    private IConferenciaService conferenciaService;

    @PostMapping("/conferencias")
    public ConferenciaDTO crearConferencia(@RequestBody ConferenciaDTO conferencia) {
        ConferenciaDTO objConferencia = conferenciaService.save(conferencia);
        return objConferencia;
    }

    @GetMapping("/conferencias")
    public List<ConferenciaDTO> listarConferencias() {
        return conferenciaService.findAll();
    }

    @GetMapping("/conferencias/{id}")
    public ConferenciaDTO consultarConferenciaPorId(@PathVariable Integer id) {
        ConferenciaDTO objConferencia = conferenciaService.findById(id);
        if(objConferencia == null){
            return null;
        }
        return objConferencia;
    }

    @PutMapping("/conferencias/{id}")
    public ConferenciaDTO actualizarConferencia(@PathVariable Integer id, @RequestBody ConferenciaDTO conferencia) {
        conferencia.setId(id);
        ConferenciaDTO objConferencia = conferenciaService.update(conferencia);
        return objConferencia;
    }

    @DeleteMapping("/conferencias/{id}")
    public boolean eliminarConferencia(@PathVariable Integer id) {
        return conferenciaService.delete(id);
    }
    
    @GetMapping("/conferencias/cantMaxArticulos/{id}")
    public int consultarArticulosMaximos(@PathVariable Integer id) {
        return conferenciaService.getCantMaxArticulos(id);
    }
    
    @GetMapping("/conferencias/articulos/{id}")
    public List<ConferenciaDTO> consultarArticulosDeConferencia(@PathVariable Integer id) {
        System.out.println("Consumiendo servicio de articulos de conferencia con id: " + id);
        return conferenciaService.obtenerConferenciasDeArticulo(id);
    }
    
}