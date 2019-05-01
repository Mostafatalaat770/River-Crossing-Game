package Humans;

import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Farmer extends Human {

    public Farmer(double weight, int eatingRank) {
        super(weight, eatingRank);
    }
public Image getImage(){
        Image image=new Image("Resources/Farmer left.jpg",100,100,true,true);
        return  image;
}

}
