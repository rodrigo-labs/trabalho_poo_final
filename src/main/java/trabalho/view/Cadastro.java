package trabalho.view;

import trabalho.model.entity.Produto;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Created by rodrigo on 12/05/17.
 */
public class Cadastro {

    public int menuCadastro() {
        StringBuilder menu = new StringBuilder("");
        Scanner scanner = new Scanner(System.in);
        int opcao;

        menu.append("\tXYZ COMERCIO DE PRODUTOS LTDA.\n");
        menu.append("\tSISTEMA DE CONTROLE DE ESTOQUE\n\n");
        menu.append("CADASTRO DE PRODUTOS\n\n");
        menu.append("1 - INCLUSÂO\n");
        menu.append("2 - ALTERAÇÃO\n");
        menu.append("3 - EXCLUSÂO\n");
        menu.append("4 - CONSULTA\n");
        menu.append("0 - RETORNAR\n\n");
        menu.append("OPÇÃO: ");

        try {
            System.out.print(menu.toString());
            opcao = Integer.parseInt(scanner.nextLine());

            return opcao;
        } catch (IllegalArgumentException ex) {
            return 100;
        }
    }

    public Produto inclusao() {
        Scanner scanner = new Scanner(System.in);
        Produto produto = new Produto();
        String confirma;

        try {
            System.out.println("\tXYZ COMERCIO DE PRODUTOS LTDA.");
            System.out.println("\tSISTEMA DE CONTROLE DE ESTOQUE\n");
            System.out.println("INCLUSÂO DE PRODUTOS\n");

            System.out.print("NOME: ");
            produto.setNome(scanner.nextLine());

            System.out.print("PREÇO: ");
            produto.setPreco(Double.parseDouble(scanner.nextLine()));

            System.out.print("UNIDADE: ");
            produto.setUnidade(scanner.nextLine());

            System.out.print("QUANTIDADE: ");
            produto.setQuantidade(Integer.parseInt(scanner.nextLine()));

            System.out.println("CONFIRMAR INCLUSÃO ( S/N ) ?");
            confirma = scanner.nextLine();

            //TODO nao ta funcionando
            if (!confirma.toUpperCase().equals("S")) {
                throw new ConfirmacaoException("Inclusão não efetuada.\n");
            }

            return produto;
        } catch (IllegalArgumentException ex) {
            System.out.println("Erro ao informar os dados do produto.\n");
        } catch (ConfirmacaoException ex) {
            System.out.println(ex.getMessage());
        }

        return null;
    }

    public Produto alteracao(Produto produto) {
        Scanner scanner = new Scanner(System.in);
        String confirma;

        try {
            System.out.println("\tXYZ COMERCIO DE PRODUTOS LTDA.");
            System.out.println("\tSISTEMA DE CONTROLE DE ESTOQUE\n");
            System.out.println("ALTERAÇÂO DE PRODUTOS\n");

            System.out.println("ID: " + produto.getId());
            System.out.println("NOME: " + produto.getNome());

            System.out.print("PREÇO: ");
            produto.setPreco(Double.parseDouble(scanner.nextLine()));

            System.out.print("UNIDADE: ");
            produto.setUnidade(scanner.nextLine());

            System.out.print("QUANTIDADE: ");
            produto.setQuantidade(Integer.parseInt(scanner.nextLine()));

            System.out.println("CONFIRMAR ALTERAÇÂO ( S/N ) ?");
            confirma = scanner.nextLine();

            if (!confirma.toUpperCase().equals("S")) {
                throw new ConfirmacaoException("Alteração não efetuada.\n");
            }
        } catch (IllegalArgumentException ex) {
            System.out.println("Erro ao informar os dados do produto.\n");
        } catch (ConfirmacaoException ex) {
            System.out.println(ex.getMessage());
        }

        return produto;
    }

    public Produto exclusao(Produto produto) {
        Scanner scanner = new Scanner(System.in);
        String confirma;

        System.out.println("\tXYZ COMERCIO DE PRODUTOS LTDA.");
        System.out.println("\tSISTEMA DE CONTROLE DE ESTOQUE\n");
        System.out.println("EXCLUSÂO DE PRODUTOS\n");
        System.out.println("ID: " + produto.getId());
        System.out.println("NOME: " + produto.getNome());
        System.out.println("PREÇO: " + produto.getPreco());
        System.out.println("UNIDADE: " + produto.getUnidade());
        System.out.println("QUANTIDADE: " + produto.getQuantidade());
        System.out.print("CONFIRMAR EXCLUSÂO ( S/N ) ?");

        try {
            confirma = scanner.nextLine();

            if (!confirma.toUpperCase().equals("S")) {
                throw new ConfirmacaoException("Exclusão não efetuada.\n");
            }
        } catch (IllegalArgumentException ex) {
            System.out.println("Erro ao informar os dados do produto.\n");
        } catch (ConfirmacaoException ex) {
            System.out.println(ex.getMessage());
        }

        return produto;
    }

    public void consultaResultado(Produto produto) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\tXYZ COMERCIO DE PRODUTOS LTDA.");
        System.out.println("\tSISTEMA DE CONTROLE DE ESTOQUE\n");
        System.out.println("CONSULTA DE PRODUTOS\n");
        System.out.println("ID: " + produto.getId());
        System.out.println("NOME: " + produto.getNome());
        System.out.println("PREÇO: " + produto.getPreco());
        System.out.println("UNIDADE: " + produto.getUnidade());
        System.out.println("QUANTIDADE: " + produto.getQuantidade());
    }

    public String consultaPorNome() throws SQLException {
        StringBuilder menu = new StringBuilder("");
        Scanner scanner = new Scanner(System.in);
        String nome;

        menu.append("\tXYZ COMERCIO DE PRODUTOS LTDA.\n");
        menu.append("\tSISTEMA DE CONTROLE DE ESTOQUE\n\n");
        menu.append("CONSULTA DE PRODUTOS\n\n");
        menu.append("DIGITE O NOME: ");

        System.out.println(menu);
        nome = scanner.nextLine();
        
        return nome;
    }
}
