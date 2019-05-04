package Animals.Carnivores;

import javafx.scene.image.Image;

public class Fox extends Carnivore {
    public Fox(double weight, int eatingRank) {
        super(weight, eatingRank);
    }

    public Image getImageLeft() {
        return new Image("Resources/foxLeft.png", 100, 100, true, true);
    }

    public Image getImageRight() {
        return new Image("Resources/foxRight.png", 100, 100, true, true);
    }
}
