package Interfaces.Memento;

import Interfaces.ICrosser;

import java.util.List;

/**
 * @author Mostafa Talaat
 */
public class MementoLeft {
    private List<ICrosser> state;

    public MementoLeft(List<ICrosser> state) {

        this.state = state;
    }

    public List<ICrosser> getState() {
        return state;
    }
}
