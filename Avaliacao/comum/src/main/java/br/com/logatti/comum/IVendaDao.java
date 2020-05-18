package br.com.logatti.comum;

import br.com.logatti.model.Venda;
import br.com.logatti.model.VendaItem;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;

public interface IVendaDao extends Remote {
    void inserirItensVenda(Connection con, ArrayList<VendaItem> servicosComprados, int codVenda) throws RemoteException;

    void inserirVenda(ArrayList<VendaItem> vendaItem, Venda venda) throws RemoteException;

    ArrayList<Venda> listarVendas(Date dataInicial, Date dataFinal) throws RemoteException;

    ArrayList<Venda> listarVendas() throws RemoteException;
}
