package br.com.p2.rabbit.consumer;

import br.com.p2.model.Categorias;
import br.com.p2.service.CategoriasService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class CategoriasConsumer {
    @Autowired
    private CategoriasService categoriasService;

    @RabbitListener(queues = {"${queue.categorias.name}"})
    public void receive (@Payload Categorias categorias){
        System.out.println("Id: "+ categorias. get_id() + "\nNome: " + categorias.getNome());
        categoriasService.save(categorias);
    }
}
