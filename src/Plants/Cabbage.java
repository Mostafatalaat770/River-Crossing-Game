package Plants;

import javafx.scene.image.Image;

public class Cabbage extends Plant {
    public Cabbage(double weight, int eatingRank) {
        super(weight, eatingRank);
    }
    public Image getImage(){
        Image image=new Image("Resources/cabbage.jpg",100,100,true,true);
        return  image;
    }
}
