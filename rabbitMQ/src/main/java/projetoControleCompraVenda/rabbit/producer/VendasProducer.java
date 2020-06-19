package projetoControleCompraVenda.rabbit.producer;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import projetoControleCompraVenda.model.Cliente;
import projetoControleCompraVenda.model.Vendas;

@Component
public class VendasProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue queue;

    public void send(Vendas vendas){
        rabbitTemplate.convertAndSend(this.queue.getName(), vendas);
    }
}
