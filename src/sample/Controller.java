package sample;

import Boat.Boat;
import Files.FileManagement;
import Interfaces.Factory.LevelCreator;
import Interfaces.ICrosser;
import Interfaces.ICrossingStrategy;
import Interfaces.IRiverCrossingController;
import Interfaces.Memento.History;
import Interfaces.Strategy.Move;
import Interfaces.Strategy.MoveLeftToRight;
import Interfaces.Strategy.MoveRightToLeft;
import Levels.Level;

import java.util.ArrayList;
import java.util.List;

public class Controller implements IRiverCrossingController {
    public LevelCreator levelCreator = new LevelCreator();
    public Level level;

    public Boat boat = Boat.getInstance();
    public List<ICrosser> leftBankCrossers = new ArrayList<>();
    public List<ICrosser> rightBankCrossers = new ArrayList<>();
    public List<ICrosser> boatRaiders = boat.getRaiders();
    public boolean boatOnTheLeftBank;
    public int score = 0;
    public int index;


    public History history = new History();

    public FileManagement fileManagement = new FileManagement();

    @Override
    public void newGame(ICrossingStrategy gameStrategy) {
        leftBankCrossers = level.getInitialCrossers();
        rightBankCrossers = boatRaiders = new ArrayList<>();
        boatOnTheLeftBank = true;
    }

    @Override
    public void resetGame() {
        leftBankCrossers = level.getInitialCrossers();
        rightBankCrossers = boatRaiders = null;
        boatOnTheLeftBank = true;
    }

    @Override
    public String[] getInstructions() {
        return level.getInstructions();
    }

    @Override
    public List<ICrosser> getCrossersOnRightBank() {
        return rightBankCrossers;
    }

    @Override
    public List<ICrosser> getCrossersOnLeftBank() {
        return leftBankCrossers;
    }

    @Override
    public boolean isBoatOnTheLeftBank() {
        return boatOnTheLeftBank;
    }

    @Override
    public int getNumberOfSails() {
        return score;
    }

    @Override
    public boolean canMove(List<ICrosser> crossers, boolean fromLeftToRightBank) {
        for (ICrosser raider : boatRaiders) {
            if (!raider.canSail()) {
                return false;
            }
        }
        return true;

    }

    @Override
    public void doMove(List<ICrosser> crossers, boolean fromLeftToRightBank) {
        if (canMove(crossers, fromLeftToRightBank)) {
            history.createHistory(leftBankCrossers, rightBankCrossers, score);
            Move move;
            if (fromLeftToRightBank) {
                move = new Move(new MoveLeftToRight());
                move.doMove(crossers, boatRaiders);
            } else {
                move = new Move(new MoveRightToLeft());
                move.doMove(crossers, boatRaiders);
            }
            score++;
        } else {
            //TODO : alert "wrong move"
        }
    }

    @Override
    public boolean canUndo() {
        return (history.canUndo());
    }

    @Override
    public boolean canRedo() {
        return history.canRedo();
    }

    @Override
    public void undo() {
        if (canUndo()) {
            history.undo();
            leftBankCrossers = history.getLeftCrossers();
            rightBankCrossers = history.getRightCrossers();
            boatRaiders = null;
            score = history.getScore();
        } else {
            //TODO: disable undo button
        }
    }

    @Override
    public void redo() {
        if (canRedo()) {
            history.undo();
            leftBankCrossers = history.getLeftCrossers();
            rightBankCrossers = history.getRightCrossers();
            boatRaiders = null;
            score = history.getScore();
        } else {
            //TODO: disable undo button
        }
    }

    @Override
    public void saveGame() {
        fileManagement.save(rightBankCrossers, leftBankCrossers, boatRaiders, score);
    }

    @Override
    public void loadGame() {
        fileManagement.load();
        leftBankCrossers = fileManagement.getLeftBank();
        rightBankCrossers = fileManagement.getRightBank();
        boatRaiders = fileManagement.getBoat();
        score = fileManagement.getScore();
    }

    @Override
    public List<List<ICrosser>> solveGame() {
        return null;
    }

    public int detectHitBox(List<ICrosser> initialCrossers, double x, double y) {
        int i;
        for (i = 0; i < initialCrossers.size(); i++) {
            if ((x >= 100 && x <= 175) && (y >= 100 + (i * 500 / initialCrossers.size()) && y <= 150 + (i * 500 / initialCrossers.size()))) {
                return i;
            }
        }

        for (i = 0; i < initialCrossers.size(); i++) {
            if ((x >= 900 && x <= 975) && (y >= 100 + (i * 500 / initialCrossers.size()) && y <= 150 + (i * 500 / initialCrossers.size()))) {
                return i + initialCrossers.size();
            }
        }
        return -1;

    }
}


