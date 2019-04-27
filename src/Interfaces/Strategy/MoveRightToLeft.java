package Interfaces.Strategy;

import Interfaces.ICrosser;

import java.util.Iterator;
import java.util.List;

/**
 * @author Mostafa Talaat
 */
public class MoveRightToLeft implements Strategy {

    public void doMove(List<ICrosser> rightBankCrossers,
                       List<ICrosser> leftBankCrossers, List<ICrosser> boatRiders) {

        Iterator iteratorRight = rightBankCrossers.iterator();
        Iterator iteratorBoat = boatRiders.iterator();

        while (iteratorRight.hasNext()) {

            ICrosser crosserRight = (ICrosser) iteratorRight.next();
            ICrosser crosserBoat = (ICrosser) iteratorBoat.next();

            if (crosserRight.equals(crosserBoat)) {
                leftBankCrossers.add(crosserBoat);
                iteratorRight.remove();
                iteratorBoat.remove();
                iteratorBoat = boatRiders.iterator();
                iteratorRight = rightBankCrossers.iterator();
            }
        }
    }
}
