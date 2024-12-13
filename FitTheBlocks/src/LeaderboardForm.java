import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

public class LeaderboardForm extends JFrame {

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

        btnMainMenu = new JButton();
        jScrollPane1 = new JScrollPane();
        leaderboard = new JTable();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        btnMainMenu.setText("Main Menu");
        btnMainMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnMainMenuActionPerformed(evt);
            }
        });

        leaderboard.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                " Player", " Score"
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

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnMainMenu, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnMainMenu)
                .addPreferredGap(ComponentPlacement.RELATED)
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
}