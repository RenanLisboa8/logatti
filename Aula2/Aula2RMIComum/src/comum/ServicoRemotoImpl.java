package comum;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class ServicoRemotoImpl extends UnicastRemoteObject implements IServicoRemoto {

	private static List<Pessoa> lstPessoa = new ArrayList<Pessoa>();
	private static final long serialVersionUID = 7334161650385718588L;

	public ServicoRemotoImpl() throws RemoteException{
		// 
	}

	@Override
	public void Inserir(Pessoa pessoa) throws RemoteException {
		lstPessoa.add(pessoa);
	}
	@Override
	public List<Pessoa> ListarPessoa() throws RemoteException {
		return lstPessoa;
	}

}
