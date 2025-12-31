package main;

import entity.Player;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class GamePannel extends JPanel implements Runnable {
    // config de panel
    final int originalTileSize = 16; // 16x16
    final int scale = 3;
    public final int tileSize = originalTileSize * scale; // 48x48
    final int maxScreenColumn = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenColumn; // 768
    final int screenHeight = tileSize * maxScreenRow; // 576
    int FPS = 60;
    
    Thread gameThread;
    KeysHandler keyH = new KeysHandler();
    Player j = new Player(this,keyH);
    
    // posicion del jugadro por default
    //int playerX = 100;
    //int playerY = 100;
    //int playerSpeed = 4;
    
    public GamePannel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }
    
    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }
    
    @Override
    public void run() {
        double drawInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        // loop
        while (gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;
            if (delta >= 1) {
                update();
                repaint();
                delta--;
            }
        }
    }
    
    public void update() {
        j.update();
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        j.draw(g2);
        g2.dispose();
    }
}