package Interfaces.Strategy;

import Interfaces.ICrosser;

import java.util.List;

/**
 * @author Mostafa Talaat
 */
public interface Strategy {
    void doMove(List<ICrosser> crossers,
                List<ICrosser> boatRiders);
}
