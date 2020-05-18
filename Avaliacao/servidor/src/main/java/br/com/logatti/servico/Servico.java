package br.com.logatti.servico;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Servico {
    /*public Servico() throws RemoteException {
        try {
            LocateRegistry.createRegistry(8282);
            System.out.println("INICIO");
            Naming.rebind("rmi://localhost:8282/pessoa", new ServicoRemotoImpl());
            System.out.println("FIM");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void Main(String[] args) throws RemoteException {
        new Servico();
    }*/
}
