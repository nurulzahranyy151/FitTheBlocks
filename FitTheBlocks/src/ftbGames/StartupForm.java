package ftbGames;
import java.awt.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.WindowConstants;
import java.io.File;
import java.io.IOException;



public class StartupForm extends javax.swing.JFrame {

    public StartupForm() {
        setTitle("Fit The Blocks!");
        initComponents();
        loadCustomFont();
    }
    
   
    private void initComponents() {

        btnStart = new JButton();
        btnLeaderboard = new JButton();
        btnQuit = new JButton();
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("ftbGames");

        btnStart.setText("Start Game");
        btnStart.setBackground(new Color(221, 160, 221)); // Warna ungu muda
        btnStart.setForeground(Color.WHITE); // Warna teks hitam
        btnStart.setFocusPainted(false);
        btnStart.setFont(new java.awt.Font("Poppins", Font.BOLD, 14)); // Pastikan font sudah tersedia
        btnStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });
        btnLeaderboard.setText("Leaderboard");
        btnLeaderboard.setBackground(new Color(221, 160, 221)); 
        btnLeaderboard.setForeground(Color.WHITE); 
        btnLeaderboard.setFocusPainted(false);
        btnLeaderboard.setFont(new Font("Poppins", Font.BOLD, 14)); 
        btnLeaderboard.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnLeaderboardActionPerformed(evt);
            }
        });
        
        // Konfigurasi tombol Quit
        btnQuit.setText("Quit");
        btnQuit.setBackground(new Color(221, 160, 221)); 
        btnQuit.setForeground(Color.WHITE); 
        btnQuit.setFocusPainted(false);
        btnQuit.setFont(new Font("Poppins", Font.BOLD, 14));
        btnQuit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnQuitActionPerformed(evt);
            }
        });
        

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(78, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(btnStart, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLeaderboard, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnQuit, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(btnStart)
                .addGap(34, 34, 34)
                .addComponent(btnLeaderboard)
                .addGap(35, 35, 35)
                .addComponent(btnQuit)
                .addContainerGap(89, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void btnStartActionPerformed(ActionEvent evt) {

        this.setVisible(false);
        Tetris.start();
        
    }

    private void btnLeaderboardActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnLeaderboardActionPerformed
        
        this.setVisible(false);
        Tetris.showLeaderboard();
        
    }//GEN-LAST:event_btnLeaderboardActionPerformed

    private void btnQuitActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnQuitActionPerformed
        
        System.exit(0);
        
    }
    
    
    private JButton btnLeaderboard;
    private JButton btnQuit;
    private JButton btnStart;
    // End of variables declaration//GEN-END:variables

    private void loadCustomFont() {
        try {
            // Ganti dengan path yang sesuai di mana Anda menyimpan file font Poppins
            Font poppinsFont = Font.createFont(Font.TRUETYPE_FONT, new File("res/fonts/Poppins/Poppins-Medium.ttf"));
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(poppinsFont);
            
            // Mengatur font untuk komponen
            Font poppins = poppinsFont.deriveFont(12f); // Ukuran font 12
            btnLeaderboard.setFont(poppins);
            btnQuit.setFont(poppins);
            btnStart.setFont(poppins);
            // Anda bisa mengatur font untuk komponen lain di sini
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
    }
}
