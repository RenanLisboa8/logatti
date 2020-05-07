package br.com.logatti;

import br.com.logatti.dao.PedidoDao;
import br.com.logatti.dao.ProdutoDao;
import br.com.logatti.model.Pedido;
import br.com.logatti.model.Produto;

import javax.swing.*;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

    private PedidoDao pedidoDao;
    private ProdutoDao produtoDao;

    public void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String msgp = "";
        pedidoDao = new PedidoDao();
        produtoDao = new ProdutoDao();
        Date date = new Date();
        Produto produto = new Produto(1, "sapato", "Calcado");
        Pedido pedido = new Pedido(1, "compra de sapato", date, "finalizado", produto);
        ArrayList<Pedido> dados = new ArrayList();

        msgp = JOptionPane.showInputDialog("O que deseja saber?");
        if(msgp.contains("pedido")){
            if(JOptionPane.showConfirmDialog(null, "Deseja saber o número do pedido?", "Pedido",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){

                dados = pedidoDao.buscar(pedido);

                for (Pedido dado : dados){
                    JOptionPane.showConfirmDialog(null, dado.getDescricao(), "Pedido", JOptionPane.OK_OPTION);
                }

            }else if(JOptionPane.showConfirmDialog(null, "Deseja saber o status do pedido?", "Pedido",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                dados = pedidoDao.buscar(pedido);

                for (Pedido dado : dados){
                    JOptionPane.showConfirmDialog(null, dado.getStatus(), "Pedido", JOptionPane.OK_OPTION);
                }
            }
        }else if(msgp.contains("numero")){
            if(JOptionPane.showConfirmDialog(null, "Deseja saber o número da nota fiscal?", "Nota fiscal",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){

                dados = pedidoDao.buscar(pedido);

                for (Pedido dado : dados){
                    JOptionPane.showConfirmDialog(null, dado.getNumPedido(), "Pedido", JOptionPane.OK_OPTION);
                }
            }
        }

    }
}
