package br.com.logatti.comum;

import br.com.logatti.model.Funcionario;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface IFuncionarioDao extends Remote {
    void inserirFuncionario(Funcionario funcionario) throws RemoteException;

    void alterarFuncionario(Funcionario funcionario) throws RemoteException;

    void excluirFuncionario(Funcionario funcionario) throws RemoteException;

    ArrayList<Funcionario> listarFuncionario() throws RemoteException;

    ArrayList<Funcionario> buscarFuncionario(String s) throws RemoteException;
}
