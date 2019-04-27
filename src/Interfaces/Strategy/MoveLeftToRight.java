package Interfaces.Strategy;

import Interfaces.ICrosser;

import java.util.Iterator;
import java.util.List;

/**
 * @author Mostafa Talaat
 */
public class MoveLeftToRight implements Strategy {

    public void doMove(List<ICrosser> rightBankCrossers,
                       List<ICrosser> leftBankCrossers, List<ICrosser> boatRiders) {

        Iterator iteratorLeft = leftBankCrossers.iterator();
        Iterator iteratorBoat = boatRiders.iterator();

        ICrosser crosserBoat = (ICrosser) iteratorBoat.next();

        while (iteratorLeft.hasNext()) {

            ICrosser crosserLeft = (ICrosser) iteratorLeft.next();

            if (crosserLeft.equals(crosserBoat)) {
                rightBankCrossers.add(crosserBoat);
                iteratorLeft.remove();
                iteratorBoat.remove();
                iteratorBoat = boatRiders.iterator();
                try {
                    crosserBoat = (ICrosser) iteratorBoat.next();
                } catch (Exception e) {
                    break;
                }
                iteratorLeft = leftBankCrossers.iterator();
            }
        }


    }
}
