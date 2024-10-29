package co.edu.unicauca.correo.consumidor;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import co.edu.unicauca.correo.DTOs.ArticuloDTO;

@Service
public class MessageConsumer {
    @RabbitListener(queues = "temaCorreo")
    public void receiveMessage(ArticuloDTO objArticuloCreado) {
        System.out.println("Datos del articulo recibidos");
        System.out.println("Enviando correo electrónico");
        System.out.println("Id: "+objArticuloCreado.getId());
        System.out.println("Titulo: "+objArticuloCreado.getTitle());
        System.out.println("Revista: "+objArticuloCreado.getJournal());
        System.out.println("Resumen: "+objArticuloCreado.getAbstractText());
        System.out.println("Palabras clave: "+objArticuloCreado.getKeywords());
        System.out.println("Cantidad de autores: "+objArticuloCreado.getCantAuthors());     
    }
}
