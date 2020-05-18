package br.com.logatti.comum;

import br.com.logatti.model.Produto;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface IProdutoDao extends Remote {
    void saidaEstoque(int codProduto, int estoque) throws RemoteException;

    void entradaEstoque(int codProduto, int estoque) throws RemoteException;

    void inserirProduto(Produto produto) throws RemoteException;

    void alterarProduto(Produto produto) throws RemoteException;

    void excluirProduto(Produto produto) throws RemoteException;

    ArrayList<Produto> listarProdutos() throws RemoteException;

    ArrayList<Produto> buscarProdutos(String s) throws RemoteException;
}
