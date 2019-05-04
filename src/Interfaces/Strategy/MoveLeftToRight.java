package Interfaces.Strategy;

import Interfaces.ICrosser;

import java.util.Iterator;
import java.util.List;

/**
 * @author Mostafa Talaat
 */
public class MoveLeftToRight implements Strategy {

    public void doMove(List<ICrosser> crossers, List<ICrosser> boatRiders) {

        Iterator boatIter = boatRiders.iterator();

        while (boatIter.hasNext()) {
            ICrosser crosser = (ICrosser) boatIter.next();
            crossers.add(crosser);
            boatRiders.remove(crosser);
            boatIter = boatRiders.iterator();
        }
    }

}
