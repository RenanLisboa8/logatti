package br.com.logatti.comum;

import br.com.logatti.model.Venda;
import br.com.logatti.model.VendaItem;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;

public interface IVendaDao extends Remote {

    void inserirVenda(ArrayList<VendaItem> vendaItem, Venda venda) throws RemoteException;

    ArrayList<Venda> lisarVendas(Date dataInicial, Date dataFinal) throws RemoteException;

    ArrayList<VendaItem> lisarVendaItens() throws RemoteException;
}
