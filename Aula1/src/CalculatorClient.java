import java.rmi.Naming;

import javax.swing.JOptionPane;

public class CalculatorClient {
	public static void main(String[] args) {
		try {
			Calculator c = (Calculator) Naming.lookup("//localhost:1020/CalculatorService");
			String opcao[] = {"+", "-", "*", "/"};
			int operacao = JOptionPane.showOptionDialog(null, "Escolha uma das operações",  "Tipo de operação", 0, JOptionPane.INFORMATION_MESSAGE, null, opcao, opcao[0]);
			int n1 = Integer.parseInt(JOptionPane.showInputDialog("Informe o primeiro valor"));
			int n2 = Integer.parseInt(JOptionPane.showInputDialog("Informe o segundo valor"));
			switch(operacao) {
			case 0:
				JOptionPane.showMessageDialog(null, c.add(n1, n2));
				break;
			case 1:
				JOptionPane.showMessageDialog(null, c.sub(n1, n2));
				break;
			case 2:
				JOptionPane.showMessageDialog(null, c.mul(n1, n2));
				break;
			case 3:
				JOptionPane.showMessageDialog(null, c.div(n1, n2)); 
				break;
			}			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
