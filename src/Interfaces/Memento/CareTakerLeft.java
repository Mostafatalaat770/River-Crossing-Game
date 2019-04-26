package Interfaces.Memento;

import Animals.Animal;
import Animals.Carnivores.Lion;
import Humans.Farmer;
import Humans.Human;
import Interfaces.ICrosser;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Mostafa Talaat
 */
public class CareTakerLeft {
    private Stack<MementoLeft> stackLeftBank1 = new Stack<>();
    private Stack<MementoLeft> stackLeftBank2 = new Stack<>();

    public static void main(String[] args) {
        OriginatorLeft originator = new OriginatorLeft();
        CareTakerLeft careTakerLeft = new CareTakerLeft();
        Human farmer = new Farmer(10, 5);
        Animal lion = new Lion(100, 1);
        List<ICrosser> left = new ArrayList<>();
        left.add(farmer);
        left.add(lion);
        originator.setState(new ArrayList<>(left));
        careTakerLeft.add(originator.saveStateToMemento());
        left.add(1, new Farmer(10, 5));
        originator.setState(new ArrayList<>(left));
        careTakerLeft.add(originator.saveStateToMemento());
        originator.getStateFromMemento(careTakerLeft.undo());
        System.out.println(originator.getState().get(0).getEatingRank());
        System.out.println(originator.getState().get(1).getEatingRank());
        //System.out.println(originator.getState().get(2).getEatingRank());
        originator.getStateFromMemento(careTakerLeft.redo());
        System.out.println(originator.getState().get(0).getEatingRank());
        System.out.println(originator.getState().get(1).getEatingRank());
        //System.out.println(originator.getState().get(2).getEatingRank());
        originator.getStateFromMemento(careTakerLeft.undo());
        System.out.println(originator.getState().get(0).getEatingRank());
        System.out.println(originator.getState().get(1).getEatingRank());

//        System.out.println(left.get(0).getEatingRank());

        //originator.setLeftBankState(left);
        //careTakerLeft.addLeft(originator.saveStateToMemento());
    }

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

