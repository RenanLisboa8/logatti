package projetoControleCompraVenda;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;


public class MyApplication {
    @Value("${queue.produtos.name}")
    private String produtosQueue;
    @Value("${queue.compras.name}")
    private String comprasQueue;
    @Value("${queue.clientes.name}")
    private String clientesQueue;
    @Value("${queue.fornecedor.name}")
    private String fornecedorQueue;
    @Value("${queue.vendas.name}")
    private String vendasQueue;

    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }

    @Bean
    public Queue queueProdutos(){
        return new Queue(produtosQueue, true);
    }
    @Bean
    public Queue queueCompras(){
        return new Queue(comprasQueue, true);
    }
    @Bean
    public Queue queueClientes(){
        return new Queue(clientesQueue, true);
    }
    @Bean
    public Queue queueFornecedor(){
        return new Queue(fornecedorQueue, true);
    }
    @Bean
    public Queue queueVendas(){
        return new Queue(vendasQueue, true);
    }
}
