package br.com.p2.rabbit.producer;

import br.com.p2.model.Categorias;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CategoriasProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Qualifier("queue2")
    @Autowired
    private Queue queue;

    public void send(Categorias categorias){
        rabbitTemplate.convertAndSend(this.queue.getName(), categorias);
    }
}
