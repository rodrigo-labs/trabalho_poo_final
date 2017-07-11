package trabalho.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import trabalho.model.entity.Produto;

/**
 * Created by rodrigo on 04/05/17.
 */
public class ProdutoDAO implements DAO<Produto> {
    private final Connection connection;


    public ProdutoDAO() {
    	ConnectionFactory CF = new ConnectionFactory();
        this.connection = CF.getConnection();
    }


    @Override
    public void inserir(Produto produto) throws SQLException {
        String sql = "INSERT INTO PRODUTO (NOME, PRECO, UNIDADE, QUANTIDADE) VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, produto.getNome());
            statement.setDouble(2, produto.getPreco());
            statement.setString(3, produto.getUnidade());
            statement.setInt(4, produto.getQuantidade());
            statement.execute();

        }
    }

    @Override
    public void alterar(Produto produto) throws SQLException {
        String sql = "UPDATE PRODUTO SET NOME = ?, PRECO = ?, UNIDADE = ?, QUANTIDADE = ? WHERE ID = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, produto.getNome());
            statement.setDouble(2, produto.getPreco());
            statement.setString(3, produto.getUnidade());
            statement.setInt(4, produto.getQuantidade());
            statement.setInt(5, produto.getId());
            statement.execute();
        }
    }

    public void alterarPreco(Produto produto) throws SQLException {
        String sql = "UPDATE PRODUTO SET PRECO = ? WHERE ID = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDouble(1, produto.getPreco());
            statement.setInt(2, produto.getId());
            statement.execute();
        }

    }

    public void alterarQuantidade(Produto produto) throws SQLException {
        String sql = "UPDATE PRODUTO SET QUANTIDADE = ? WHERE ID = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDouble(1, produto.getQuantidade());
            statement.setInt(2, produto.getId());
            statement.execute();
        }

    }

    @Override
    public void excluir(Produto produto) throws SQLException {
        String sql = "DELETE FROM PRODUTO WHERE ID = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, produto.getId());
            statement.execute();
        }
    }

    @Override
    public List<Produto> listar() throws SQLException {
        String sql = "SELECT * FROM PRODUTO";
        List<Produto> produtos = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.execute();

            try (ResultSet resultSet = statement.getResultSet()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("ID");
                    String nome = resultSet.getString("NOME");
                    double preco = resultSet.getDouble("PRECO");
                    String unidade = resultSet.getString("UNIDADE");
                    int quantidade = resultSet.getInt("QUANTIDADE");

                    Produto produto = new Produto(id, nome, preco, unidade, quantidade);

                    produtos.add(produto);
                }
            }
        }

        return produtos;
    }

    @Override
    public Produto consultarPorNome(String nomePesquisa) throws SQLException {
        String sql = "SELECT * FROM PRODUTO WHERE NOME = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, nomePesquisa);
            statement.execute();

            try (ResultSet resultSet = statement.getResultSet()){
                if (resultSet.next()) {
                    int id = resultSet.getInt("ID");
                    String nome = resultSet.getString("NOME");
                    double preco = resultSet.getDouble("PRECO");
                    String unidade = resultSet.getString("UNIDADE");
                    int quantidade = resultSet.getInt("QUANTIDADE");

                    Produto produto = new Produto(id, nome, preco, unidade, quantidade);

                    return produto;
                }

                throw new IllegalArgumentException("Produto não encontrado");
            }
        }
    }
}
