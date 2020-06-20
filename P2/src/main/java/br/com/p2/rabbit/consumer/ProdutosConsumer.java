package br.com.p2.rabbit.consumer;

import br.com.p2.model.Produtos;
import br.com.p2.service.ProdutosService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class ProdutosConsumer {

    @Autowired
    private ProdutosService produtosService;

    @RabbitListener(queues = {"${queue.produtos.name}"})
    public void receive(@Payload Produtos produto) {
        System.out.println("Id: " + produto.get_id() + "\nNome: " + produto.getNome());
        produtosService.save(produto);
    }
}
