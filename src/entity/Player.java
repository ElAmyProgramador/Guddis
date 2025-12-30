package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import main.GamePannel;
import main.KeysHandler;

public class Player extends Entity {
    GamePannel gp;
    KeysHandler keyH;
    
    public Player(GamePannel gp, KeysHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
        this.setDefaultValues();
    }
    
    public void setDefaultValues() {
        x = 100;
        y = 100;
        speed = 4;
    }
    
    public void update() {
        if(keyH.upPressed == true) {
            this.y -= speed;
        } else if (keyH.downPressed == true) {
            this.y += speed;
        } else if (keyH.leftPressed == true) {
            this.x -= speed;
        } else if (keyH.rightPressed == true) {
            this.x += speed;
        }
    }
    
    public void draw(Graphics2D g2) {
        g2.setColor(Color.WHITE);
        g2.fillRect(this.x, this.y, gp.tileSize, gp.tileSize);
    }
}