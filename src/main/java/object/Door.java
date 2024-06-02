package object;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class Door extends SuperObject{
    public Door(String objType) {
        name = "Door";
        try {
            switch (objType) {
                case "purple door":
                    flag = "purple door";
                    image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/objects/purple_magic_door.png")));
                    break;
                case "green door":
                    flag = "green door";
                    image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/objects/green_magic_door.png")));
                    break;
                case "gold door":
                    flag = "gold door";
                    image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/objects/gold_magic_door.png")));
                    break;
                default:
                    throw new IllegalArgumentException("Unknown key type: " + objType);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
    }
}
