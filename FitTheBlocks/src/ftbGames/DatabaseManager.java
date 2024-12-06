package ftbGames;
import java.sql.*;
import java.util.ArrayList;

public class DatabaseManager {
    private Connection connection;

    // Constructor to initialize the database connection
    public DatabaseManager(String url, String user, String password) throws SQLException {
        connection = DriverManager.getConnection(url, user, password);
    }

    // Method to add player's name and score to the database
    public void addPlayer(String name, int score) throws SQLException {
        String query = "INSERT INTO leaderboard (name, score) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, name); // Player's name
            stmt.setInt(2, score);   // Player's score
            stmt.executeUpdate();
            System.out.println("Player data added to the leaderboard.");
        }
    }

    // Method to fetch the leaderboard from the database
    public ArrayList<String[]> getLeaderboard() throws SQLException {
        ArrayList<String[]> leaderboard = new ArrayList<>();
        String query = "SELECT name, score FROM leaderboard ORDER BY score DESC"; // Order by score descending
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                String playerName = rs.getString("name");
                int score = rs.getInt("score");
                leaderboard.add(new String[]{playerName, String.valueOf(score)});
            }
        }
        return leaderboard;
    }
}
