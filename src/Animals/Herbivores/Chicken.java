package Animals.Herbivores;

import javafx.scene.image.Image;

public class Chicken extends Herbivore {
    public Chicken(double weight, int eatingRank) {
        super(weight, eatingRank);
    }

    @Override
    public Image getImageLeft() {
        return null;
    }

    @Override
    public Image getImageRight() {
        return null;
    }

}
