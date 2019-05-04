package Animals.Herbivores;

import Animals.Animal;
import javafx.scene.image.Image;

public abstract class Herbivore extends Animal {
    public Herbivore(double weight, int eatingRank) {
        super(weight, eatingRank);
    }

    public abstract Image getImageLeft();

    public abstract Image getImageRight();
}
