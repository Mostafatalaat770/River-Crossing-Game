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
    OriginatorScore originatorScore = new OriginatorScore();
    CareTakerScore careTakerScore = new CareTakerScore();

    private List<ICrosser> leftCrossers;
    private List<ICrosser> rightCrossers;
    private int score;

    public void createHistory(List<ICrosser> leftCrossers, List<ICrosser> rightCrossers, int score) {
        originatorLeft.setState(new ArrayList<>(leftCrossers));
        originatorRight.setState(new ArrayList<>(rightCrossers));
        originatorScore.setState(score);

        careTakerLeft.add(originatorLeft.saveStateToMemento());
        careTakerRight.add(originatorRight.saveStateToMemento());
        careTakerScore.add(originatorScore.saveStateToMemento());
    }

    public void undo() {

        originatorLeft.getStateFromMemento(careTakerLeft.undo());
        originatorRight.getStateFromMemento(careTakerRight.undo());
        originatorScore.getStateFromMemento(careTakerScore.undo());

        leftCrossers = originatorLeft.getState();
        rightCrossers = originatorRight.getState();
        score = originatorScore.getState();
    }

    public void redo() {
        originatorLeft.getStateFromMemento(careTakerLeft.redo());
        originatorRight.getStateFromMemento(careTakerRight.redo());
        originatorScore.getStateFromMemento(careTakerScore.redo());

        leftCrossers = originatorLeft.getState();
        rightCrossers = originatorRight.getState();
        score = originatorScore.getState();
    }

    public void clear() {
        originatorLeft = new OriginatorLeft();
        careTakerLeft = new CareTakerLeft();

        originatorRight = new OriginatorRight();
        careTakerRight = new CareTakerRight();
        originatorScore = new OriginatorScore();
        careTakerScore = new CareTakerScore();
    }
    public boolean canRedo() {
        return careTakerScore.canRedo();
    }

    public boolean canUndo() {
        return careTakerScore.canUndo();
    }

    public List<ICrosser> getLeftCrossers() {
        return leftCrossers;
    }

    public List<ICrosser> getRightCrossers() {
        return rightCrossers;
    }

    public int getScore() {
        return score;
    }
}
