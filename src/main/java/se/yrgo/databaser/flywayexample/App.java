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
        try (Connection conn = DriverManager.getConnection("jdbc:h2:./target/highscore", "sa", "")) {
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
