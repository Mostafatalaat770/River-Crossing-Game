package Animals.Carnivores;

import javafx.scene.image.Image;

public class Fox extends Carnivore {
    public Fox(double weight, int eatingRank) {
        super(weight, eatingRank);
    }

    public Image getImageLeft() {
        Image image = new Image("Resources/foxLeft.png", 100, 100, true, true);
        return  image;
    }

    public Image getImageRight() {
        Image image = new Image("Resources/foxRight.png", 100, 100, true, true);
        return image;
    }
}
