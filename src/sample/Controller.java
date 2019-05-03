package sample;

import Boat.Boat;
import Files.FileManagement;
import Interfaces.Factory.LevelCreator;
import Interfaces.ICrosser;
import Interfaces.ICrossingStrategy;
import Interfaces.IRiverCrossingController;
import Interfaces.Memento.History;
import Interfaces.Strategy.Move;
import Interfaces.Strategy.MoveRightToLeft;
import Levels.Level;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

public class Controller implements IRiverCrossingController {
    public LevelCreator levelCreator = new LevelCreator();
    public Level level;

    public Boat boat = Boat.getInstance();
    public List<ICrosser> leftBankCrossers = new ArrayList<>();
    public List<ICrosser> boatRaiders = new ArrayList<>(); //boat.getRaiders();
    public List<ICrosser> rightBankCrossers = new ArrayList<>();
    public boolean boatOnTheLeftBank;
    public int score = 0;
    public int index;


    public History history = new History();

    public FileManagement fileManagement = new FileManagement();

    @Override
    public void newGame(ICrossingStrategy gameStrategy) {
        leftBankCrossers = level.getInitialCrossers();
        rightBankCrossers = new ArrayList<>();
        boatRaiders = new ArrayList<>();
        boatOnTheLeftBank = true;
    }

    @Override
    public void resetGame() {
        leftBankCrossers = level.getInitialCrossers();
        rightBankCrossers.clear();
        boatRaiders.clear();
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
        for (ICrosser crosser : crossers) {
            if (crosser.canSail()) {
                return true;
            }
        }
        return false;

    }

    @Override
    public void doMove(List<ICrosser> crossers, boolean fromLeftToRightBank) {

            history.createHistory(leftBankCrossers, rightBankCrossers, score);
            Move move;
            if (fromLeftToRightBank) {
                move = new Move(new MoveRightToLeft());
                move.doMove(rightBankCrossers, boatRaiders);
                boatOnTheLeftBank = false;
            } else {
                move = new Move(new MoveRightToLeft());
                move.doMove(leftBankCrossers, boatRaiders);
                boatOnTheLeftBank = true;
            }

            score++;
            //TODO : alert "wrong move"

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
            boatRaiders.clear();
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
            if ((x >= 100 && x <= 175) && (y >= 150 + (i * 500 / initialCrossers.size()) && y <= 200 + (i * 500 / initialCrossers.size()))) {
                return i;
            }
        }

        for (i = 0; i < initialCrossers.size(); i++) {
            if ((x >= 900 && x <= 975) && (y >= 150 + (i * 500 / initialCrossers.size()) && y <= 200 + (i * 500 / initialCrossers.size()))) {
                return i + initialCrossers.size();
            }
        }
        return -1;
    }

    public void refreshAndDraw(List<ICrosser> rightBankCrossers, List<ICrosser> leftBankCrossers, GraphicsContext gc, Controller controller, Image image, boolean boatOnTheLeftBank, Image boatImage, List<ICrosser> boatRaiders) {
        gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
        gc.drawImage(image, 0, 0);
        double y = 150;
        for (ICrosser crosser : leftBankCrossers) {
            gc.drawImage(crosser.getImage(), 100, y);
            y += 500 / controller.level.getInitialCrossers().size();
        }
        y = 150;
        for (ICrosser crosser : rightBankCrossers) {
            gc.drawImage(crosser.getImage(), 900, y);
            y += 500 / controller.level.getInitialCrossers().size();
        }
        if (boatOnTheLeftBank == true) {
            y = 350;
            gc.drawImage(boatImage, 350, 350);
            for (ICrosser crosser : boatRaiders) {
                gc.drawImage(crosser.getImage(), y, 380 - crosser.getImage().getHeight());
                y += 100;
            }
        } else if (boatOnTheLeftBank == false) {
            y = 550;
            gc.drawImage(boatImage, 550, 350);
            for (ICrosser crosser : boatRaiders) {
                gc.drawImage(crosser.getImage(), y, 380 - crosser.getImage().getHeight());
                y += 100;
            }
        }
    }

    public void moveThisDude(List<ICrosser> crossers, List<ICrosser> boatRaiders, int index) {
        if (boatRaiders.size() < 2) {
            boatRaiders.add(crossers.get(index));
            crossers.remove(index);
        }
    }

    public void returnThisDude(List<ICrosser> crossers, List<ICrosser> boatRaiders, int index) {
        for (ICrosser crosser : boatRaiders) {
            crossers.add(crosser);
            boatRaiders.remove(crosser);
        }
    }
}


