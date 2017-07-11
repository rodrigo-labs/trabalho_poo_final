package trabalho.controller;

import trabalho.model.dao.ProdutoDAO;
import trabalho.model.entity.Produto;
import trabalho.view.*;

import java.io.*;
import java.sql.SQLException;

/**
 * Created by rodrigo on 17/05/17.
 */
public class Controller {
    boolean Novamente = false;
    FazerNovamente fazernovamente = new FazerNovamente();
    public void menuPrincipal() throws SQLException {
        MenuPrincipal menu = new MenuPrincipal();
        int opcao;

        do {
            opcao = menu.menuPrincipal();

            switch (opcao) {
                case 1:
                        cadastro();
                    break;

                case 2:
                        movimentacao();
                    break;

                case 3:
                        reajusteDePreco();
                    break;

                case 4:
                        relatorios();
                    break;

                case 0:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opção invalida!!!\n");
                    break;
            }
        } while (true);
    }


    public void cadastro() {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        Produto produto;
        Cadastro cadastro = new Cadastro();
        int opcao;

        do {
            opcao = cadastro.menuCadastro();

            switch (opcao) {
                case 1:
                    do{
                        try {
                            produtoDAO.inserir(cadastro.inclusao());
                        } catch (Exception ex) {
                            System.out.println(ex.getMessage());
                        }
                        Novamente = fazernovamente.MaisUm();
                    }while (Novamente);
                    break;

                case 2:
                    do{
                        try {
                            produto = produtoDAO.consultarPorNome(cadastro.consultaPorNome());
                            produtoDAO.alterar(cadastro.alteracao(produto));
                        } catch (Exception ex) {
                            System.out.println(ex.getMessage());
                        }
                        Novamente = fazernovamente.MaisUm();
                    }while(Novamente);
                    break;

                case 3:
                    do{
                        try {
                            produto = produtoDAO.consultarPorNome(cadastro.consultaPorNome());
                            produtoDAO.excluir(cadastro.exclusao(produto));
                        } catch (Exception ex) {
                            System.out.println(ex.getMessage());
                        }
                        Novamente = fazernovamente.MaisUm();
                    }while(Novamente);
                    break;

                case 4:
                    do{
                        try {
                            produto = produtoDAO.consultarPorNome(cadastro.consultaPorNome());
                            cadastro.consultaResultado(produto);
                        } catch (Exception ex) {
                            System.out.println(ex.getMessage());
                        }
                        Novamente = fazernovamente.MaisUm();
                    }while(Novamente);
                    break;

                case 0:
                    opcao = 0;
                    break;

                default:
                    System.out.println("Opção invalida!!!\n");
                    break;
            }
        } while (opcao != 0);
    }

    public void movimentacao() {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        Produto produto;
        Movimentacao movimentacao = new Movimentacao();
        int opcao;

        do {
            opcao = movimentacao.menuMovimentacao();

            switch (opcao) {
                case 1:
                    do{
                        try {
                            produto = produtoDAO.consultarPorNome(movimentacao.consultaPorNome());
                            produtoDAO.alterarQuantidade(movimentacao.entrada(produto));
                        } catch (Exception ex) {
                            System.out.println(ex.getMessage());
                        }
                        Novamente = fazernovamente.MaisUm();
                    }while(Novamente = true);
                    break;

                case 2:
                    do{
                        try {
                            produto = produtoDAO.consultarPorNome(movimentacao.consultaPorNome());
                            produtoDAO.alterarQuantidade(movimentacao.saida(produto));
                        } catch (Exception ex) {
                            System.out.println(ex.getMessage());
                        }
                        Novamente = fazernovamente.MaisUm();
                    }while (Novamente);
                    break;

                case 0:
                    opcao = 0;
                    break;

                default:
                    System.out.println("Opção invalida!!!\n");
                    break;
            }
        } while (opcao != 0);
    }

    public void reajusteDePreco() {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        Produto produto;
        ReajusteDePreco reajusteDePreco = new ReajusteDePreco();
        int opcao;

        do {
            opcao = reajusteDePreco.menuReajusteDePrecos();

            switch (opcao) {
                case 1:
                    do{
                        try {
                            produto = produtoDAO.consultarPorNome(reajusteDePreco.consultaPorNome());
                            produtoDAO.alterarPreco(reajusteDePreco.reajustarPreco(produto));
                        } catch (SQLException ex) {
                            System.out.println(ex.getMessage());
                        }
                        Novamente = fazernovamente.MaisUm();
                    }while(Novamente);
                    break;

                case 0:
                    opcao = 0;
                    break;

                default:
                    System.out.println("Opção invalida!!!\n");
                    break;
            }
        } while (opcao != 0);
    }

    public void relatorios() throws SQLException {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        Relatorios relatorios = new Relatorios();
        int opcao;

        do {
            opcao = relatorios.menuRelatorios();

            switch (opcao) {
                case 1:
                    do{
                        File rel = new File("/RelatorioPreco.txt");
                        BufferedWriter writer = relatorios.listaDePrecos();
                        try {
                            BufferedReader br = new BufferedReader(new FileReader(rel));
                            String string = br.readLine();
                            while(string != null){
                                System.out.println(string);
                                string = br.readLine();
                            }
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Novamente = fazernovamente.MaisUm();
                    }while (Novamente);
                    break;

                case 2:
                    do{
                        Novamente = fazernovamente.MaisUm();
                    }while (Novamente);
                    break;

                case 0:
                    opcao = 0;
                    break;

                default:
                    System.out.println("Opção invalida!!!\n");
                    break;
            }
        } while (opcao != 0);
    }
}
