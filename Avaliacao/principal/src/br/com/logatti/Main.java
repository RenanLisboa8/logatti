package br.com.logatti;

import br.com.logatti.comum.IClienteDao;
import br.com.logatti.comum.IFuncionarioDao;
import br.com.logatti.comum.IProdutoDao;
import br.com.logatti.comum.IVendaDao;
import br.com.logatti.model.*;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        try {
            IClienteDao clienteDao = (IClienteDao) Naming.lookup("rmi://localhost:8282/cliente");
            IFuncionarioDao funcionarioDao = (IFuncionarioDao) Naming.lookup("rmi://localhost:8282/funcionario");
            IProdutoDao produtoDao = (IProdutoDao) Naming.lookup("rmi://localhost:8282/produto");
            IVendaDao vendaDao = (IVendaDao) Naming.lookup("rmi://localhost:8282/venda");

            Cliente cliente = new Cliente();
            cliente.setId(1);
            cliente.setCpf("123456789011");
            cliente.setNome("Cliente de compras");

            clienteDao.inserirCliente(cliente);

            Funcionario funcionario = new Funcionario();
            funcionario.setId(1);
            funcionario.setCpf("123456789012");
            funcionario.setNome("Vendedor");
            funcionario.setSalario(1500);

            funcionarioDao.inserirFuncionario(funcionario);

            Produto produto = new Produto();
            produto.setDescricao("Produto para venda");
            produto.setId(1);
            produto.setQuantidade(10);
            produto.setValor(20);

            produtoDao.inserirProduto(produto);

            ArrayList<VendaItem> itens = new ArrayList<VendaItem>();

            VendaItem vendaItem = new VendaItem();
            vendaItem.setId(1);
            vendaItem.setProdutoId(1);
            vendaItem.setQuantidade(10);
            vendaItem.setVendaId(1);
            vendaItem.setTotal(10);
            itens.add(vendaItem);

            Venda venda = new Venda();
            venda.setData(new Date());
            venda.setId(1);
            venda.setTotal(10);
            venda.setClienteId(1);
            venda.setFuncionarioId(1);
            vendaDao.inserirVenda(itens, venda);

        }catch(MalformedURLException e) {
            e.printStackTrace();
        }catch(RemoteException e) {
            e.printStackTrace();
        }catch(NotBoundException e) {
            e.printStackTrace();
        }
    }
}