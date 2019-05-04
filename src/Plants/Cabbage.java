package Plants;

import javafx.scene.image.Image;

public class Cabbage extends Plant {
    public Cabbage(double weight, int eatingRank) {
        super(weight, eatingRank);
    }

    public Image getImageLeft() {
        Image image = new Image("Resources/kabotshy.png", 50, 50, true, true);
        return  image;
    }

    public Image getImageRight() {
        Image image = new Image("Resources/cabbageRight.jpg", 50, 50, true, true);
        return image;
    }

}
