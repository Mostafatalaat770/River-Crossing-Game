package Levels;

import Animals.Herbivores.Rabbit;
import Humans.Farmer;
import Interfaces.ICrosser;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mostafa Talaat
 */
public class Level2 extends Level {
    @Override
    public boolean isValid(List<ICrosser> rightBankCrossers, List<ICrosser> leftBankCrossers, List<ICrosser> boatRiders) {

        int weight = 0;
        for (ICrosser boatRider : boatRiders) {
            weight += boatRider.getWeight();
        }
        return (weight <= 100);
    }

    @Override
    public List<ICrosser> getInitialCrossers() {
        List<ICrosser> list = new ArrayList<>();
        list.add(new Farmer(90, 0));
        list.add(new Farmer(80, 0));
        list.add(new Farmer(60, 0));
        list.add(new Farmer(40, 0));
        list.add(new Rabbit(20, 0));
        return list;
    }

    @Override
    public String[] getInstructions() {
        String[] instructions = new String[1];
        instructions[0] = "Four farmers and their animal need to cross a river in a small boat. The weights of the farmers are 90 kg,\n80 kg,60 kg and 40 kg respectively, and the weight of the animal is 20 kg.\n" +
                "How can they all get to the other side with their animal?\n" +
                "Rules:\n" +
                "1- The boat cannot bear a load heavier than 100 kg.\n" +
                "2- All farmers can raft, while the animal cannot.\n";
        return instructions;
    }
}
