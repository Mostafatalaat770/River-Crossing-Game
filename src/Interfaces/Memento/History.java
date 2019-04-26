package Interfaces.Memento;

import Interfaces.ICrosser;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mostafa Talaat
 */
public class History {
    OriginatorLeft originatorLeft = new OriginatorLeft();
    CareTakerLeft careTakerLeft = new CareTakerLeft();

    OriginatorRight originatorRight = new OriginatorRight();
    CareTakerRight careTakerRight = new CareTakerRight();

    private List<ICrosser> leftCrossers;
    private List<ICrosser> rightCrossers;

    public void createHistory(List<ICrosser> leftCrossers, List<ICrosser> rightCrossers) {
        originatorLeft.setState(new ArrayList<>(leftCrossers));
        originatorRight.setState(new ArrayList<>(rightCrossers));

        careTakerLeft.add(originatorLeft.saveStateToMemento());
        careTakerRight.add(originatorRight.saveStateToMemento());
    }

    public void undo() {
        originatorLeft.getStateFromMemento(careTakerLeft.undo());
        originatorRight.getStateFromMemento(careTakerRight.undo());

        leftCrossers = originatorLeft.getState();
        rightCrossers = originatorRight.getState();
    }

    public void redo() {
        originatorLeft.getStateFromMemento(careTakerLeft.redo());
        originatorRight.getStateFromMemento(careTakerRight.redo());

        leftCrossers = originatorLeft.getState();
        rightCrossers = originatorRight.getState();
    }

    public List<ICrosser> getLeftCrossers() {
        return leftCrossers;
    }

    public List<ICrosser> getRightCrossers() {
        return rightCrossers;
    }
}
