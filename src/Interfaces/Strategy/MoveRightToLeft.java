package Interfaces.Strategy;

import Interfaces.ICrosser;

import java.util.List;

/**
 * @author Mostafa Talaat
 */
public class MoveRightToLeft implements Strategy {

    public void doMove(
            List<ICrosser> crossers, List<ICrosser> boatRiders) {

        crossers.addAll(boatRiders);
        boatRiders.clear();
    }
}
