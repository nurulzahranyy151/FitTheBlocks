package ftbGames;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class StartupForm extends JFrame {

    private JButton btnStart;
    private JButton btnLeaderboard;
    private JButton btnQuit;
    private JLabel lblTitle;
    private Font customFont;
    // private Image backgroundImg;

    public StartupForm() {
        setTitle("Fit The Blocks!");
        initComponents();
        // loadCustomFont();
    }

    private void initComponents() {

        try {
            File fontFile = new File("FitTheBlocks/res/fonts/game_over/game_over.ttf"); // Ganti dengan path font Anda
            customFont = Font.createFont(Font.TRUETYPE_FONT, fontFile);
            customFont = customFont.deriveFont(36f);  // Mengatur ukuran font (36)
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
            customFont = new Font("Arial", Font.BOLD, 36); // Default font jika gagal memuat font
        }

        // Konfigurasi frame
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("ftbGames");
        setSize(800, 600); // Ukuran frame tetap 800x600
        setResizable(false);
        setLocationRelativeTo(null); // Pusatkan frame di layar
        getContentPane().setBackground(new Color(229, 217, 242)); // Warna background

        // Mengatur layout manager sebagai GridBagLayout
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        lblTitle = new JLabel("FIT THE BLOCKS", JLabel.CENTER);
        lblTitle.setFont(customFont);
        lblTitle.setForeground(new Color(255, 255, 255));

        // loadBackgroundImg();

        // Inisialisasi tombol Start Game
        btnStart = new JButton("Start Game");
        configureButton(btnStart);

        // Inisialisasi tombol Leaderboard
        btnLeaderboard = new JButton("Leaderboard");
        configureButton(btnLeaderboard);

        // Inisialisasi tombol Quit
        btnQuit = new JButton("Quit");
        configureButton(btnQuit);

        // Tambahkan Action Listener ke tombol
        btnStart.addActionListener(evt -> btnStartActionPerformed(evt));
        btnLeaderboard.addActionListener(evt -> btnLeaderboardActionPerformed(evt));
        btnQuit.addActionListener(evt -> btnQuitActionPerformed(evt));

        // Menambahkan tombol Start Game ke layout
        gbc.gridx = 0; // Kolom ke-0
        gbc.gridy = 0; // Baris ke-0
        gbc.weightx = 1; // Memberi bobot horizontal
        gbc.weighty = 0; // Memberi bobot vertikal lebih kecil
        gbc.insets = new java.awt.Insets(10, 0, 10, 0); // Mengurangi jarak antar tombol
        gbc.anchor = GridBagConstraints.CENTER; // Posisikan di tengah
        add(btnStart, gbc);

        // Menambahkan tombol Leaderboard ke layout
        gbc.gridy = 1; // Baris ke-1
        add(btnLeaderboard, gbc);

        // Menambahkan tombol Quit ke layout
        gbc.gridy = 2; // Baris ke-2
        add(btnQuit, gbc);

        // headerPanel.setLayout(null);
        // headerPanel.setBounds(0, 0, 800, 600);
        // add(headerPanel);
    }

    JPanel headerPanel = new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
                
            Graphics2D g2d = (Graphics2D) g;

            // Menggambar gambar latar belakang pada header
            ImageIcon backgroundIcon = new ImageIcon("FitTheBlocks/res/img/tetrishd.png"); 
            Image backgroundImg = backgroundIcon.getImage();
            g.drawImage(backgroundImg, 0, 0, getWidth(), getHeight(), this);

            g2d.setFont(customFont);
            g2d.setColor(Color.WHITE); // Warna teks putih
            String title = "Fit The Blocks";
            g2d.drawString(title, (getWidth() - g2d.getFontMetrics().stringWidth(title)) / 2, 50);

        }
    };

    // Metode untuk mengatur properti tombol
    private void configureButton(JButton button) {
        button.setBackground(new Color(221, 160, 221)); // Warna ungu muda
        button.setForeground(Color.WHITE); // Warna teks putih
        button.setFocusPainted(false);
        button.setFont(new Font("Poppins", Font.BOLD, 14));
        button.setPreferredSize(new Dimension(200, 70));
    }

    private void btnStartActionPerformed(ActionEvent evt) {
        this.setVisible(false);
        Tetris.start(); // Pastikan class Tetris tersedia
    }

    private void btnLeaderboardActionPerformed(ActionEvent evt) {
        this.setVisible(false);
        Tetris.showLeaderboard(); // Pastikan class Tetris tersedia
    }

    private void btnQuitActionPerformed(ActionEvent evt) {
        System.exit(0); // tea
    }

}
