package object;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class Trofy extends SuperObject {
    public Trofy() {
        name = "Trofy";
        try {
            flag = "trofy";
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/objects/simplified_cup.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
    }
}
