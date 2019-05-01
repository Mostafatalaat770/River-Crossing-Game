package Humans;

import Interfaces.ICrosser;

import java.awt.image.BufferedImage;
import java.io.IOException;

public abstract class Human implements ICrosser {
    private double weight;
    private int eatingRank;

    public Human(double weight, int eatingRank) {
        this.weight = weight;
        this.eatingRank = eatingRank;
    }

    public boolean canSail() {
        return true;
    }

    public double getWeight() {
        return weight;
    }

    public int getEatingRank() {
        return eatingRank;
    }

    public void getImages() throws IOException {

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
