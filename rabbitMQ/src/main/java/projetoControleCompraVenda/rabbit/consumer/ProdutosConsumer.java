package projetoControleCompraVenda.rabbit.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import projetoControleCompraVenda.model.Produtos;
import projetoControleCompraVenda.service.ProdutosService;

@Component
public class ProdutosConsumer {

    @Autowired
    private ProdutosService produtosService;

    @RabbitListener(queues = {"${queue.produtos.name}"})
    public void receive (@Payload Produtos produtos){
        System.out.println("Id: "+ produtos.get_id() + "\nNome: " + produtos.getNome());
        //Inserir dado no Mongo
        produtosService.save(produtos);
    }
}
