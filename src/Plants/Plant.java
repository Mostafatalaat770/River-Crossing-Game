package Plants;

import Interfaces.ICrosser;

import java.awt.image.BufferedImage;

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

    public BufferedImage[] getImages() {
        return new BufferedImage[0];
    }

    public ICrosser makeCopy() {
        return null;
    }

    public String getLabelToBeShown() {
        return null;
    }

    public void setLabelToBeShown(String label) {

    }
}
