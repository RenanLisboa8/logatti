package projetoControleCompraVenda.rabbit.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import projetoControleCompraVenda.model.Compras;
import projetoControleCompraVenda.service.ComprasService;

@Component
public class ComprasConsumer {

    @Autowired
    private ComprasService comprasService;

    @RabbitListener(queues = {"${queue.compras.name}"})
    public void receive (@Payload Compras compras){
        System.out.println("Id: "+ compras.get_id() + "\nNome: " + compras.getDescricao());
        //Inserir dado no Mongo
        comprasService.save(compras);
    }
}
