package object;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class Key extends SuperObject{

    public Key(String objType) {
        name = "Key";
        try {
            switch (objType) {
                case "purple key":
                    flag = "purple key";
                    image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/objects/purple_key.png")));
                    break;
                case "green key":
                    flag = "green key";
                    image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/objects/green_key.png")));
                    break;
                case "gold key":
                    flag = "gold key";
                    image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/objects/gold_key.png")));
                    break;
                default:
                    throw new IllegalArgumentException("Unknown key type: " + objType);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        solidArea.x = 5;
    }

}
