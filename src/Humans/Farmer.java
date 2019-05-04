package Humans;

import javafx.scene.image.Image;

public class Farmer extends Human {

    public Farmer(double weight, int eatingRank) {
        super(weight, eatingRank);
    }

    public Image getImageLeft() {
        return new Image("Resources/farmerLeft.png", 150, 150, true, true);
    }

    public Image getImageRight() {
        return new Image("Resources/farmerRight.png", 150, 150, true, true);
    }

}
