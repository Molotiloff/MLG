package entity;

import main.GamePanel;
import main.KeyHandler2;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Player2 extends Entity{

    GamePanel gamePanel;
    KeyHandler2 keyHandler;

    public Player2(GamePanel gamePanel, KeyHandler2 keyHandler){

        this.gamePanel = gamePanel;
        this.keyHandler = keyHandler;

        solidArea = new Rectangle();
        solidArea.x = 14;
        solidArea.y = 5;
        solidArea.width = 26;
        solidArea.height = 45;

        setDefaultValues();
        getPlayerImage();
    }
    public  void setDefaultValues(){

        worldX = 600;
        worldY = 600;
        speed = 4;
        direction = "down";

    }

    public void getPlayerImage(){
        try {

            up1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/charcter2_back1.png")));
            up2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/charcter2_back2.png")));
            down1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/character2_front1.png")));
            down2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/character2_front2.png")));
            left1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/character2_to_left1.png")));
            left2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/character2_to_left2.png")));
            right1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/character2_to_right1.png")));
            right2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/character2_to_right2.png")));

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void update(){

        if(keyHandler.upPressed || keyHandler.downPressed ||
        keyHandler.rightPressed || keyHandler.leftPressed){
            if(keyHandler.upPressed){
                direction = "up";
            }
            else if(keyHandler.downPressed){
                direction = "down";
            }
            else if(keyHandler.leftPressed){
                direction = "left";
            }
            else {
                direction = "right";
            }

            //checking col
            collisionOn = false;
            gamePanel.collisionChecker.checkTile(this);

            if(!collisionOn){
                switch (direction){
                    case "up": worldY -= speed; break;
                    case "down": worldY += speed; break;
                    case "left": worldX -= speed; break;
                    case "right": worldX += speed; break;
                }
            }

            spriteCounter++;
            if(spriteCounter > 10){
                if(spriteNum == 1){
                    spriteNum = 2;
                }
                else if(spriteNum == 2){
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }

    }

    public void draw(Graphics2D g2){

        BufferedImage image = null;

        switch (direction){
            case "up":
                if(spriteNum == 1){
                image = up1;
                }
                if (spriteNum == 2){
                    image = up2;
                }
                break;
            case "down":
                if(spriteNum == 1){
                    image = down1;
                }
                if (spriteNum == 2){
                    image = down2;
                }
                break;
            case "left":
                if(spriteNum == 1){
                    image = left1;
                }
                if (spriteNum == 2){
                    image = left2;
                }
                break;
            case "right":
                if(spriteNum == 1){
                    image = right1;
                }
                if (spriteNum == 2){
                    image = right2;
                }
                break;
        }

        g2.drawImage(image, worldX, worldY, gamePanel.tileSize, gamePanel.tileSize, null);

    }


}
