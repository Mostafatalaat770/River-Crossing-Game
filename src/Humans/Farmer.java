package Humans;

import javafx.scene.image.Image;

public class Farmer extends Human {

    public Farmer(double weight, int eatingRank) {
        super(weight, eatingRank);
    }
public Image getImage(){
    Image image = new Image("Resources/farmerLeft.png", 150, 150, true, true);
        return  image;
}

}
