package br.com.fiap.sprint4bigodes.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.sprint4bigodes.model.ConsultasMedicas;

public class ConsultasMedicasDao {

    public void criarConsultasMedicas(ConsultasMedicas consultasMedicas) {
        String sql = "INSERT INTO ConsultasMedicas (ConsultaID, PacienteID, DataConsulta, DoencaID, Tratamento) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setLong(1, consultasMedicas.getConsultaId());
            preparedStatement.setLong(2, consultasMedicas.getPacienteId());
            preparedStatement.setDate(3, new java.sql.Date(consultasMedicas.getDataConsulta().getTime()));
            preparedStatement.setLong(4, consultasMedicas.getDoencaId());
            preparedStatement.setString(5, consultasMedicas.getTratamento());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar consulta médica", e);
        }
    }

    public ConsultasMedicas consultarConsultasMedicas(Long id) {
        String sql = "SELECT * FROM ConsultasMedicas WHERE ConsultaID = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setLong(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return criarConsultasMedicas(resultSet);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao consultar consulta médica", e);
        }

        return null;
    }

    public List<ConsultasMedicas> listarConsultasMedicas() {
        List<ConsultasMedicas> consultasMedicas = new ArrayList<>();
        String sql = "SELECT * FROM ConsultasMedicas";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
            	var consulta = criarConsultasMedicas(resultSet);
                consultasMedicas.add(consulta);
                System.out.println(consulta.getDataConsulta());
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar consultas médicas", e);
        }

        return consultasMedicas;
    }

    public void atualizarConsultasMedicas(ConsultasMedicas consultasMedicas) {
        String sql = "UPDATE ConsultasMedicas SET PacienteID = ?, DataConsulta = ?, DoencaID = ?, Tratamento = ? WHERE ConsultaID = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setLong(1, consultasMedicas.getPacienteId());
            preparedStatement.setDate(2, new java.sql.Date(consultasMedicas.getDataConsulta().getTime()));
            preparedStatement.setLong(3, consultasMedicas.getDoencaId());
            preparedStatement.setString(4, consultasMedicas.getTratamento());
            preparedStatement.setLong(5, consultasMedicas.getConsultaId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar consulta médica", e);
        }
    }

    public void deletarConsultasMedicas(Long id) {
        String sql = "DELETE FROM ConsultasMedicas WHERE ConsultaID = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar consulta médica", e);
        }
    }

    private ConsultasMedicas criarConsultasMedicas(ResultSet resultSet) throws SQLException {
        ConsultasMedicas consultasMedicas = new ConsultasMedicas();
        consultasMedicas.setConsultaId(resultSet.getLong("ConsultaID"));
        consultasMedicas.setPacienteId(resultSet.getLong("PacienteID"));
        consultasMedicas.setDataConsulta(resultSet.getDate("DataConsulta"));
        consultasMedicas.setDoencaId(resultSet.getLong("DoencaID"));
        consultasMedicas.setTratamento(resultSet.getString("Tratamento"));
        return consultasMedicas;
    }
}
