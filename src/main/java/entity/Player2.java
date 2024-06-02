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
    public static boolean isNearTrofy;

    public Player2(GamePanel gamePanel, KeyHandler2 keyHandler){

        this.gamePanel = gamePanel;
        this.keyHandler = keyHandler;

        solidArea = new Rectangle();
        solidArea.x = 15;
        solidArea.y = 24;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 20;
        solidArea.height = 26;
        boolean isNeartrofy = false;


        setDefaultValues();
        getPlayerImage();
    }
    public  void setDefaultValues(){

        worldX = 800;
        worldY = 800;
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

            // check object collision
            int objIndex = gamePanel.collisionChecker.checkObject(this,true);
            pickUpObject(objIndex);

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

    public void pickUpObject(int i) {
        if (i != 9999) {
            String objectName = gamePanel.obj[i].flag;

            switch (objectName) {
                case "gold key":
                    gamePanel.hasGoldKey++;
                    gamePanel.keys++;
                    gamePanel.obj[i] = null;
                    gamePanel.ui.showMessage("You got a gold key!");
                    break;
                case "green key":
                    gamePanel.hasGreenKey++;
                    gamePanel.keys++;
                    gamePanel.obj[i] = null;
                    gamePanel.ui.showMessage("You got a green key!");
                    break;
                case "purple key":
                    gamePanel.hasPurpleKey++;
                    gamePanel.keys++;
                    gamePanel.obj[i] = null;
                    gamePanel.ui.showMessage("You got a purple key!");
                    break;
                case "gold door":
                    if (gamePanel.hasGoldKey > 0) {
                        gamePanel.obj[i] = null;
                        gamePanel.hasGoldKey--;
                        gamePanel.keys--;
                    }
                    else {
                        gamePanel.ui.showMessage("You need a gold key");
                    }
                    break;
                case "purple door":
                    if (gamePanel.hasPurpleKey > 0) {
                        gamePanel.obj[i] = null;
                        gamePanel.hasPurpleKey--;
                        gamePanel.keys--;
                    }
                    else {
                        gamePanel.ui.showMessage("You need a purple key");
                    }
                    break;
                case "green door":
                    if (gamePanel.hasGreenKey > 0) {
                        gamePanel.obj[i] = null;
                        gamePanel.hasGreenKey--;
                        gamePanel.keys--;
                    }
                    else {
                        gamePanel.ui.showMessage("You need a green key");
                    }
                    break;
                case "trofy":{
                    isNearTrofy = true;
                    if(Player.isNearTrofy == true){
                        //congarts
                        gamePanel.ui.gameFinished = true;
                    }
                    else{
                        gamePanel.ui.showMessage("You need your mate to take away the Trrofy!!");
                    }
                    break;
                }
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
