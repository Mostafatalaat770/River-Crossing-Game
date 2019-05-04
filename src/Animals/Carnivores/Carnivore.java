package Animals.Carnivores;

import Animals.Animal;
import javafx.scene.image.Image;

public abstract class Carnivore extends Animal {

    public Carnivore(double weight, int eatingRank) {
        super(weight, eatingRank);
    }

    public abstract Image getImageLeft();

    public abstract Image getImageRight();
}
