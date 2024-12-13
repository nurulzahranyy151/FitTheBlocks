<<<<<<< HEAD:FitTheBlocks/src/ftbGames/StartupForm.java
package ftbGames;
<<<<<<< HEAD:FitTheBlocks/src/StartupForm.java
=======
import java.awt.Color;
import static java.awt.EventQueue.invokeLater;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
>>>>>>> 7d27d563e7a853af50a6e6ae9a31cbc8aa0a7428:FitTheBlocks/src/StartupForm.java

=======
>>>>>>> main:FitTheBlocks/src/ftbGames/StartupForm.java
public class StartupForm extends javax.swing.JFrame {

    public StartupForm() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnStart = new JButton();
        btnLeaderboard = new JButton();
        btnQuit = new JButton();
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("ftbGames");
<<<<<<< HEAD:FitTheBlocks/src/StartupForm.java
        
        // Konfigurasi tombol Start
=======
>>>>>>> main:FitTheBlocks/src/ftbGames/StartupForm.java
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
        
        // Konfigurasi tombol Leaderboard
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
    }// </editor-fold>//GEN-END:initComponents

    private void btnStartActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed

        this.setVisible(false);
        Tetris.start();
        
    }//GEN-LAST:event_btnStartActionPerformed

    private void btnLeaderboardActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnLeaderboardActionPerformed
        
        this.setVisible(false);
        Tetris.showLeaderboard();
        
    }//GEN-LAST:event_btnLeaderboardActionPerformed

    private void btnQuitActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnQuitActionPerformed
        
        System.exit(0);
        
    }//GEN-LAST:event_btnQuitActionPerformed

<<<<<<< HEAD:FitTheBlocks/src/ftbGames/StartupForm.java
=======
    /**
     * @param args the command line arguments
     */

>>>>>>> 7d27d563e7a853af50a6e6ae9a31cbc8aa0a7428:FitTheBlocks/src/StartupForm.java
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton btnLeaderboard;
    private JButton btnQuit;
    private JButton btnStart;
    // End of variables declaration//GEN-END:variables
}