package Interfaces.Memento;

import Interfaces.ICrosser;

import java.util.List;

/**
 * @author Mostafa Talaat
 */
public class OriginatorLeft {
    private List<ICrosser> state;

    public List<ICrosser> getState() {
        return state;
    }

    public void setState(List<ICrosser> state) {
        this.state = state;
    }

    public MementoLeft saveStateToMemento() {
        return new MementoLeft(state);
    }

    public void getStateFromMemento(MementoLeft memento) {
        state = memento.getState();
    }

}
