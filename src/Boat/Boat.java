package Boat;

import Interfaces.ICrosser;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mostafa Talaat
 */
public class Boat {
    public Image getImage() {
        Image image = new Image("Resources/wood plank.png", 200, 200, true, true);
        return image;
    }

    List<ICrosser> raiders = new ArrayList<>();
    private int capacity;
    private boolean full;
    private static Boat ourInstance = new Boat();

    private Boat() {
        capacity = 0;
        full = false;
    }

    public static Boat getInstance() {
        return ourInstance;
    }

    public static Boat getOurInstance() {
        return ourInstance;
    }

    public static void setOurInstance(Boat ourInstance) {
        Boat.ourInstance = ourInstance;
    }

    public List<ICrosser> getRaiders() {
        return raiders;
    }

    public void setRaiders(List<ICrosser> raiders) {
        this.raiders = raiders;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isFull() {
        return full;
    }

    public void setFull(boolean full) {
        this.full = full;
    }
}
