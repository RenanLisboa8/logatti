package projetoControleCompraVenda.service;

import projetoControleCompraVenda.interfaces.IProdutosRepository;
import projetoControleCompraVenda.model.Produtos;
import projetoControleCompraVenda.model.Produtos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetoControleCompraVenda.rabbit.producer.ProdutosProducer;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutosService {

    @Autowired
    private IProdutosRepository produtoRepository;

    @Autowired
    private ProdutosProducer produtosProducer;

    public void sendProdutoRabbit(Produtos fornecedor){
        produtosProducer.send(fornecedor);
    }

    public Produtos save(Produtos produto){
        return produtoRepository.save(produto);
    }

    public List<Produtos> findAll(){
        return produtoRepository.findAll();
    }

    public Optional<Produtos> findById(String id){
        return produtoRepository.findById(id);
    }

    public void delete(String id){
        produtoRepository.deleteById(id);
    }
}
