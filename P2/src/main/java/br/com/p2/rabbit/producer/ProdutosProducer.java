package br.com.p2.rabbit.producer;

import br.com.p2.model.Produtos;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ProdutosProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Qualifier("queue1")
    @Autowired
    private Queue queue;

    public void send(Produtos produtos) {
        rabbitTemplate.convertAndSend(this.queue.getName(), produtos);
    }
}
