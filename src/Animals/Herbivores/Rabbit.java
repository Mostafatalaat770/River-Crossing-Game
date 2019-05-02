package Animals.Herbivores;

import javafx.scene.image.Image;

public class Rabbit extends Herbivore {
    public Rabbit(double weight, int eatingRank) {
        super(weight, eatingRank);
    }
    public Image getImage(){
        Image image = new Image("Resources/Raboota.png", 75, 75, true, true);
        return  image;
    }
}
