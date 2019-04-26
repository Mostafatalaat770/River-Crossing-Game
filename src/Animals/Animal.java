package Animals;

import Interfaces.ICrosser;

import java.awt.image.BufferedImage;

public abstract class Animal implements ICrosser {
    private double weight;
    private int eatingRank;

    public Animal(double weight, int eatingRank) {
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

    @Override
    public BufferedImage[] getImages() {
        return new BufferedImage[0];
    }

    @Override
    public ICrosser makeCopy() {
        return null;
    }

    @Override
    public String getLabelToBeShown() {
        return null;
    }

    @Override
    public void setLabelToBeShown(String label) {

    }
}
