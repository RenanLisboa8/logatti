package projetoControleCompraVenda.rabbit.producer;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import projetoControleCompraVenda.model.Fornecedor;
import projetoControleCompraVenda.model.Vendas;

@Component
public class FornecedorProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue queue;

    public void send(Fornecedor fornecedor){
        rabbitTemplate.convertAndSend(this.queue.getName(), fornecedor);
    }
}
