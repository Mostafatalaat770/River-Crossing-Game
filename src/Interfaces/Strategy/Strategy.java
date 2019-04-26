package Interfaces.Strategy;

import Interfaces.ICrosser;

import java.util.List;

/**
 * @author Mostafa Talaat
 */
public interface Strategy {
    void doMove(List<ICrosser> rightBankCrossers,
                List<ICrosser> leftBankCrossers, List<ICrosser> boatRiders);
}
