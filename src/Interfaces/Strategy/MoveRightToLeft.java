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

        ICrosser crosserBoat = (ICrosser) iteratorBoat.next();

        while (iteratorRight.hasNext()) {

            ICrosser crosserRight = (ICrosser) iteratorRight.next();

            if (crosserRight.equals(crosserBoat)) {
                leftBankCrossers.add(crosserBoat);
                iteratorRight.remove();
                iteratorBoat.remove();
                try {
                    crosserBoat = (ICrosser) iteratorBoat.next();
                } catch (Exception e) {
                    break;
                }
                iteratorRight = rightBankCrossers.iterator();
            }
        }
    }
}
