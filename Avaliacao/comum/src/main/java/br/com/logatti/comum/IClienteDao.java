package br.com.logatti.comum;

import br.com.logatti.model.Cliente;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface IClienteDao extends Remote {
    void inserirCliente(Cliente cliente) throws RemoteException;

    void alterarCliente(Cliente cliente) throws RemoteException;

    void excluirCliente(Cliente cliente) throws RemoteException;

    ArrayList<Cliente> listarCliente() throws RemoteException;

    ArrayList<Cliente> buscarCliente(String s) throws RemoteException;
}
