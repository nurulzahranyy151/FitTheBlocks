package ftbGames;

public class Main {
    public static void main(String[] args)
    {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // Inisialisasi objek GameForm, StartupForm, LeaderboardForm
                GameForm gf = new GameForm();
                StartupForm sf = new StartupForm();
                LeaderboardForm lf = new LeaderboardForm();
        
                // Set semua form menjadi visible
                sf.setVisible(true);

                // Menghubungkan form dengan Tetris
                Tetris.initialize(gf, sf, lf);
            }
        });
    }
}
