package Animals.Carnivores;

import javafx.scene.image.Image;

public class Lion extends Carnivore {

    public Lion(double weight, int eatingRank) {
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
