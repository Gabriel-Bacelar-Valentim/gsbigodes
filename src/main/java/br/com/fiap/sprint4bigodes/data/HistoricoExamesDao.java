package br.com.fiap.sprint4bigodes.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.sprint4bigodes.model.HistoricoExames;
 
public class HistoricoExamesDao {
 
    public void cadastrarExame(HistoricoExames exame) {
        String sql = "INSERT INTO HistoricoExames (ExameID, PacienteID, TipoExame, Resultado) VALUES (?, ?, ?, ?)";
 
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
 
            preparedStatement.setLong(1, exame.getExameId());
            preparedStatement.setLong(2, exame.getPacienteId());
            preparedStatement.setString(3, exame.getTipoExame());
            preparedStatement.setString(4, exame.getResultado());
 
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar exame", e);
        }
    }
 
    public HistoricoExames consultarExame(Long id) {
        String sql = "SELECT * FROM HistoricoExames WHERE ExameID = ?";
 
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
 
            preparedStatement.setLong(1, id);
 
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return criarExame(resultSet);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao consultar exame", e);
        }
 
        return null;
    }
 
    public List<HistoricoExames> listarExames() {
        List<HistoricoExames> exames = new ArrayList<>();
        String sql = "SELECT * FROM HistoricoExames";
 
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
 
            while (resultSet.next()) {
                exames.add(criarExame(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar exames", e);
        }
 
        return exames;
    }

    public void atualizarExame(HistoricoExames exame) {
        String sql = "UPDATE HistoricoExames SET PacienteID=?, TipoExame=?, Resultado=? WHERE ExameID=?";
 
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
 
            preparedStatement.setLong(1, exame.getPacienteId());
            preparedStatement.setString(2, exame.getTipoExame());
            preparedStatement.setString(3, exame.getResultado());
            preparedStatement.setLong(4, exame.getExameId());
 
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar exame", e);
        }
    }

    public void deletarExame(Long id) {
        String sql = "DELETE FROM HistoricoExames WHERE ExameID=?";
 
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
 
            preparedStatement.setLong(1, id);
 
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar exame", e);
        }
    }
 
    private HistoricoExames criarExame(ResultSet resultSet) throws SQLException {
        HistoricoExames exame = new HistoricoExames();
        exame.setExameId(resultSet.getLong("ExameID"));
        exame.setPacienteId(resultSet.getLong("PacienteID"));
        exame.setTipoExame(resultSet.getString("TipoExame"));
        exame.setResultado(resultSet.getString("Resultado"));
        return exame;
    }
}
