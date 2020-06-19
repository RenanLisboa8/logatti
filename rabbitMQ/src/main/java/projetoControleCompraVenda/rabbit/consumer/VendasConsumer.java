package projetoControleCompraVenda.rabbit.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import projetoControleCompraVenda.model.Vendas;
import projetoControleCompraVenda.service.VendasService;

@Component
public class VendasConsumer {

    @Autowired
    private VendasService vendasService;

    @RabbitListener(queues = {"${queue.vendas.name}"})
    public void receive (@Payload Vendas vendas){
        System.out.println("Id: "+ vendas.get_id() + "\nNome: " + vendas.getDescricao());
        //Inserir dado no Mongo
        vendasService.save(vendas);
    }
}
