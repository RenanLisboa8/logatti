package br.com.logatti.comum;

import br.com.logatti.model.Funcionario;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface IFuncionarioDao extends Remote {
    void inserirFuncionario(Funcionario funcionario) throws RemoteException;

    void atualizarFuncionar(Funcionario funcionario) throws RemoteException;

    void excluirFuncionario(Funcionario funcionario) throws RemoteException;

    ArrayList<Funcionario> listarFuncionarios() throws RemoteException;

    ArrayList<Funcionario> buscarFuncionarios(String s) throws RemoteException;
}
