package main;

import object.Key;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

public class UI {
    GamePanel gamePanel;
    Font arial_40;
    BufferedImage keyImage;
    public boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    public boolean gameFinished = false;
    private Image gifImage;

    double playTime;
    DecimalFormat decimalFormat = new DecimalFormat("#0.00");


    public UI(GamePanel gamePanel){
        this.gamePanel = gamePanel;

        arial_40 = new Font("Arial", Font.PLAIN, 40);
        Key key = new Key("keys");
        keyImage = key.image;

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        gifImage = toolkit.getImage("congratulation.gif");
        MediaTracker tracker = new MediaTracker(gamePanel);
        tracker.addImage(gifImage, 0);
        try {
            tracker.waitForAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void showMessage(String text){

        message = text;
        messageOn = true;
    }

    public void draw(Graphics2D g2){

        if(gameFinished){
            System.out.println("finish");
            g2.drawImage(gifImage, gamePanel.tileSize*2,gamePanel.tileSize*3, gamePanel.tileSize, gamePanel.tileSize, null);
        }
        else {
            g2.setFont(arial_40);
            g2.setColor(Color.WHITE);
            g2.drawImage(keyImage, gamePanel.tileSize/2, gamePanel.tileSize/2, gamePanel.tileSize, gamePanel.tileSize, null);
            g2.drawString("x "+ gamePanel.keys, 75, 55);

            //time
            playTime +=(double)1/60;
            g2.drawString("Time: "+decimalFormat.format(playTime), gamePanel.tileSize*16, gamePanel.tileSize*1 );

            //messages
            if(messageOn == true){
                g2.setFont(g2.getFont().deriveFont(30F));
                g2.drawString(message, gamePanel.tileSize/2, gamePanel.tileSize*3);

                messageCounter++;

                if(messageCounter > 120){
                    messageCounter = 0;
                    messageOn = false;
                }
            }
        }
    }
}
