package Animals.Herbivores;

import javafx.scene.image.Image;

public class Rabbit extends Herbivore {
    public Rabbit(double weight, int eatingRank) {
        super(weight, eatingRank);
    }
    public Image getImage(){
        Image image=new Image("Resources/rabbit.jpg",100,100,true,true);
        return  image;
    }
}
