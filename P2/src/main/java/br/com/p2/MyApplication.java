package br.com.p2;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;

@SpringBootApplication
@ComponentScan("br.com.p2")
public class MyApplication {

    @Value("${queue.produtos.name}")
    private String produtoQueue;

    @Value("${queue.categorias.name}")
    private String categoriasQueue;

    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }

    //
//    @Bean
//    public Declarables queues() {
//        return new Declarables(
//                new Queue(produtoQueue, true, false, true),
//                new Queue(categoriasQueue, true, false, true));
//    }
    @Bean
    Queue queue1() {
        return new Queue(produtoQueue, true);
    }

    @Bean
    Queue queue2() {
        return new Queue(categoriasQueue, true);
    }
}