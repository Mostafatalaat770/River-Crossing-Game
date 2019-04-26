package Interfaces;

import java.util.List;

/**
 * @author Mostafa Talaat
 */
public interface IRiverCrossingController {

    /**
     * this method initialize the controller with game strategy according
     * to the level
     *
     * @param gameStrategy
     */
    void newGame(ICrossingStrategy gameStrategy);

    /**
     * resets the game without changing the strategy
     */
    void resetGame();

    /**
     * @return the current strategy instructions if the user want to see
     * them
     */
    String[] getInstructions();

    /**
     * @return list of crossers on the right bank of the river
     */
    List<ICrosser> getCrossersOnRightBank();

    /**
     * @return list of crossers on the left bank of the river
     */
    List<ICrosser> getCrossersOnLeftBank();

    /**
     * @return determines whether the boat is on the left or on the right
     * bank of the river
     */
    boolean isBoatOnTheLeftBank();

    /**
     * @return returns the number of sails that the user have done so far
     */
    int getNumberOfSails();

    /**
     * @param crossers           crossers on the boat
     * @param fromLeftToRightBank boolean to inform the controller
     *                            with the direction of the current game
     * @return boolean if it is a valid move or not
     */
    boolean canMove(List<ICrosser> crossers, boolean
            fromLeftToRightBank);

    /**
     * this method used to perform the move if it is valid
     *
     *
     * @param crossers crossers on the boat to be moved to the other riverbank
     * @param fromLeftToRightBank
     */
    void doMove(List<ICrosser> crossers, boolean
            fromLeftToRightBank);

    /**
     * @return boolean providing that the undo action can be done or not
     */
    boolean canUndo();

    /**
     * @return boolean providing that the redo action can be done or not
     */
    boolean canRedo();

    /**
     * undo to the last game state
     */
    void undo();

    /**
     * redo the undo actions
     */
    void redo();

    /**
     * saves the game state
     * (left bank crossers, right bank crossers, number of done sails,
     * position of the boat)
     */
    void saveGame();

    /**
     * load the saved game state
     */
    void loadGame();

    /**
     * this function is bonus
     * it returns the boat riders starting from the beginning of the game
     * until the final solution to show the user the solution
     */
    List<List<ICrosser>> solveGame();
}