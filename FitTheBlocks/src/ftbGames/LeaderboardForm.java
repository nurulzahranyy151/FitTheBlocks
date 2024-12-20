package ftbGames;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;


public class LeaderboardForm extends JFrame {

    private DefaultTableModel tm;
    private JTextField txtDeletePlayerName;
    private JButton btnDeletePlayer;

    public LeaderboardForm() {
        setTitle("Leaderboard");
        initComponents();
        initTableData();
        loadCustomFont();
    }
    
    private void initTableData()
    {
        tm = (DefaultTableModel)leaderboard.getModel();
    }
    
  
    private void btnDeletePlayerActionPerformed(ActionEvent evt) {
        String playerName = txtDeletePlayerName.getText().trim();
    
        if (playerName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a player name.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    
        try {
            // Call deletePlayer method from DatabaseManager
            DatabaseManager dbManager = new DatabaseManager("jdbc:mysql://localhost:3307/tetris_game", "root", "");
            dbManager.deletePlayer(playerName);
            
            // Refresh leaderboard
            updateLeaderboard(dbManager);
            JOptionPane.showMessageDialog(this, "Player deleted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error deleting player: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
    
    private void initComponents() {

         btnMainMenu = new JButton();
         txtDeletePlayerName = new JTextField();
         btnDeletePlayer = new JButton();
         jScrollPane1 = new JScrollPane();
         leaderboard = new JTable();
        
        getContentPane().setBackground(new Color(229, 217, 242));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
    
        btnMainMenu.setText("Main Menu");
        btnMainMenu.setBackground(new Color(221, 160,221));
        btnMainMenu.setForeground(Color.WHITE);
        btnMainMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnMainMenuActionPerformed(evt);
            }
        });


    
        leaderboard.setModel(new DefaultTableModel(
            new Object [][] {
    
            },
            new String [] {
                "Player", "Score"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };
    
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(leaderboard);
        
        // Kustomisasi font dan tampilan tabel

        leaderboard.setRowHeight(30);
        leaderboard.setBackground(new Color(240, 240, 240));
        leaderboard.setForeground(new Color(51, 51, 51));

        leaderboard.getTableHeader().setFont(new Font("Poppins", Font.BOLD, 16));
        leaderboard.getTableHeader().setBackground(new Color(221, 160, 221));
        leaderboard.getTableHeader().setForeground(Color.WHITE);
        leaderboard.getTableHeader().setBorder(BorderFactory.createLineBorder(new Color(221, 160, 221), 2));

        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        cellRenderer.setBackground(new Color(245, 245, 245));
        cellRenderer.setForeground(new Color(64, 64, 64));

        for (int i = 0; i < leaderboard.getColumnCount(); i++) {
            leaderboard.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
        }

        // Setup for delete player text field
        txtDeletePlayerName.setToolTipText("Enter player name to delete");
        btnDeletePlayer.setText("Delete Player");
        btnDeletePlayer.setBackground(new Color(221, 160, 221));
        btnDeletePlayer.setForeground(Color.WHITE);
        btnDeletePlayer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnDeletePlayerActionPerformed(evt);
            }
        });
    
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnMainMenu, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDeletePlayerName, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDeletePlayer, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMainMenu)
                    .addComponent(txtDeletePlayerName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeletePlayer))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                .addContainerGap())
        );
    
        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnMainMenuActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnMainMenuActionPerformed
        
        this.setVisible(false);
        Tetris.showStartup();
        
    }//GEN-LAST:event_btnMainMenuActionPerformed

    public void addPlayer(String playerName, int score)
    {
        tm.addRow(new Object[] {playerName, score});
        
        this.setVisible(true);
    }
            

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton btnMainMenu;
    private JScrollPane jScrollPane1;
    private JTable leaderboard;
    // End of variables declaration//GEN-END:variables

    public void updateLeaderboard(DatabaseManager dbManager) {
        tm.setRowCount(0); // Hapus semua baris yang ada
    
        try {
            // Ambil data leaderboard terbaru dari database
            ArrayList<String[]> leaderboardData = dbManager.getLeaderboard();
    
            // Tambahkan data baru ke tabel
            for (String[] data : leaderboardData) {
                tm.addRow(data);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private void loadCustomFont() {
        try {
            // Ganti dengan path yang sesuai di mana Anda menyimpan file font Poppins
            Font poppinsFont = Font.createFont(Font.TRUETYPE_FONT, new File("res/fonts/Poppins/Poppins-Medium.ttf"));
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(poppinsFont);
            
            // Mengatur font untuk komponen
            Font poppins = poppinsFont.deriveFont(12f); // Ukuran font 12
            btnMainMenu.setFont(poppins);
            btnDeletePlayer.setFont(poppins);
            leaderboard.setFont(poppins);
            // Anda bisa mengatur font untuk komponen lain di sini
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
    }


    

}