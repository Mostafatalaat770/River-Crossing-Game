package Interfaces.Memento;

import Interfaces.ICrosser;

import java.util.List;

/**
 * @author Mostafa Talaat
 */
public class MementoRight {
    private List<ICrosser> state;

    public MementoRight(List<ICrosser> state) {

        this.state = state;
    }

    public List<ICrosser> getState() {
        return state;
    }
}
