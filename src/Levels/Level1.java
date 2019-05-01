package Levels;

import Animals.Carnivores.Carnivore;
import Animals.Carnivores.Fox;
import Animals.Herbivores.Herbivore;
import Animals.Herbivores.Rabbit;
import Humans.Farmer;
import Interfaces.ICrosser;
import Plants.Cabbage;
import Plants.Plant;

import java.util.ArrayList;
import java.util.List;

public class Level1 extends Level {
    @Override
    public boolean isValid(List<ICrosser> rightBankCrossers, List<ICrosser> leftBankCrossers, List<ICrosser> boatRiders) {
        int herbivoreCount = 0;
        int carnivoreCount = 0;
        int plantCount = 0;
        for (int i = 0; i < rightBankCrossers.size(); i++) {
            if (rightBankCrossers.get(i) instanceof Carnivore)
                carnivoreCount++;
            if (rightBankCrossers.get(i) instanceof Herbivore)
                herbivoreCount++;
            if (rightBankCrossers.get(i) instanceof Plant)
                plantCount++;
        }
        if ((carnivoreCount != 0 && herbivoreCount != 0) || (herbivoreCount != 0 && plantCount != 0)) {
            return false;
        } else {
            carnivoreCount = 0;
            herbivoreCount = 0;
            plantCount = 0;
        }
        for (int i = 0; i < leftBankCrossers.size(); i++) {
            if (leftBankCrossers.get(i) instanceof Carnivore)
                carnivoreCount++;
            if (leftBankCrossers.get(i) instanceof Herbivore)
                herbivoreCount++;
            if (leftBankCrossers.get(i) instanceof Plant)
                plantCount++;
        }
        return (carnivoreCount == 0 || herbivoreCount == 0) && (herbivoreCount == 0 || plantCount == 0);

    }

    @Override
    public List<ICrosser> getInitialCrossers() {
        List<ICrosser> list = new ArrayList<>();
        list.add(new Farmer(100, 5));
        list.add(new Fox(20, 2));
        list.add(new Rabbit(20, 1));
        list.add(new Cabbage(10, 0));
        return list;
    }

    @Override
    public String[] getInstructions() {

        String[] instructions = new String[1];
        instructions[0] = "Welcome to the first level, you have 1 farmer, 1 rabbit, 1 fox and 1 cabbage.\n" +
                "How can the farmer get across the river with all the 2 animals and the plant without any losses?\n" +
                "Rules:\n" +
                "1- Only the farmer can sail the boat and can only take 1 passenger with him.\n" +
                "2- If a fox and a rabbit are on the same bank alone, the rabbit will be eaten.\n" +
                "3- If a rabbit and a cabbage are on the same bank alone, the cabbage will be eaten.\n";

        return instructions;
    }
}
