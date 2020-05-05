package br.com.company;

import javax.swing.*;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String nome = "";
        String msgp = "";

        nome = JOptionPane.showInputDialog("Bem vindo, ao chat, qual é o seu nome?");

        try {
            while (msgp!="0"){
                msgp=JOptionPane.showInputDialog("Chat - " + nome + "Entre com a mensagem. (Entre com 0 para sair)");
                IChatAula objChat = (IChatAula) Naming.lookup("rmi://localhost:8282/chat");
                Message msg = new Message(nome, msgp);
                objChat.sendMessage(msg);
                System.out.println(returnMessage(objChat.retrieveMessage()));
            }
        }catch (MalformedURLException e){
            e.printStackTrace();
        }catch (RemoteException e){
            e.printStackTrace();
        }catch (NotBoundException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private static String returnMessage(List<Message> lst){
        String valor = "";
        for (Message message : lst){
            valor += message.getUser() + ": " + message.getMessage() + "\n";
        }
        return  valor;
    }
}
