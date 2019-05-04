package Humans;

import javafx.scene.image.Image;

public class Child extends Human {

    public Child(double weight, int eatingRank) {
        super(weight, eatingRank);
    }

    public Image getImageLeft() {
        return new Image("Resources/kabotshy.png", 50, 50, true, true);
    }

    public Image getImageRight() {
        return new Image("Resources/cabbageRight.jpg", 50, 50, true, true);

    }
}
