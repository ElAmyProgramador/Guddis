package entity;

// abstracto para player, enemy, ... y otros

import java.awt.image.BufferedImage;

public class Entity {
    public int x, y; // posicion de la entidad
    public int speed; // velocidad
    
    // texturas
    public BufferedImage up1, up2, up3;
    public String direction;
}