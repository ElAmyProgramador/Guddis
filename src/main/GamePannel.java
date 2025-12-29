package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class GamePannel extends JPanel implements Runnable {
    // config de panel
    final int originalTileSize = 16; // 16x16
    final int scale = 3;
    final int tileSize = originalTileSize * scale; // 48x48
    final int maxScreenColumn = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenColumn; // 768
    final int screenHeight = tileSize * maxScreenRow; // 576
    
    Thread gameThread;
    
    public GamePannel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
    }
    
    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }
    
    @Override
    public void run() {
        // loop
        while (gameThread != null) {
            // actualiza info
            update();
            // dibuja
            repaint();
        }
    }
    
    public void update() {
        //
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.WHITE);
        g2.fillRect(100, 100, tileSize, tileSize);
        g2.dispose();
    }
}