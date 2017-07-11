package trabalho.model.entity;

/**
 * Created by rodrigo on 04/05/17.
 */
public class Produto {
    private int id;
    private String nome;
    private double preco;
    private String unidade;
    private int quantidade;


    public Produto() {
    }

    public Produto(String nome, double preco, String unidade, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.unidade = unidade;
        this.quantidade = quantidade;
    }

    public Produto(int id, String nome, double preco, String unidade, int quantidade) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.unidade = unidade;
        this.quantidade = quantidade;
    }


    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "[" + id + "] - " + nome.toUpperCase();
    }
}
