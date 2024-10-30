package co.edu.unicauca.api_rest_articulo.fachadaServices.services;

import co.edu.unicauca.api_rest_articulo.fachadaServices.DTO.ArticulosYConferenciasDTO.ConferenciaDTO;
import reactor.core.publisher.Mono;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ConferenciasService {

    @Autowired
    private WebClient.Builder webClientBuilder;
    
    public List<ConferenciaDTO> obtenerConferenciasDeArticulo(Integer idArticulo) {
        String url = "http://localhost:8080/api/conferencias/articulos/" + idArticulo;

        Mono<ConferenciaDTO[]> response = webClientBuilder.build()
                .get()
                .uri(url)
                .retrieve()
                .bodyToMono(ConferenciaDTO[].class);

        ConferenciaDTO[] conferenciasArray = response.block();

        System.out.println("Conferencias obtenidas: ");
        for (ConferenciaDTO conferencia : conferenciasArray) {
            System.out.println(conferencia.toString());
        }
        return conferenciasArray != null ? List.of(conferenciasArray) : List.of();
    }
}
