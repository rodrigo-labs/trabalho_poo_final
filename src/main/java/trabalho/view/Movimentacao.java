package trabalho.view;

import trabalho.model.dao.ProdutoDAO;
import trabalho.model.entity.Produto;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * Created by rodrigo on 13/05/17.
 */
public class Movimentacao {

    public int menuMovimentacao() {
        StringBuilder menu = new StringBuilder("");
        Scanner scanner = new Scanner(System.in);
        int opcao;

        menu.append("\tXYZ COMERCIO DE PRODUTOS LTDA.\n");
        menu.append("\tSISTEMA DE CONTROLE DE ESTOQUE\n\n");
        menu.append("MOVIMENTAÇÂO DE PRODUTOS\n\n");
        menu.append("1 - ENTRADA\n");
        menu.append("2 - SAÍDA\n");
        menu.append("0 - RETORNAR\n\n");
        menu.append("OPÇÃO: ");

        try {
            System.out.print(menu.toString());
            opcao = Integer.parseInt(scanner.nextLine());

            return opcao;
        } catch (Exception e) {
            return 10;
        }
    }

    public Produto entrada(Produto produto) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        String confirma;
        int quantidadeAdicionada;

        try {
            System.out.println("\tXYZ COMERCIO DE PRODUTOS LTDA.");
            System.out.println("\tSISTEMA DE CONTROLE DE ESTOQUE\n");
            System.out.println("ENTRADA DE PRODUTOS\n");
            System.out.println("NOME: " + produto.getNome());
            System.out.println("QUANTIDADE ATUAL: " + produto.getQuantidade());
            System.out.print("QUANTIDADE ENTRADA: ");
            quantidadeAdicionada = Integer.parseInt(scanner.nextLine());
            produto.setQuantidade(produto.getQuantidade() + quantidadeAdicionada);
            System.out.println("QUANTIDADE FINAL: " + produto.getQuantidade());
            System.out.println("CONFIRMAR ALTERAÇÂO ( S/N ) ?");
            confirma = scanner.nextLine();

            if (!confirma.toUpperCase().equals("S")) {
                throw new ConfirmacaoException("Entrada não efetuada.\n");
            }
        } catch (IllegalArgumentException ex) {
            System.out.println("Erro ao informar os dados do produto.\n");
        } catch (ConfirmacaoException ex) {
            System.out.println(ex.getMessage());
        }

        return produto;
    }

    public Produto saida(Produto produto) {
        Scanner scanner = new Scanner(System.in);
        String confirma;
        int quantidadeAdicionada;

        try {
            System.out.println("\tXYZ COMERCIO DE PRODUTOS LTDA.");
            System.out.println("\tSISTEMA DE CONTROLE DE ESTOQUE\n");
            System.out.println("SAIDA DE PRODUTOS\n");
            System.out.println("NOME: " + produto.getNome());
            System.out.println("QUANTIDADE ATUAL: " + produto.getQuantidade());
            System.out.print("QUANTIDADE SAIDA: ");
            quantidadeAdicionada = Integer.parseInt(scanner.nextLine());
            produto.setQuantidade(produto.getQuantidade() - quantidadeAdicionada);
            System.out.println("QUANTIDADE FINAL: " + produto.getQuantidade());
            System.out.println("CONFIRMAR ALTERAÇÂO ( S/N ) ?");
            confirma = scanner.nextLine();

            if (!confirma.toUpperCase().equals("S")) {
                throw new ConfirmacaoException("Saida não efetuada.\n");
            }
        } catch (IllegalArgumentException ex) {
            System.out.println("Erro ao informar os dados do produto.\n");
        } catch (ConfirmacaoException ex) {
            System.out.println(ex.getMessage());
        }

        return produto;
    }

    public String consultaPorNome() throws SQLException {
        StringBuilder menu = new StringBuilder("");
        Scanner scanner = new Scanner(System.in);
        String nome;

        menu.append("\tXYZ COMERCIO DE PRODUTOS LTDA.\n ");
        menu.append("\tSISTEMA DE CONTROLE DE ESTOQUE\n\n ");
        menu.append("CONSULTA DE PRODUTOS\n\n");
        System.out.println(menu);
        System.out.println("DIGITE O NOME: ");
        nome = scanner.nextLine();

        return nome;
    }
}
