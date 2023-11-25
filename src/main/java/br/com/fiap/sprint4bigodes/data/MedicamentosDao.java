package br.com.fiap.sprint4bigodes.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.sprint4bigodes.model.Medicamentos;

public class MedicamentosDao {

    public void cadastrarMedicamento(Medicamentos medicamento) {
        String sql = "INSERT INTO Medicamentos (MedicamentoID, NomeMedicamento, TipoMedicamento, Indicacoes) VALUES (?, ?, ?, ?)";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setLong(1, medicamento.getMedicamentoId());
            preparedStatement.setString(2, medicamento.getNomeMedicamento());
            preparedStatement.setString(3, medicamento.getTipoMedicamento());
            preparedStatement.setString(4, medicamento.getIndicacoes());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar medicamento", e);
        }
    }

    public Medicamentos consultarMedicamento(Long id) {
        String sql = "SELECT * FROM Medicamentos WHERE MedicamentoID = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setLong(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return criarMedicamento(resultSet);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao consultar medicamento", e);
        }

        return null;
    }

    public List<Medicamentos> listarMedicamentos() {
        List<Medicamentos> medicamentos = new ArrayList<>();
        String sql = "SELECT * FROM Medicamentos";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                medicamentos.add(criarMedicamento(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar medicamentos", e);
        }

        return medicamentos;
    }

    public void atualizarMedicamento(Medicamentos medicamento) {
        String sql = "UPDATE Medicamentos SET NomeMedicamento = ?, TipoMedicamento = ?, Indicacoes = ? WHERE MedicamentoID = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, medicamento.getNomeMedicamento());
            preparedStatement.setString(2, medicamento.getTipoMedicamento());
            preparedStatement.setString(3, medicamento.getIndicacoes());
            preparedStatement.setLong(4, medicamento.getMedicamentoId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar medicamento", e);
        }
    }

    public void deletarMedicamento(Long id) {
        String sql = "DELETE FROM Medicamentos WHERE MedicamentoID = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar medicamento", e);
        }
    }

    private Medicamentos criarMedicamento(ResultSet resultSet) throws SQLException {
        Medicamentos medicamento = new Medicamentos();
        medicamento.setMedicamentoId(resultSet.getLong("MedicamentoID"));
        medicamento.setNomeMedicamento(resultSet.getString("NomeMedicamento"));
        medicamento.setTipoMedicamento(resultSet.getString("TipoMedicamento"));
        medicamento.setIndicacoes(resultSet.getString("Indicacoes"));
        return medicamento;
    }
}
