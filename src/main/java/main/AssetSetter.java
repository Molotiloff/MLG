package main;

import object.Door;
import object.Key;
import object.Trofy;

public class AssetSetter {

    GamePanel gamepanel;

    public AssetSetter(GamePanel gamepanel){
        this.gamepanel = gamepanel;
    }

    public void setObject(){
        gamepanel.obj[0] = new Key("green key");
        gamepanel.obj[0].worldX = 7 * gamepanel.tileSize;
        gamepanel.obj[0].worldY = 14 * gamepanel.tileSize;

        gamepanel.obj[1] = new Key("gold key");
        gamepanel.obj[1].worldX = 5 * gamepanel.tileSize;
        gamepanel.obj[1].worldY = 18 * gamepanel.tileSize;

        gamepanel.obj[2] = new Key("purple key");
        gamepanel.obj[2].worldX = 15 * gamepanel.tileSize;
        gamepanel.obj[2].worldY = 6 * gamepanel.tileSize;

        gamepanel.obj[3] = new Door("green door");
        gamepanel.obj[3].worldX = 8 * gamepanel.tileSize;
        gamepanel.obj[3].worldY = 10 * gamepanel.tileSize;

        gamepanel.obj[4] = new Door("purple door");
        gamepanel.obj[4].worldX = 16 * gamepanel.tileSize;
        gamepanel.obj[4].worldY = 10 * gamepanel.tileSize;

        gamepanel.obj[5] = new Door("gold door");
        gamepanel.obj[5].worldX = 8 * gamepanel.tileSize;
        gamepanel.obj[5].worldY = 18 * gamepanel.tileSize;

        gamepanel.obj[6] = new Trofy();
        gamepanel.obj[6].worldX = 10 * gamepanel.tileSize;
        gamepanel.obj[6].worldY = 10 * gamepanel.tileSize;

    }

}
