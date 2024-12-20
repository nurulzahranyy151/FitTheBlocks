package ftbGames;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.*;

import javax.swing.*;

public class GameForm extends JFrame
{
    private GameArea ga;
    private GameThread gt;
    
    public GameForm()
    {
        initComponents();
        ga = new GameArea(gameAreaPlaceholder, 10);
        ga.initBackgroundArray();
        this.add(ga);
        initControls();
        loadCustomFont();
    }
    
    private void initControls()
    {
        InputMap im = this.getRootPane().getInputMap();
        ActionMap am = this.getRootPane().getActionMap();
        
        im.put(KeyStroke.getKeyStroke("RIGHT"), "right");
        im.put(KeyStroke.getKeyStroke("LEFT"), "left");
        im.put(KeyStroke.getKeyStroke("UP"), "up");
        im.put(KeyStroke.getKeyStroke("DOWN"), "down");
        
        am.put("right", new AbstractAction(){
            @Override
            public void actionPerformed(ActionEvent e) {
                ga.moveBlockRight();
            }
        });
        
        am.put("left", new AbstractAction(){
            @Override
            public void actionPerformed(ActionEvent e) {
                ga.moveBlockLeft();
            }
        });
        
        am.put("up", new AbstractAction(){
            @Override
            public void actionPerformed(ActionEvent e) {
                ga.rotateBlock();
            }
        });
        
        am.put("down", new AbstractAction(){
            @Override
            public void actionPerformed(ActionEvent e) {
                ga.dropBlock();
            }
        });
    }
    
    public void startGame()
    {
        ga.initBackgroundArray();
       gt = new GameThread(ga, this);
       gt.start();
    }
    
    public void updateScore(int score)
    {
        scoreDisplay.setText("Score: " +score);
    }
    
    public void updateLevel(int level)
    {
        levelDisplay.setText("Level: " +level);
    }
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gameAreaPlaceholder = new JPanel();
        scoreDisplay = new JLabel();
        levelDisplay = new JLabel();
        btnMainMenu = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        this.getContentPane().setBackground(new Color(205, 193, 255));
        gameAreaPlaceholder.setBackground(new Color(205, 193, 255));
        gameAreaPlaceholder.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        gameAreaPlaceholder.setPreferredSize(new Dimension(200, 300));
        

        GroupLayout gameAreaPlaceholderLayout = new GroupLayout(gameAreaPlaceholder);
        gameAreaPlaceholder.setLayout(gameAreaPlaceholderLayout);
        gameAreaPlaceholderLayout.setHorizontalGroup(
            gameAreaPlaceholderLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 198, Short.MAX_VALUE)
        );
        gameAreaPlaceholderLayout.setVerticalGroup(
            gameAreaPlaceholderLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 298, Short.MAX_VALUE)
        );

        scoreDisplay.setText("Score: 0");

        levelDisplay.setText("Level: 1");

        btnMainMenu.setText("Main Menu");
        btnMainMenu.setFocusable(true);
        btnMainMenu.setForeground(Color.white);
        btnMainMenu.setBackground(new Color(221, 160, 221));
        btnMainMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnMainMenuActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(btnMainMenu, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(gameAreaPlaceholder, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(levelDisplay, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scoreDisplay, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(62, 62, 62))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(btnMainMenu)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(scoreDisplay)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(levelDisplay))
                    .addComponent(gameAreaPlaceholder, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnMainMenuActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnMainMenuActionPerformed
        
        gt.interrupt();
        this.setVisible(false);
        Tetris.showStartup();
        
    }

    private void loadCustomFont() {
        try {
            // Ganti dengan path yang sesuai di mana Anda menyimpan file font Poppins
            Font poppinsFont = Font.createFont(Font.TRUETYPE_FONT, new File("res/fonts/Poppins/Poppins-Medium.ttf"));
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(poppinsFont);
            
            // Mengatur font untuk komponen
            Font poppins = poppinsFont.deriveFont(12f); // Ukuran font 12
            levelDisplay.setFont(poppins);
            scoreDisplay.setFont(poppins);
            btnMainMenu.setFont(poppins);   
            // Anda bisa mengatur font untuk komponen lain di sini
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
    }

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton btnMainMenu;
    private JPanel gameAreaPlaceholder;
    private JLabel levelDisplay;
    private JLabel scoreDisplay;
    // End of variables declaration//GEN-END:variables
}