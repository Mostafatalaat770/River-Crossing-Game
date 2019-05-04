package Levels;

import Humans.Child;
import Humans.Farmer;
import Interfaces.ICrosser;

import java.util.ArrayList;
import java.util.List;

public class Level3 extends Level {
    @Override
    public boolean isValid(List<ICrosser> rightBankCrossers, List<ICrosser> leftBankCrossers, List<ICrosser> boatRiders) {
        int farmerCount = 0;
        for (int i = 0; i < boatRiders.size(); i++) {
            if (boatRiders.get(i) instanceof Farmer) {
                farmerCount++;
            }
            if (farmerCount > 1 && boatRiders.size() > 1)
                return false;

        }
        return true;
    }

    @Override
    public List<ICrosser> getInitialCrossers() {
        List<ICrosser> list = new ArrayList<>();
        list.add(new Farmer(100, 5));
        list.add(new Farmer(20, 2));
        list.add(new Child(20, 1));
        list.add(new Child(10, 0));
        return list;
    }

    @Override
    public String[] getInstructions() {
        setHasLables(false);
        String[] instructions = new String[1];
        instructions[0] = "2 farmers and 2 children want to pass the river\n" +
                "How can they all get to the other side?\n" +
                "Rules:\n" +
                "1- The raft can hold 1 farmer or 2 children.\n" +
                "2- All characters can raft.\n";
        return instructions;
    }
}
