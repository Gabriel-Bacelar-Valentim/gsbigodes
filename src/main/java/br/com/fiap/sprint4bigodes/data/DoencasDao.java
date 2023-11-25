package br.com.fiap.sprint4bigodes.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

import br.com.fiap.sprint4bigodes.model.Doencas;

public class DoencasDao {

    public void cadastrarDoenca(Doencas doenca) {
        String sql = "INSERT INTO Doencas (DoencaID, NomeDoenca) VALUES (?, ?)";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setLong(1, doenca.getDoencaId());
            preparedStatement.setString(2, doenca.getNomeDoenca());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar doença", e);
        }
    }

    public Doencas consultarDoenca(Long id) {
        String sql = "SELECT * FROM Doencas WHERE DoencaID = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setLong(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return criarDoenca(resultSet);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao consultar doença", e);
        }

        return null;
    }

    public List<Doencas> listarDoencas() {
        List<Doencas> doencas = new ArrayList<>();
        String sql = "SELECT * FROM Doencas";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                doencas.add(criarDoenca(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar doenças", e);
        }

        return doencas;
    }

    public void atualizarDoenca(Doencas doenca) {
        String sql = "UPDATE Doencas SET NomeDoenca = ? WHERE DoencaID = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, doenca.getNomeDoenca());
            preparedStatement.setLong(2, doenca.getDoencaId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar doença", e);
        }
    }

    public void deletarDoenca(Long id) {
        String sql = "DELETE FROM Doencas WHERE DoencaID = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar doença", e);
        }
    }

    private Doencas criarDoenca(ResultSet resultSet) throws SQLException {
        Doencas doenca = new Doencas();
        doenca.setDoencaId(resultSet.getLong("DoencaID"));
        doenca.setNomeDoenca(resultSet.getString("NomeDoenca"));

        return doenca;
    }
}
