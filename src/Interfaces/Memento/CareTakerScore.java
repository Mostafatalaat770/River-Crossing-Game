package Interfaces.Memento;

import java.util.Stack;

/**
 * @author Mostafa Talaat
 */
public class CareTakerScore {
    private Stack<MementoScore> stackScore1 = new Stack<>();
    private Stack<MementoScore> stackScore2 = new Stack<>();

    public void add(MementoScore state) {
        stackScore1.push(state);
    }

    public MementoScore undo() {
        stackScore2.push(stackScore1.pop());
        return stackScore1.lastElement();

    }

    public MementoScore redo() {
        stackScore1.push(stackScore2.pop());
        return stackScore1.lastElement();
    }

    public void clear2ndStack() {
        stackScore2.clear();
    }

    public boolean canRedo() {
        return stackScore2.size() != 0;
    }

    public boolean canUndo() {
        return stackScore1.size() != 1;
    }
}

