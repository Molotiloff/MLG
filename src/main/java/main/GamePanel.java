package main;

import entity.Player;
import entity.Player2;
import object.SuperObject;
import tiles.TileManager;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.event.*;

import javax.swing.JPanel;


public class GamePanel extends JPanel implements Runnable{

    //screen
    final int originTileSize = 15;
    final int scale = 3;
    public final int tileSize = originTileSize * scale;
    public final int maxScreenCol = 21;
    public final int maxScreenRow = 21;
    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow;

    //World
    public final int maxWorldCol = 21;
    public final int maxWorldRow = 21;


    int FPS = 60;
    //Sys
    TileManager tileManager = new TileManager(this);
    KeyHandler keyHandler = new KeyHandler();
    KeyHandler2 keyHandler2 = new KeyHandler2();
    Thread gameTread;
    public CollisionChecker collisionChecker = new CollisionChecker(this);
    public AssetSetter assetSetter = new AssetSetter(this);
    Player player = new Player(this, keyHandler);
    Player2 player2 = new Player2(this, keyHandler2);

    //inventory
    public SuperObject obj[] = new SuperObject[10];
    public int hasPurpleKey = 0;
    public int hasGreenKey = 0;
    public int hasGoldKey = 0;

    //States
    public int gameState;
    public final int playState = 1;
    public final int pauseState = 2;
    public final int menuState = 3;

    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.addKeyListener(keyHandler2);
        this.setFocusable(true);

    }

    public void setupGame() {
        assetSetter.setObject();
    }

    public void startGameThread(){
        gameTread = new Thread(this);
        gameTread.start();
    }

    @Override
    public void run() {

        double drawInterval = (double) 1000000000 /FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long timer = 0;
        int drawCount = 0;


        while(gameTread != null){
            long currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if(delta >= 1) {
                update();
                repaint();
                delta--;
                drawCount++;
            }

            if(timer >= 1000000000){
                System.out.println("FPS: " +drawCount);
                drawCount = 0;
                timer = 0;

            }
        }
    }
    public void update(){

        player.update();
        player2.update();
    }
    public void paintComponent(Graphics g){

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        tileManager.draw(g2);

        for (SuperObject superObject : obj)
            if (superObject != null) {
                superObject.draw(g2, this);
            }

        player.draw(g2);
        player2.draw(g2);

        g2.dispose();
    }
}
