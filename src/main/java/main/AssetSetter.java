package main;

import object.Key;

public class AssetSetter {

    GamePanel gamepanel;

    public AssetSetter(GamePanel gamepanel){
        this.gamepanel = gamepanel;
    }

    public void setObject(){
        gamepanel.obj[0] = new Key();
        gamepanel.obj[0].worldX = 12 * gamepanel.tileSize;
        gamepanel.obj[0].worldY = 20 * gamepanel.tileSize;

        gamepanel.obj[1] = new Key();
        gamepanel.obj[0].worldX = 38 * gamepanel.tileSize;
        gamepanel.obj[0].worldY = 2 * gamepanel.tileSize;
    }

}
