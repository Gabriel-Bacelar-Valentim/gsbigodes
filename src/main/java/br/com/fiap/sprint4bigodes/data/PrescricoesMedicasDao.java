package br.com.fiap.sprint4bigodes.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.sprint4bigodes.model.PrescricoesMedicas;
 
public class PrescricoesMedicasDao {
 
    public void cadastrarPrescricoesMedicas(PrescricoesMedicas prescricoesMedicas) {
        String sql = "INSERT INTO PrescricoesMedicas (PRESCRICAOID, CONSULTAID, MEDICAMENTOID, DOSAGEM) VALUES (?, ?, ?, ?)";
 
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
 
            preparedStatement.setLong(1, prescricoesMedicas.getPrescricaoId());
            preparedStatement.setLong(2, prescricoesMedicas.getConsultaId());
            preparedStatement.setLong(3, prescricoesMedicas.getMedicamentoId());
            preparedStatement.setString(4, prescricoesMedicas.getDosagem());
 
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar prescrição médica", e);
        }
    }
 
    public PrescricoesMedicas consultarPrescricoesMedicas(Long id) {
        String sql = "SELECT * FROM PrescricoesMedicas WHERE PRESCRICAOID = ?";
 
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
 
            preparedStatement.setLong(1, id);
 
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return criarPrescricoesMedicas(resultSet);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao consultar prescrição médica", e);
        }
 
        return null;
    }
 
    public List<PrescricoesMedicas> listarPrescricoesMedicas() {
        List<PrescricoesMedicas> prescricoesMedicas = new ArrayList<>();
        String sql = "SELECT * FROM PrescricoesMedicas";
 
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
 
            while (resultSet.next()) {
                prescricoesMedicas.add(criarPrescricoesMedicas(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar prescrições médicas", e);
        }
 
        return prescricoesMedicas;
    }
 
    private PrescricoesMedicas criarPrescricoesMedicas(ResultSet resultSet) throws SQLException {
        PrescricoesMedicas prescricoesMedicas = new PrescricoesMedicas();
        prescricoesMedicas.setPrescricaoId(resultSet.getLong("PRESCRICAOID"));
        prescricoesMedicas.setConsultaId(resultSet.getLong("CONSULTAID"));
        prescricoesMedicas.setMedicamentoId(resultSet.getLong("MEDICAMENTOID"));
        prescricoesMedicas.setDosagem(resultSet.getString("DOSAGEM"));
        return prescricoesMedicas;
    }
    public void atualizarPrescricoesMedicas(PrescricoesMedicas prescricoesMedicas) {
        String sql = "UPDATE PrescricoesMedicas SET CONSULTAID = ?, MEDICAMENTOID = ?, DOSAGEM = ? WHERE PRESCRICAOID = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setLong(1, prescricoesMedicas.getConsultaId());
            preparedStatement.setLong(2, prescricoesMedicas.getMedicamentoId());
            preparedStatement.setString(3, prescricoesMedicas.getDosagem());
            preparedStatement.setLong(4, prescricoesMedicas.getPrescricaoId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar prescrição médica", e);
        }
    }

    public void deletarPrescricoesMedicas(Long id) {
        String sql = "DELETE FROM PrescricoesMedicas WHERE PRESCRICAOID = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar prescrição médica", e);
        }
    }
}
