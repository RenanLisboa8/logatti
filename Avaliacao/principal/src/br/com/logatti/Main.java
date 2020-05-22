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

            //DADO 1
            Cliente cliente = new Cliente();
//            cliente.setId(1);
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

            //DADO 2

            Cliente cliente1 = new Cliente();
            cliente1.setId(2);
            cliente1.setCpf("123456789010");
            cliente1.setNome("DAMIANI");

            clienteDao.inserirCliente(cliente1);

            Funcionario funcionario1 = new Funcionario();
            funcionario1.setId(2);
            funcionario1.setCpf("123456789012");
            funcionario1.setNome("Vendedor da loja 1");
            funcionario1.setSalario(1520);

            funcionarioDao.inserirFuncionario(funcionario1);

            Produto produto1 = new Produto();
            produto1.setDescricao("Produto doidera pra vender");
            produto1.setId(2);
            produto1.setQuantidade(10);
            produto1.setValor(20);

            produtoDao.inserirProduto(produto1);

            ArrayList<VendaItem> itens1 = new ArrayList<VendaItem>();

            VendaItem vendaItem1 = new VendaItem();
            vendaItem1.setId(2);
            vendaItem1.setProdutoId(2);
            vendaItem1.setQuantidade(10);
            vendaItem1.setVendaId(2);
            vendaItem1.setTotal(10);
            itens.add(vendaItem1);

            Venda venda1 = new Venda();
            venda1.setData(new Date());
            venda1.setId(2);
            venda1.setTotal(5);
            venda1.setClienteId(2);
            venda1.setFuncionarioId(2);
            vendaDao.inserirVenda(itens, venda);

            //DADO 3

            Cliente cliente2 = new Cliente();
            cliente2.setId(3);
            cliente2.setCpf("123456789010");
            cliente2.setNome("IGOR");

            clienteDao.inserirCliente(cliente2);

            Funcionario funcionario2 = new Funcionario();
            funcionario2.setId(3);
            funcionario2.setCpf("123456789012");
            funcionario2.setNome("Vendedor da loja 2");
            funcionario2.setSalario(1520);

            funcionarioDao.inserirFuncionario(funcionario2);

            Produto produto2 = new Produto();
            produto2.setDescricao("Produto doidera pra vender");
            produto2.setId(3);
            produto2.setQuantidade(10);
            produto2.setValor(20);

            produtoDao.inserirProduto(produto2);

            ArrayList<VendaItem> itens2 = new ArrayList<VendaItem>();

            VendaItem vendaItem2 = new VendaItem();
            vendaItem2.setId(3);
            vendaItem2.setProdutoId(3);
            vendaItem2.setQuantidade(10);
            vendaItem2.setVendaId(3);
            vendaItem2.setTotal(10);
            itens2.add(vendaItem2);

            Venda venda2 = new Venda();
            venda2.setData(new Date());
            venda2.setId(3);
            venda2.setTotal(5);
            venda2.setClienteId(3);
            venda2.setFuncionarioId(3);
            vendaDao.inserirVenda(itens, venda);

            //DADO 4

            Cliente cliente3 = new Cliente();
            cliente3.setId(4);
            cliente3.setCpf("123456789010");
            cliente3.setNome("IGOR");

            clienteDao.inserirCliente(cliente3);

            Funcionario funcionario3 = new Funcionario();
            funcionario3.setId(4);
            funcionario3.setCpf("123456789012");
            funcionario3.setNome("Vendedor da loja 3");
            funcionario3.setSalario(1520);

            funcionarioDao.inserirFuncionario(funcionario3);

            Produto produto3 = new Produto();
            produto3.setDescricao("Produto massa pra vender");
            produto3.setId(4);
            produto3.setQuantidade(10);
            produto3.setValor(20);

            produtoDao.inserirProduto(produto3);

            ArrayList<VendaItem> itens3 = new ArrayList<VendaItem>();

            VendaItem vendaItem3 = new VendaItem();
            vendaItem3.setId(4);
            vendaItem3.setProdutoId(4);
            vendaItem3.setQuantidade(10);
            vendaItem3.setVendaId(4);
            vendaItem3.setTotal(10);
            itens3.add(vendaItem3);

            Venda venda3 = new Venda();
            venda3.setData(new Date());
            venda3.setId(4);
            venda3.setTotal(5);
            venda3.setClienteId(4);
            venda3.setFuncionarioId(4);
            vendaDao.inserirVenda(itens, venda);

            //DADO 5

            Cliente cliente4 = new Cliente();
            cliente4.setId(5);
            cliente4.setCpf("123456789010");
            cliente4.setNome("MONARK");

            clienteDao.inserirCliente(cliente4);

            Funcionario funcionario4 = new Funcionario();
            funcionario4.setId(5);
            funcionario4.setCpf("123456789012");
            funcionario4.setNome("Vendedor da loja 4");
            funcionario4.setSalario(1520);

            funcionarioDao.inserirFuncionario(funcionario4);

            Produto produto4 = new Produto();
            produto4.setDescricao("Produto massa pra vender");
            produto4.setId(5);
            produto4.setQuantidade(10);
            produto4.setValor(20);

            produtoDao.inserirProduto(produto4);

            ArrayList<VendaItem> itens4 = new ArrayList<VendaItem>();

            VendaItem vendaItem4 = new VendaItem();
            vendaItem4.setId(5);
            vendaItem4.setProdutoId(5);
            vendaItem4.setQuantidade(10);
            vendaItem4.setVendaId(5);
            vendaItem4.setTotal(10);
            itens4.add(vendaItem4);

            Venda venda4 = new Venda();
            venda4.setData(new Date());
            venda4.setId(5);
            venda4.setTotal(5);
            venda4.setClienteId(5);
            venda4.setFuncionarioId(5);
            vendaDao.inserirVenda(itens, venda);

            //DADO 6

            Cliente cliente5 = new Cliente();
            cliente5.setId(6);
            cliente5.setCpf("123456789010");
            cliente5.setNome("MONARK");

            clienteDao.inserirCliente(cliente5);

            Funcionario funcionario5 = new Funcionario();
            funcionario5.setId(6);
            funcionario5.setCpf("123456789012");
            funcionario5.setNome("Vendedor da loja 5");
            funcionario5.setSalario(1520);

            funcionarioDao.inserirFuncionario(funcionario5);

            Produto produto5 = new Produto();
            produto5.setDescricao("Produto bom pra vender");
            produto5.setId(6);
            produto5.setQuantidade(10);
            produto5.setValor(20);

            produtoDao.inserirProduto(produto5);

            ArrayList<VendaItem> itens5 = new ArrayList<VendaItem>();

            VendaItem vendaItem5 = new VendaItem();
            vendaItem5.setId(6);
            vendaItem5.setProdutoId(6);
            vendaItem5.setQuantidade(10);
            vendaItem5.setVendaId(6);
            vendaItem5.setTotal(10);
            itens5.add(vendaItem5);

            Venda venda5 = new Venda();
            venda5.setData(new Date());
            venda5.setId(6);
            venda5.setTotal(50);
            venda5.setClienteId(6);
            venda5.setFuncionarioId(6);
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