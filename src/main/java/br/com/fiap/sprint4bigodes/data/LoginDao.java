package br.com.fiap.sprint4bigodes.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.sprint4bigodes.model.Login;

public class LoginDao {

    public void cadastrarLogin(Login login) {
        String sql = "INSERT INTO Login (nomeLogin, email, senha) VALUES (?, ?, ?)";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, login.getNomeLogin());
            preparedStatement.setString(2, login.getEmail());
            preparedStatement.setString(3, login.getSenha());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar login", e);
        }
    }

    public Login consultarLogin(String nomeLogin) {
        String sql = "SELECT * FROM Login WHERE nomeLogin = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, nomeLogin);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return criarLogin(resultSet);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao consultar login", e);
        }

        return null;
    }

    public List<Login> listarLogins() {
        List<Login> logins = new ArrayList<>();
        String sql = "SELECT * FROM Login";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                logins.add(criarLogin(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar logins", e);
        }

        return logins;
    }

    public void atualizarLogin(Login login) {
        String sql = "UPDATE Login SET email = ?, senha = ? WHERE nomeLogin = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, login.getEmail());
            preparedStatement.setString(2, login.getSenha());
            preparedStatement.setString(3, login.getNomeLogin());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar login", e);
        }
    }

    public void deletarLogin(String nomeLogin) {
        String sql = "DELETE FROM Login WHERE nomeLogin = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, nomeLogin);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar login", e);
        }
    }

    private Login criarLogin(ResultSet resultSet) throws SQLException {
        Login login = new Login();
        login.setNomeLogin(resultSet.getString("nomeLogin"));
        login.setEmail(resultSet.getString("email"));
        login.setSenha(resultSet.getString("senha"));

        return login;
    }
}
