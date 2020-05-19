package src.br.com.logatti.comum;

import src.br.com.logatti.model.Cliente;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface IClienteDao extends Remote {
    void inserirCliente(Cliente cliente) throws RemoteException;

    void atualizarCliente(Cliente cliente) throws RemoteException;

    void excluirCliente(Cliente cliente) throws RemoteException;

    ArrayList<Cliente> listarClientes() throws RemoteException;

    ArrayList<Cliente> buscarClientes(String s) throws RemoteException;
}
