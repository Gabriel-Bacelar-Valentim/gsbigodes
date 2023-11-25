package br.com.fiap.sprint4bigodes.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.sprint4bigodes.model.Pacientes;
 
public class PacientesDao {
 
    public void cadastrarPaciente(Pacientes paciente) {
        String sql = "INSERT INTO Pacientes (PacienteID, Nome, Idade, Sexo, CPF) VALUES (?, ?, ?, ?, ?)";
 
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
 
            preparedStatement.setLong(1, paciente.getPacienteId());
            preparedStatement.setString(2, paciente.getNome());
            preparedStatement.setLong(3, paciente.getIdade());
            preparedStatement.setString(4, paciente.getSexo());
            preparedStatement.setString(5, paciente.getCpf());
 
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar paciente", e);
        }
    }
 
    public Pacientes consultarPaciente(Long id) {
        String sql = "SELECT * FROM Pacientes WHERE PacienteID = ?";
 
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
 
            preparedStatement.setLong(1, id);
 
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return criarPaciente(resultSet);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao consultar paciente", e);
        }
 
        return null;
    }
 
    public List<Pacientes> listarPacientes() {
        List<Pacientes> pacientes = new ArrayList<>();
        String sql = "SELECT * FROM Pacientes";
 
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
 
            while (resultSet.next()) {
                pacientes.add(criarPaciente(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar pacientes", e);
        }
 
        return pacientes;
    }
 
    private Pacientes criarPaciente(ResultSet resultSet) throws SQLException {
        Pacientes paciente = new Pacientes();
        paciente.setPacienteId(resultSet.getLong("PacienteID"));
        paciente.setNome(resultSet.getString("Nome"));
        paciente.setIdade(resultSet.getLong("Idade"));
        paciente.setSexo(resultSet.getString("Sexo"));
        paciente.setCpf(resultSet.getString("CPF"));
        return paciente;
    }
    
    public void atualizarPaciente(Pacientes paciente) {
        String sql = "UPDATE Pacientes SET Nome = ?, Idade = ?, Sexo = ?, CPF = ? WHERE PacienteID = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, paciente.getNome());
            preparedStatement.setLong(2, paciente.getIdade());
            preparedStatement.setString(3, paciente.getSexo());
            preparedStatement.setString(4, paciente.getCpf());
            preparedStatement.setLong(5, paciente.getPacienteId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar paciente", e);
        }
    }

    public void deletarPaciente(Long id) {
        String sql = "DELETE FROM Pacientes WHERE PacienteID = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar paciente", e);
        }
    }
}


