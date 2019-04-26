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

    public void doMove(List<ICrosser> rightBankCrossers,
                       List<ICrosser> leftBankCrossers, List<ICrosser> boatRiders) {
        strategy.doMove(rightBankCrossers, leftBankCrossers, boatRiders);
    }
}
