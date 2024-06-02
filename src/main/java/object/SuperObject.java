package object;

import main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;

public class SuperObject {

    public BufferedImage image;
    public String name;
    public boolean collision = false;
    public int worldX, worldY;
    public Rectangle solidArea = new Rectangle(0,0,48,48);
    public int solidAreaDefaultX = 0;
    public int solidAreaDefaultY = 0;
    public String flag;


    public void draw(Graphics2D g2, GamePanel gamePanel) {
        for (int i = 0; i < gamePanel.obj.length; i++) {
            if (gamePanel.obj[i] != null) {
                int worldX = gamePanel.obj[i].worldX;
                int worldY = gamePanel.obj[i].worldY;

                // Рисуем объект на экране
                g2.drawImage(gamePanel.obj[i].image, worldX, worldY, gamePanel.tileSize, gamePanel.tileSize, null);
            }
        }
    }
}
