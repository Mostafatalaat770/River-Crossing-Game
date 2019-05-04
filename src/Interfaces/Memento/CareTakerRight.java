package Interfaces.Memento;

import java.util.Stack;

/**
 * @author Mostafa Talaat
 */
public class CareTakerRight {
    private Stack<MementoRight> stackRightBank1 = new Stack<>();
    private Stack<MementoRight> stackRightBank2 = new Stack<>();

    public void add(MementoRight state) {
        stackRightBank1.push(state);
    }

    public MementoRight undo() {
        stackRightBank2.push(stackRightBank1.pop());
        return stackRightBank1.lastElement();

    }

    public MementoRight redo() {
        stackRightBank1.push(stackRightBank2.pop());
        return stackRightBank1.lastElement();
    }

    public void clear2ndStack() {
        stackRightBank2.clear();
    }
}
