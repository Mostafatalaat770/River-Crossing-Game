package Plants;

import Interfaces.ICrosser;
import javafx.scene.image.Image;

public abstract class Plant implements ICrosser {

    private double weight;
    private int eatingRank;

    public Plant(double weight, int eatingRank) {
        this.weight = weight;
        this.eatingRank = eatingRank;
    }

    public boolean canSail() {
        return false;
    }

    public double getWeight() {
        return weight;
    }

    public int getEatingRank() {
        return eatingRank;
    }

    public void getImages() {

    }

    public ICrosser makeCopy() {
        return null;
    }

    public String getLabelToBeShown() {
        return null;
    }

    public void setLabelToBeShown(String label) {

    }

    public abstract Image getImageLeft();

    public abstract Image getImageRight();
}
