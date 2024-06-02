package object;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class Key extends SuperObject{

    public Key(String keyType) {
        name = "Key";
        try {
            switch (keyType) {
                case "purple":
                    image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/objects/purple_key.png")));
                    break;
                case "green":
                    image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/objects/green_key.png")));
                    break;
                case "gold":
                    image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/objects/gold_key.png")));
                    break;
                default:
                    throw new IllegalArgumentException("Unknown key type: " + keyType);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
