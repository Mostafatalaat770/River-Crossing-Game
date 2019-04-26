package Interfaces.Memento;

import java.util.Stack;

/**
 * @author Mostafa Talaat
 */
public class CareTakerLeft {
    private Stack<MementoLeft> stackLeftBank1 = new Stack<>();
    private Stack<MementoLeft> stackLeftBank2 = new Stack<>();

    public void add(MementoLeft state) {
        stackLeftBank1.push(state);
    }

    public MementoLeft undo() {
        stackLeftBank2.push(stackLeftBank1.pop());
        return stackLeftBank1.lastElement();

    }

    public MementoLeft redo() {
        stackLeftBank1.push(stackLeftBank2.pop());
        return stackLeftBank1.lastElement();
    }
}

