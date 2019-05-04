package Boat;

import javafx.scene.image.Image;

/**
 * @author Mostafa Talaat
 */
public class Boat {
    public Image getImage() {
        return new Image("Resources/wood plank.png", 200, 200, true, true);
    }

    private static Boat ourInstance = new Boat();

    public static Boat getInstance() {
        return ourInstance;
    }

}
