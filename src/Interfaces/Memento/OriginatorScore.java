package Interfaces.Memento;

/**
 * @author Mostafa Talaat
 */
public class OriginatorScore {
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public MementoScore saveStateToMemento() {
        return new MementoScore(state);
    }

    public void getStateFromMemento(MementoScore memento) {
        state = memento.getState();
    }

}
