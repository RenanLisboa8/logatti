package src.br.com.logatti;

import src.br.com.logatti.dao.ClienteDao;
import src.br.com.logatti.dao.FuncionarioDao;
import src.br.com.logatti.dao.ProdutoDao;
import src.br.com.logatti.dao.VendaDao;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Servico {
    public Servico() throws RemoteException {
        try {
            LocateRegistry.createRegistry(8282);
            System.out.println("INICIO");
            Naming.rebind("rmi://localhost:8282/cliente", new ClienteDao());
            Naming.rebind("rmi://localhost:8282/funcionario", new FuncionarioDao());
            Naming.rebind("rmi://localhost:8282/produto", new ProdutoDao());
            Naming.rebind("rmi://localhost:8282/venda", new VendaDao());
            System.out.println("FIM");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws RemoteException {
        new Servico();
    }
}

