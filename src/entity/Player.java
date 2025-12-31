package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePannel;
import main.KeysHandler;

public class Player extends Entity {
    GamePannel gp;
    KeysHandler keyH;
    
    public Player(GamePannel gp, KeysHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
        this.setDefaultValues();
        this.getPlayerImage();
    }
    
    public void setDefaultValues() {
        x = 100;
        y = 100;
        speed = 4;
        direction = "down";
    }
    
    public void getPlayerImage() {
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/player/proto_0001.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/proto_0002.png"));
            up3 = ImageIO.read(getClass().getResourceAsStream("/player/proto_0003.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void update() {
        if(keyH.upPressed == true) {
            this.y -= speed;
            direction = "up";
        } else if (keyH.downPressed == true) {
            this.y += speed;
            direction = "down";
        } else if (keyH.leftPressed == true) {
            this.x -= speed;
            direction = "left";
        } else if (keyH.rightPressed == true) {
            this.x += speed;
            direction = "right";
        }
    }
    
    public void draw(Graphics2D g2) {
        //g2.setColor(Color.WHITE);
        //g2.fillRect(this.x, this.y, gp.tileSize, gp.tileSize);
        BufferedImage img = null;
        switch (direction) {
            case "up" -> img = up1;
            case "down" -> img = up1;
            case "right" -> img = up2;
            case "left" -> img = up3;
        }
        g2.drawImage(img, x, y, gp.tileSize, gp.tileSize, null);
    }
}