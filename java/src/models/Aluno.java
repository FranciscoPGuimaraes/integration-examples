
package models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Aluno {
    public int id;
    public String nome;
    public int idade;
    public String matricula;
    public String email;

    public Aluno(int id, String nome, int idade, String matricula, String email) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.matricula = matricula;
        this.email = email;
    }

    public static int create(Connection conn, Aluno aluno) throws SQLException {
        String sql = "INSERT INTO alunos (nome, idade, matricula, email) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, aluno.nome);
            stmt.setInt(2, aluno.idade);
            stmt.setString(3, aluno.matricula);
            stmt.setString(4, aluno.email);
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) return rs.getInt(1);
        }
        return -1;
    }

    public static Aluno read(Connection conn, int id) throws SQLException {
        String sql = "SELECT * FROM alunos WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Aluno(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getInt("idade"),
                    rs.getString("matricula"),
                    rs.getString("email")
                );
            }
        }
        return null;
    }

    public static List<Aluno> readAll(Connection conn) throws SQLException {
        List<Aluno> alunos = new ArrayList<>();
        String sql = "SELECT * FROM alunos";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                alunos.add(new Aluno(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getInt("idade"),
                    rs.getString("matricula"),
                    rs.getString("email")
                ));
            }
        }
        return alunos;
    }

    public static void delete(Connection conn, int id) throws SQLException {
        String sql = "DELETE FROM alunos WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
