package trabalho.view;

import trabalho.model.dao.ProdutoDAO;
import trabalho.model.entity.Produto;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * Created by rodrigo on 14/05/17.
 */
public class ReajusteDePreco {

    public int menuReajusteDePrecos() {
        StringBuilder menu = new StringBuilder("");
        Scanner scanner = new Scanner(System.in);
        int opcao;

        menu.append("\tXYZ COMERCIO DE PRODUTOS LTDA.\n");
        menu.append("\tSISTEMA DE CONTROLE DE ESTOQUE\n\n");
        menu.append("REAJUSTE DE PREÇOS\n\n");
        menu.append("1 - REAJUSTAR\n");
        menu.append("0 - RETORNAR\n\n");
        menu.append("OPÇÃO: ");

        try {
            System.out.print(menu.toString());
            opcao = Integer.parseInt(scanner.nextLine());

            return opcao;
        } catch (Exception e) {
            return 110;
        }
    }

    public Produto reajustarPreco(Produto produto) {
        Scanner scanner = new Scanner(System.in);
        String confirma;

        try {
        System.out.println("\tXYZ COMERCIO DE PRODUTOS LTDA.");
        System.out.println("\tSISTEMA DE CONTROLE DE ESTOQUE\n");
        System.out.println("REAJUSTAR PREÇOS\n");
        System.out.println("NOME: " + produto.getNome());
        System.out.println("PREÇO ATUAL: " + produto.getPreco());
        System.out.print("PREÇO ENTRADA: ");
        produto.setPreco(Double.parseDouble(scanner.nextLine()));
        System.out.println("PREÇO FINAL: " + produto.getPreco());
        System.out.println("CONFIRMAR ALTERAÇÃO ( S/N ) ?");
        confirma = scanner.nextLine();

            if (!confirma.toUpperCase().equals("S")) {
                throw new ConfirmacaoException("Reajuste não efetuada.\n");
            }
        } catch (IllegalArgumentException ex) {
            System.out.println("Erro ao informar o preço do produto.\n");
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
        menu.append("\tSISTEMA DE CONTROLE DE ESTOQUE\n\n");
        menu.append("CONSULTA DE PRODUTOS\n\n");
        System.out.println(menu);
        System.out.println("DIGITE O NOME: ");
        nome = scanner.nextLine();

        return nome;
    }
}
