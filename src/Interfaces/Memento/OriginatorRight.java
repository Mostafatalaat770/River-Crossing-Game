package Interfaces.Memento;

import Interfaces.ICrosser;

import java.util.List;

/**
 * @author Mostafa Talaat
 */
public class OriginatorRight {
    private List<ICrosser> state;

    public List<ICrosser> getState() {
        return state;
    }

    public void setState(List<ICrosser> state) {
        this.state = state;
    }

    public MementoRight saveStateToMemento() {
        return new MementoRight(state);
    }

    public void getStateFromMemento(MementoRight memento) {
        state = memento.getState();
    }

}
