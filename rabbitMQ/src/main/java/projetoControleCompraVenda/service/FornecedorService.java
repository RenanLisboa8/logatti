package projetoControleCompraVenda.service;

import projetoControleCompraVenda.interfaces.IFornecedorRepository;
import projetoControleCompraVenda.model.Fornecedor;
import projetoControleCompraVenda.model.Fornecedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projetoControleCompraVenda.rabbit.producer.FornecedorProducer;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {

    @Autowired
    private IFornecedorRepository fornecedorRepository;

    @Autowired
    private FornecedorProducer fornecedorProducer;

    public void sendFornecedorRabbit(Fornecedor fornecedor){
        fornecedorProducer.send(fornecedor);
    }

    public Fornecedor save(Fornecedor fornecedor) {
        return fornecedorRepository.save(fornecedor);
    }

    public List<Fornecedor> findAll() {
        return fornecedorRepository.findAll();
    }

    public Optional<Fornecedor> findById(String id) {
        return fornecedorRepository.findById(id);
    }

    public void delete(String id) {
        fornecedorRepository.deleteById(id);
    }
}
