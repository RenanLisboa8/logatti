package cliente;

import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import comum.IServicoRemoto;
import comum.Pessoa;
import comum.Professor;
import java.net.MalformedURLException;

public class AppPrincipal {

	public static void main(String[] args) {
		try {
			IServicoRemoto objPessoa = (IServicoRemoto) Naming.lookup("rmi://localhost:8282/pessoa");
			
			Professor p1 = new Professor();
			p1.setCidade("Araraquara");
			p1.setNome("Pedro");
			p1.setTelefone("(12) 1234-5678");
			
			Professor p2 = new Professor();
			p2.setCidade("Araraquara");
			p2.setNome("Bruno");
			p2.setTelefone("(11) 4321-7656");
			
			objPessoa.Inserir(p1);
			objPessoa.Inserir(p2);
			
			for (Pessoa professor : objPessoa.ListarPessoa()) {
				System.out.println("ID:" + professor.getId());
				System.out.println("Cidade: " + professor.getCidade());
				System.out.println("Nome:" + professor.getNome());
				System.out.println("Telefone: " + professor.getTelefone());
			}
		}catch(MalformedURLException e) {
			e.printStackTrace();
		}catch(RemoteException e) {
			e.printStackTrace();
		}catch(NotBoundException e) {
			e.printStackTrace();
		}

	}

}
