package trabalho.model.dao;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by rodrigo on 04/05/17.
 */
public interface DAO<T> {

    void inserir(T type) throws SQLException;

    void alterar(T type) throws SQLException;

    void excluir(T type) throws SQLException;

    List<T> listar() throws SQLException;

    T consultarPorNome(String nome) throws SQLException;
}
