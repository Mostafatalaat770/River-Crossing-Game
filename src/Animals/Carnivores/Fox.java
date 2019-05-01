package Animals.Carnivores;

import javafx.scene.image.Image;

public class Fox extends Carnivore {
    public Fox(double weight, int eatingRank) {
        super(weight, eatingRank);
    }
    public Image getImage(){
        Image image=new Image("Resources/foxyjpg.jpg",100,100,true,true);
        return  image;
    }
}
