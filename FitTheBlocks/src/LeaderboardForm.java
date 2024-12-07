package ftbGames;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
//import java.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class LeaderboardForm extends javax.swing.JFrame {

    private DefaultTableModel tm;
    
    public LeaderboardForm() {
        initComponents();
        initTableData();
    }
    
    private void initTableData()
    {
        tm = (DefaultTableModel)leaderboard.getModel();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        try {
            Font poppins = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("res/fonts/Poppins/Poppins-Black.ttf"));
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(poppins);
        } catch (Exception e) {
            e.printStackTrace();
        }

        btnMainMenu = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        leaderboard = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(true);
        Font poppinsRegular = new Font("Poppins", Font.PLAIN, 14);
        Font poppinsBold = new Font("Poppins", Font.BOLD, 18);

        JLabel lblTitle = new JLabel("Leaderboard");
        lblTitle.setFont(poppinsBold.deriveFont(24f));
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);

        btnMainMenu = new JButton("Main Menu");
        btnMainMenu.setFont(poppinsRegular.deriveFont(16f));
        btnMainMenu.setBackground(new Color(255, 182, 193)); 
        btnMainMenu.setForeground(Color.WHITE);
        btnMainMenu.setFocusPainted(false);
        btnMainMenu.addActionListener(evt -> btnMainMenuActionPerformed(evt));

        //ngembaliin ke menu utama dalam 1 panel
        btnMainMenu.setText("Main Menu");
        btnMainMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMainMenuActionPerformed(evt);
            }
        });

        // leaderboard.setModel(new javax.swing.table.DefaultTableModel(
        //     new Object [][] {

        //     },
        //     new String [] {
        //         " Player", " Score"
        //     }
        // ) {
        //     boolean[] canEdit = new boolean [] {
        //         false, false
        //     };

        //     public boolean isCellEditable(int rowIndex, int columnIndex) {
        //         return canEdit [columnIndex];
        //     }
        // });
        // jScrollPane1.setViewportView(leaderboard);
        
        leaderboard = new JTable();
        leaderboard.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{"Player", "Score"}
        ) {
            boolean[] canEdit = new boolean[]{
                    false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        leaderboard.setFont(poppinsRegular);
        leaderboard.setRowHeight(25);
        leaderboard.setBackground(new Color(255, 240, 245));  // Light pink background for the table
        leaderboard.setGridColor(new Color(255, 105, 180));  // Pink grid lines
        leaderboard.setSelectionBackground(new Color(255, 105, 180));  // Pink selection background
        JScrollPane jScrollPane1 = new JScrollPane(leaderboard);
        jScrollPane1.setBackground(new Color(255, 182, 193)); // Light pink background for JScrollPane
        jScrollPane1.setBorder(BorderFactory.createLineBorder(new Color(255, 105, 180))); // Pink border


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnMainMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnMainMenu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnMainMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMainMenuActionPerformed
        
        this.setVisible(false);
        Tetris.showStartup();
        
    }//GEN-LAST:event_btnMainMenuActionPerformed

    public void addPlayer(String playerName, int score)
    {
        tm.addRow(new Object[] {playerName, score});
        
        this.setVisible(true);
    }
            
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LeaderboardForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LeaderboardForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LeaderboardForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LeaderboardForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LeaderboardForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMainMenu;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable leaderboard;
    // End of variables declaration//GEN-END:variables

    public void updateLeaderboard(DatabaseManager dbManager) {
        tm.setRowCount(0);  // Clear existing rows
    
        try {
            // Fetch updated leaderboard data from the database
            ArrayList<String[]> leaderboardData = dbManager.getLeaderboard();
    
            // Add rows to the table model
            for (String[] data : leaderboardData) {
                tm.addRow(data);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    

}