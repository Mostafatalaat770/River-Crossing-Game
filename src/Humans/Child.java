package Humans;

import javafx.scene.image.Image;

public class Child extends Human {

    public Child(double weight, int eatingRank) {
        super(weight, eatingRank);
    }

    public Image getImageLeft() {
        return new Image("Resources/childLeft.png", 75, 75, true, true);
    }

    public Image getImageRight() {
        return new Image("Resources/childRight.png", 75, 75, true, true);

    }
}
