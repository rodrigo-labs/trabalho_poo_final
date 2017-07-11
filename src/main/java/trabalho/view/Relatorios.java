package trabalho.view;

import trabalho.model.dao.ProdutoDAO;
import trabalho.model.entity.Produto;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by rodrigo on 14/05/17.
 */
public class Relatorios {
    Produto produto;
    ProdutoDAO produtoDAO = new ProdutoDAO();
    public int menuRelatorios() {
        StringBuilder menu = new StringBuilder("");
        Scanner scanner = new Scanner(System.in);
        int opcao;

        menu.append("\tXYZ COMERCIO DE PRODUTOS LTDA.\n");
        menu.append("\tSISTEMA DE CONTROLE DE ESTOQUE\n\n");
        menu.append("RELATÒRIOS\n\n");
        menu.append("1 - LISTA DE PREÇOS\n");
        menu.append("2 - BALANÇO FISÌCO/FINANCEIRO\n");
        menu.append("0 - RETORNAR\n\n");
        menu.append("OPÇÃO: ");

        try {
            System.out.print(menu.toString());
            opcao = Integer.parseInt(scanner.nextLine());

            return opcao;
        } catch (Exception e) {
            return 101;
        }
    }

    //TODO criar os metodos para exibir os 2 relatorios.

    public double Balanco() throws SQLException {
        double ValorTotal = 0;
        List<Produto> produtos = produtoDAO.listar();

        for(Produto p: produtos){
            ValorTotal = ValorTotal + (p.getPreco() * p.getQuantidade());
        }
        return ValorTotal;
    }

    public BufferedWriter listaDePrecos() throws SQLException {
        List<Produto> produtos = produtoDAO.listar();
        BufferedWriter write = null;
        File rel = new File("/RelatorioPreco.txt");

        try {
            write = new BufferedWriter(new FileWriter(rel));
            write.write("+-----------------------------------------------------------------+");
            write.newLine();
            write.write("|-----------------Relatório das listas de preços.-----------------|");
            write.newLine();
            write.write("+-----------------------------------------------------------------+");
            write.newLine();
            write.newLine();
            for(Produto produto: produtos){

                write.write("Nome: " + produto.getNome());
                write.newLine();
                write.write("Preco: " + produto.getPreco());
                write.newLine();
                write.write("Quantidade: " + produto.getQuantidade());
                write.newLine();
                write.newLine();

            }
            write.write("+-----------------------------------------------------------------+");
            write.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return write;
    }
}
