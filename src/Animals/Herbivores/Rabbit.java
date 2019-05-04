package Animals.Herbivores;

import javafx.scene.image.Image;

public class Rabbit extends Herbivore {
    public Rabbit(double weight, int eatingRank) {
        super(weight, eatingRank);
    }

    public Image getImageLeft() {
        return new Image("Resources/rabbitRight.png", 75, 75, true, true);
    }

    public Image getImageRight() {
        return new Image("Resources/Raboota.png", 75, 75, true, true);
    }

}
