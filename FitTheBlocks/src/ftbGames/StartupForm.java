package ftbGames;
<<<<<<< HEAD:FitTheBlocks/src/StartupForm.java

=======
>>>>>>> main:FitTheBlocks/src/ftbGames/StartupForm.java
public class StartupForm extends javax.swing.JFrame {

    public StartupForm() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnStart = new javax.swing.JButton();
        btnLeaderboard = new javax.swing.JButton();
        btnQuit = new javax.swing.JButton();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("ftbGames");
<<<<<<< HEAD:FitTheBlocks/src/StartupForm.java
        
        // Konfigurasi tombol Start
=======
>>>>>>> main:FitTheBlocks/src/ftbGames/StartupForm.java
        btnStart.setText("Start Game");
        btnStart.setBackground(new java.awt.Color(221, 160, 221)); // Warna ungu muda
        btnStart.setForeground(java.awt.Color.WHITE); // Warna teks hitam
        btnStart.setFocusPainted(false);
        btnStart.setFont(new java.awt.Font("Poppins", java.awt.Font.BOLD, 14)); // Pastikan font sudah tersedia
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });
        
        // Konfigurasi tombol Leaderboard
        btnLeaderboard.setText("Leaderboard");
        btnLeaderboard.setBackground(new java.awt.Color(221, 160, 221)); 
        btnLeaderboard.setForeground(java.awt.Color.WHITE); 
        btnLeaderboard.setFocusPainted(false);
        btnLeaderboard.setFont(new java.awt.Font("Poppins", java.awt.Font.BOLD, 14)); 
        btnLeaderboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLeaderboardActionPerformed(evt);
            }
        });
        
        // Konfigurasi tombol Quit
        btnQuit.setText("Quit");
        btnQuit.setBackground(new java.awt.Color(221, 160, 221)); 
        btnQuit.setForeground(java.awt.Color.WHITE); 
        btnQuit.setFocusPainted(false);
        btnQuit.setFont(new java.awt.Font("Poppins", java.awt.Font.BOLD, 14));
        btnQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitActionPerformed(evt);
            }
        });
        

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(78, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnStart, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLeaderboard, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnQuit, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
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

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed

        this.setVisible(false);
        Tetris.start();
        
    }//GEN-LAST:event_btnStartActionPerformed

    private void btnLeaderboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLeaderboardActionPerformed
        
        this.setVisible(false);
        Tetris.showLeaderboard();
        
    }//GEN-LAST:event_btnLeaderboardActionPerformed

    private void btnQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitActionPerformed
        
        System.exit(0);
        
    }//GEN-LAST:event_btnQuitActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLeaderboard;
    private javax.swing.JButton btnQuit;
    private javax.swing.JButton btnStart;
    // End of variables declaration//GEN-END:variables
}