package Interfaces.Strategy;

import Interfaces.ICrosser;

import java.util.List;

/**
 * @author Mostafa Talaat
 */
public class Move {
    private Strategy strategy;

    public Move(Strategy strategy) {
        this.strategy = strategy;
    }

    public void doMove(List<ICrosser> crossers,
                       List<ICrosser> boatRiders) {
        strategy.doMove(crossers, boatRiders);
    }
}
