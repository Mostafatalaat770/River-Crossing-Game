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
        int herbivoreCount=0;
        int carnivoreCount = 0;
        int plantCount = 0;
        for(int i=0;i<rightBankCrossers.size();i++){
            if(rightBankCrossers.get(i) instanceof Carnivore)
                carnivoreCount++;
            if(rightBankCrossers.get(i) instanceof Herbivore)
                herbivoreCount++;
            if(rightBankCrossers.get(i) instanceof Plant)
                plantCount++;
        }
        if((carnivoreCount!=0&&herbivoreCount!=0)||(herbivoreCount!=0&&plantCount!=0)) {
            return false;
        }
        else{
            carnivoreCount=0;
            herbivoreCount=0;
            plantCount=0;
        }
        for(int i=0;i<leftBankCrossers.size();i++){
            if(leftBankCrossers.get(i) instanceof Carnivore)
                carnivoreCount++;
            if(leftBankCrossers.get(i) instanceof Herbivore)
                herbivoreCount++;
            if(leftBankCrossers.get(i) instanceof Plant)
                plantCount++;
        }
        if((carnivoreCount!=0&&herbivoreCount!=0)||(herbivoreCount!=0&&plantCount!=0))
            return false;
        return true;

    }

    @Override
    public List<ICrosser> getInitialCrossers() {
        List<ICrosser> list=new ArrayList<ICrosser>();
        Farmer farmer=new Farmer(100.,5);
        Fox fox= new Fox(20,2);
        Rabbit rabit=new Rabbit(20,1);
        Cabbage cabbage=new Cabbage();
        list.add(farmer);
        list.add(fox);
        list.add(cabbage);
        list.add(rabit);
        return list;
    }

    @Override
    public String[] getInstructions() {

        String[] instructions=new String[5];
        instructions[0]="welcome to the first level, you have 1 farmer, 1 rabit, 1 fox and 1 cabbage. your goal is to move all the elements form the left bank to th e right bank";
        instructions[1]="1- only the farmer can steer the boat and he can only take 1 passenger with him";
        instructions[2]="2- if a fox and a rabbit are on the same bank alone, the rabit will be eaten";
        instructions[3]="3- if a rabbit and a cabbage are on the same bank alone, the cabbage will be eaten";
        instructions[5]="Try to figure out how to make all cross the river";
        return instructions;
    }
}
