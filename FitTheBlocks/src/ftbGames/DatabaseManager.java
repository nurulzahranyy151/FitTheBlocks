package ftbGames;
import java.sql.*;

public class DatabaseManager {

    private Connection connection;
    private static final String DB_URL = "jdbc:sqlite:tetris.db"; // Gunakan SQLite atau ganti dengan DB yang Anda pilih

    // Konstruktor untuk membuka koneksi database
    public DatabaseManager() {
        try {
            connection = DriverManager.getConnection(DB_URL);
            System.out.println("Database connected");
            createTableIfNotExists();
        } catch (SQLException e) {
            System.err.println("Database connection failed: " + e.getMessage());
        }
    }

    // Membuat tabel jika belum ada
    private void createTableIfNotExists() {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS leaderboard ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "name TEXT NOT NULL, "
                + "score INTEGER NOT NULL, "
                + "level INTEGER NOT NULL"
                + ");";
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(createTableSQL);
        } catch (SQLException e) {
            System.err.println("Error creating table: " + e.getMessage());
        }
    }

    // Menambahkan data player baru (nama, skor, level) ke database
    public void addPlayer(String name, int score, int level) {
        String insertSQL = "INSERT INTO leaderboard (name, score, level) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(insertSQL)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, score);
            pstmt.setInt(3, level);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error inserting player: " + e.getMessage());
        }
    }

    // Mengambil leaderboard (skor tertinggi, urutan menurun)
    public ResultSet getLeaderboard() {
        String selectSQL = "SELECT * FROM leaderboard ORDER BY score DESC";
        try (Statement stmt = connection.createStatement()) {
            return stmt.executeQuery(selectSQL);
        } catch (SQLException e) {
            System.err.println("Error retrieving leaderboard: " + e.getMessage());
            return null;
        }
    }

    // Menutup koneksi database
    public void close() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            System.err.println("Error closing connection: " + e.getMessage());
        }
    }
}
