package object;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class Door extends SuperObject{
    public Door(String doorType) {
        name = "Key";
        try {
            switch (doorType) {
                case "purple":
                    image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/objects/purple_magic_door.png")));
                    break;
                case "green":
                    image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/objects/green_magic_door.png")));
                    break;
                case "gold":
                    image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/objects/gold_magic_door.png")));
                    break;
                default:
                    throw new IllegalArgumentException("Unknown key type: " + doorType);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
