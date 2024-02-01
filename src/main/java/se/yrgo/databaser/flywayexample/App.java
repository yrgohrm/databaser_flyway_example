package se.yrgo.databaser.flywayexample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Example app to use with flyway.
 *
 */
public class App {
    public static void main(String[] args) {
        // get the password from an environment variable since we do not
        // want to store it in the source code, nor give it on the command line
        final String user = System.getenv("MSSQL_USER");
        final String password = System.getenv("MSSQL_PASSWORD");
        try (Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost;trustServerCertificate=true;databaseName=Highscore", user, password)) {
            insertHighscore(conn);
            listAllScores(conn);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private static void insertHighscore(Connection conn) throws SQLException {
        final String sql = "INSERT INTO highscore (score, name) VALUES (?,?)";
        try (PreparedStatement st = conn.prepareStatement(sql)) {
            String name = ThreadLocalRandom.current().nextBoolean() ? "Nisse" : "Bosse";
            st.setInt(1, ThreadLocalRandom.current().nextInt(1000));
            st.setString(2, name);
            st.executeUpdate();
        }
    }

    private static void listAllScores(Connection conn) throws SQLException {
        try (Statement st = conn.createStatement(); 
             ResultSet rs = st.executeQuery("SELECT * FROM highscore")) {
            while (rs.next()) {
                int id = rs.getInt("id");
                int score = rs.getInt("score");
                String name = rs.getString("name");

                System.out.printf("%d %d %s%n", id, score, name);
            }
        }
    }
}
