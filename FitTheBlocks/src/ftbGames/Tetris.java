package ftbGames;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Tetris
{
    private static GameForm gf;
    private static StartupForm sf;
    private static LeaderboardForm lf;

    public static void initialize(GameForm gfInstance, StartupForm sfInstance, LeaderboardForm lfInstance) {
        gf = gfInstance;
        sf = sfInstance;
        lf = lfInstance;
    }
    
    public static void start() {
        gf.setVisible(true);
        gf.startGame();
    }
    
    public static void showLeaderboard() {
        try {
            // Inisialisasi DatabaseManager untuk mengambil data terbaru
            DatabaseManager dbManager = new DatabaseManager("jdbc:mysql://localhost:3307/tetris_game", "root", "");
            
            // Perbarui data leaderboard
            lf.updateLeaderboard(dbManager);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        lf.setVisible(true);
    }
    
    
    public static void showStartup() {
        sf.setVisible(true);
    }
    
    public static void gameOver(int score) {
        String playerName = JOptionPane.showInputDialog("Game Over!\nPlease enter your name.");
        if (playerName != null && !playerName.trim().isEmpty()) {
            // Hide the game form
            gf.setVisible(false);
   
            try {
                // Tambahkan data pemain ke database
                DatabaseManager dbManager = new DatabaseManager("jdbc:mysql://localhost:3307/tetris_game", "root", "");
                dbManager.addPlayer(playerName, score);
                
                // Perbarui leaderboard dengan data terbaru
                lf.updateLeaderboard(dbManager);
            
                // Tampilkan leaderboard
                lf.setVisible(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }            
        } else {
            // If the player doesn't enter a valid name, ask them again
            JOptionPane.showMessageDialog(null, "Please enter a valid name.");
        }
    }
   
}
