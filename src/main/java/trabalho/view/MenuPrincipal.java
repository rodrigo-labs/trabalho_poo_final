package trabalho.view;

import java.util.Scanner;

/**
 * Created by rodrigo on 12/05/17.
 */
public class MenuPrincipal {

    public int menuPrincipal() {
        StringBuilder menu = new StringBuilder("");
        Scanner scanner = new Scanner(System.in);
        int opcao;

        menu.append("\tXYZ COMERCIO DE PRODUTOS LTDA.\n");
        menu.append("\tSISTEMA DE CONTROLE DE ESTOQUE\n\n");
        menu.append("MENU PRINCIPAL\n\n");
        menu.append("1 - CADASTRO DE PRODUTOS\n");
        menu.append("2 - MOVIMENTAÇÃO\n");
        menu.append("3 - REAJUSTE DE PREÇOS\n");
        menu.append("4 - RELATÓRIOS\n");
        menu.append("0 - FINALIZAR\n\n");
        menu.append("OPÇÃO: ");

        try {
            System.out.print(menu.toString());
            opcao = Integer.parseInt(scanner.nextLine());

            return opcao;
        } catch (IllegalArgumentException ex) {
            return 1000;
        }
    }
}
