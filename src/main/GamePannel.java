package main;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

public class GamePannel extends JPanel {
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
}