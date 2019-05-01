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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Controller implements IRiverCrossingController {
    LevelCreator levelCreator = new LevelCreator();
    Level level;

    Boat boat = Boat.getInstance();
    List<ICrosser> leftBankCrossers = new ArrayList<>();
    List<ICrosser> rightBankCrossers = new ArrayList<>();
    List<ICrosser> boatRaiders = boat.getRaiders();
    boolean boatOnTheLeftBank;
    int score = 0;

    History history = new History();

    FileManagement fileManagement = new FileManagement();

    @FXML
    private Text instructionsText = new Text();

    public void handleLevel1ButtonClick(ActionEvent event) throws IOException {
        level = levelCreator.getLevel(1);
        instructionsText.setText(getInstructions()[0]);
        Parent LoginScreen = FXMLLoader.load(getClass().getResource("InstructionsPage.fxml"));
        Scene LoginScene = new Scene(LoginScreen);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(LoginScene);
        window.show();
    }

    public void handleLevel2ButtonClick(ActionEvent event) throws IOException {
        level = levelCreator.getLevel(2);
        instructionsText.setText(getInstructions()[0]);
        Parent LoginScreen = FXMLLoader.load(getClass().getResource("InstructionsPage.fxml"));
        Scene LoginScene = new Scene(LoginScreen);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(LoginScene);
        window.show();
    }


    public void handleShowInstructionsButtonClick(ActionEvent event) {
        instructionsText.setText(getInstructions()[0]);
    }

    @Override
    public void newGame(ICrossingStrategy gameStrategy) {
        leftBankCrossers = level.getInitialCrossers();
        rightBankCrossers = boatRaiders = null;
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
}
