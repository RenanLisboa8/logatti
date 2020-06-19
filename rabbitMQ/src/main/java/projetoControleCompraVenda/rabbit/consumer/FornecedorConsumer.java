package projetoControleCompraVenda.rabbit.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import projetoControleCompraVenda.model.Fornecedor;
import projetoControleCompraVenda.service.FornecedorService;

@Component
public class FornecedorConsumer {

    @Autowired
    private FornecedorService fornecedorService;

    @RabbitListener(queues = {"${queue.fornecedor.name}"})
    public void receive (@Payload Fornecedor fornecedor){
        System.out.println("Id: "+ fornecedor.get_id() + "\nNome: " + fornecedor.getNome());
        //Inserir dado no Mongo
        fornecedorService.save(fornecedor);
    }
}
