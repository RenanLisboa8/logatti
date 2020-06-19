package projetoControleCompraVenda.rabbit.producer;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import projetoControleCompraVenda.model.Compras;
import projetoControleCompraVenda.model.Fornecedor;

@Component
public class ComprasProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue queue;

    public void send(Compras compras){
        rabbitTemplate.convertAndSend(this.queue.getName(), compras);
    }
}
