package comum;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IServicoRemoto extends Remote {
	void Inserir(Pessoa pessoa) throws RemoteException;
	List<Pessoa> ListarPessoa() throws RemoteException;
}
