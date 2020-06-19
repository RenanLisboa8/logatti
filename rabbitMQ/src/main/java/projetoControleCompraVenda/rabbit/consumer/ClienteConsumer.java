package projetoControleCompraVenda.rabbit.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import projetoControleCompraVenda.model.Produtos;
import projetoControleCompraVenda.service.ProdutosService;

@Component
public class ClienteConsumer {

    @Autowired
    private ProdutosService produtosService;

    @RabbitListener(queues = {"${queue.clientes.name}"})
    public void receive (@Payload Produtos produto){
        System.out.println("Id: "+ produto. get_id() + "\nNome: " + produto.getNome());
        //Inserir dado no Mongo
        produtosService.save(produto);
    }
}
