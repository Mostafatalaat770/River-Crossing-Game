package Files;

import Animals.Carnivores.Fox;
import Animals.Carnivores.Lion;
import Animals.Herbivores.Chicken;
import Animals.Herbivores.Rabbit;
import Humans.Farmer;
import Interfaces.ICrosser;
import Plants.Cabbage;
import Plants.Carrot;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Mostafa Talaat
 */
public class FileManagement {

    private List<ICrosser> leftBank = new ArrayList<>();
    private List<ICrosser> rightBank = new ArrayList<>();
    private List<ICrosser> boat = new ArrayList<>();
    private boolean boatPosition;
    private int score;
    private int levelID;

    public List<ICrosser> getLeftBank() {
        return leftBank;
    }

    public List<ICrosser> getRightBank() {
        return rightBank;
    }

    public List<ICrosser> getBoat() {
        return boat;
    }

    public boolean getBoatPosition() {
        return boatPosition;
    }

    public int getScore() {
        return score;
    }

    public int getLevelID() {
        return levelID;
    }

    public void load() {
        File inputFile = new File(System.getProperty("user.home") + File.separator + "Documents" + File.separator + "River Crossing Game/Saves/level.txt");
        SAXBuilder saxBuilder = new SAXBuilder();
        try {
            Document document = saxBuilder.build(inputFile);
            Element classElement = document.getRootElement();

            String flag = document.getRootElement().getName();

            switch (flag) {
                case "level1":
                    levelID = 1;
                    break;
                case "level2":
                    levelID = 2;
                    break;
            }

            Element parent = classElement.getChild("leftBank");
            List<Element> childs = parent.getChildren();
            for (int i = 0; i < childs.size(); i++) {
                Element child = childs.get(i);
                switch (child.getName()) {
                    case "farmer":
                        leftBank.add(new Farmer(Double.parseDouble(child.getChild("weight").getText()), Integer.parseInt(child.getChild("eatingRank").getText())));
                        break;
                    case "lion":
                        leftBank.add(new Lion(Double.parseDouble(child.getChild("weight").getText()), Integer.parseInt(child.getChild("eatingRank").getText())));
                        break;
                    case "fox":
                        leftBank.add(new Fox(Double.parseDouble(child.getChild("weight").getText()), Integer.parseInt(child.getChild("eatingRank").getText())));
                        break;
                    case "rabbit":
                        leftBank.add(new Rabbit(Double.parseDouble(child.getChild("weight").getText()), Integer.parseInt(child.getChild("eatingRank").getText())));
                        break;
                    case "chicken":
                        leftBank.add(new Chicken(Double.parseDouble(child.getChild("weight").getText()), Integer.parseInt(child.getChild("eatingRank").getText())));
                        break;
                    case "cabbage":
                        leftBank.add(new Cabbage(Double.parseDouble(child.getChild("weight").getText()), Integer.parseInt(child.getChild("eatingRank").getText())));
                        break;
                    case "carrot":
                        leftBank.add(new Carrot(Double.parseDouble(child.getChild("weight").getText()), Integer.parseInt(child.getChild("eatingRank").getText())));
                        break;
                }
            }

            parent = classElement.getChild("rightBank");
            childs = parent.getChildren();
            for (int i = 0; i < childs.size(); i++) {
                Element child = childs.get(i);
                switch (child.getName()) {
                    case "farmer":
                        rightBank.add(new Farmer(Double.parseDouble(child.getChild("weight").getText()), Integer.parseInt(child.getChild("eatingRank").getText())));
                        break;
                    case "lion":
                        rightBank.add(new Lion(Double.parseDouble(child.getChild("weight").getText()), Integer.parseInt(child.getChild("eatingRank").getText())));
                        break;
                    case "fox":
                        rightBank.add(new Fox(Double.parseDouble(child.getChild("weight").getText()), Integer.parseInt(child.getChild("eatingRank").getText())));
                        break;
                    case "rabbit":
                        rightBank.add(new Rabbit(Double.parseDouble(child.getChild("weight").getText()), Integer.parseInt(child.getChild("eatingRank").getText())));
                        break;
                    case "chicken":
                        rightBank.add(new Chicken(Double.parseDouble(child.getChild("weight").getText()), Integer.parseInt(child.getChild("eatingRank").getText())));
                        break;
                    case "cabbage":
                        rightBank.add(new Cabbage(Double.parseDouble(child.getChild("weight").getText()), Integer.parseInt(child.getChild("eatingRank").getText())));
                        break;
                    case "carrot":
                        rightBank.add(new Carrot(Double.parseDouble(child.getChild("weight").getText()), Integer.parseInt(child.getChild("eatingRank").getText())));
                        break;
                }
            }

            parent = classElement.getChild("boat");
            childs = parent.getChildren();
            for (int i = 0; i < childs.size(); i++) {
                Element child = childs.get(i);
                switch (child.getName()) {
                    case "farmer":
                        boat.add(new Farmer(Double.parseDouble(child.getChild("weight").getText()), Integer.parseInt(child.getChild("eatingRank").getText())));
                        break;
                    case "lion":
                        boat.add(new Lion(Double.parseDouble(child.getChild("weight").getText()), Integer.parseInt(child.getChild("eatingRank").getText())));
                        break;
                    case "fox":
                        boat.add(new Fox(Double.parseDouble(child.getChild("weight").getText()), Integer.parseInt(child.getChild("eatingRank").getText())));
                        break;
                    case "rabbit":
                        boat.add(new Rabbit(Double.parseDouble(child.getChild("weight").getText()), Integer.parseInt(child.getChild("eatingRank").getText())));
                        break;
                    case "chicken":
                        boat.add(new Chicken(Double.parseDouble(child.getChild("weight").getText()), Integer.parseInt(child.getChild("eatingRank").getText())));
                        break;
                    case "cabbage":
                        boat.add(new Cabbage(Double.parseDouble(child.getChild("weight").getText()), Integer.parseInt(child.getChild("eatingRank").getText())));
                        break;
                    case "carrot":
                        boat.add(new Carrot(Double.parseDouble(child.getChild("weight").getText()), Integer.parseInt(child.getChild("eatingRank").getText())));
                        break;
                    case "position":
                        boatPosition = Boolean.parseBoolean(child.getText());
                }
            }


            score = Integer.parseInt(classElement.getChild("score").getText());

        } catch (JDOMException | IOException e) {
            e.printStackTrace();
        }
    }


    public void save(List<ICrosser> rightBank, List<ICrosser> leftBank, List<ICrosser> boat, boolean boatPosition, int score, int levelID) {

        try {

            Element levelElement = new Element("level" + levelID);
            Document doc = new Document(levelElement);

            Element child = new Element("leftBank");
            levelElement.addContent(child);
            Element parent = child;
            for (int i = 0; i < leftBank.size(); i++) {
                ICrosser crosser = leftBank.get(i);
                Element info;
                if (crosser instanceof Farmer) {
                    child = new Element("farmer");
                } else if (crosser instanceof Lion) {
                    child = new Element("lion");
                } else if (crosser instanceof Fox) {
                    child = new Element("fox");
                } else if (crosser instanceof Rabbit) {
                    child = new Element("rabbit");
                } else if (crosser instanceof Chicken) {
                    child = new Element("chicken");
                } else if (crosser instanceof Cabbage) {
                    child = new Element("cabbage");
                } else if (crosser instanceof Carrot) {
                    child = new Element("carrot");
                }
                info = new Element("weight");
                info.setText(Double.toString(crosser.getWeight()));
                child.addContent(info);

                info = new Element("eatingRank");
                info.setText(Integer.toString(crosser.getEatingRank()));
                child.addContent(info);

                parent.addContent(child);

            }

            child = new Element("rightBank");
            levelElement.addContent(child);
            parent = child;
            for (int i = 0; i < rightBank.size(); i++) {
                ICrosser crosser = rightBank.get(i);
                Element info;
                if (crosser instanceof Farmer) {
                    child = new Element("farmer");
                } else if (crosser instanceof Lion) {
                    child = new Element("lion");
                } else if (crosser instanceof Fox) {
                    child = new Element("fox");
                } else if (crosser instanceof Rabbit) {
                    child = new Element("rabbit");
                } else if (crosser instanceof Chicken) {
                    child = new Element("chicken");
                } else if (crosser instanceof Cabbage) {
                    child = new Element("cabbage");
                } else if (crosser instanceof Carrot) {
                    child = new Element("carrot");
                }
                info = new Element("weight");
                info.setText(Double.toString(crosser.getWeight()));
                child.addContent(info);

                info = new Element("eatingRank");
                info.setText(Integer.toString(crosser.getEatingRank()));
                child.addContent(info);

                parent.addContent(child);

            }

            child = new Element("boat");
            levelElement.addContent(child);
            parent = child;

            for (int i = 0; i < boat.size(); i++) {
                ICrosser crosser = boat.get(i);
                Element info;
                if (crosser instanceof Farmer) {
                    child = new Element("farmer");
                } else if (crosser instanceof Lion) {
                    child = new Element("lion");
                } else if (crosser instanceof Fox) {
                    child = new Element("fox");
                } else if (crosser instanceof Rabbit) {
                    child = new Element("rabbit");
                } else if (crosser instanceof Chicken) {
                    child = new Element("chicken");
                } else if (crosser instanceof Cabbage) {
                    child = new Element("cabbage");
                } else if (crosser instanceof Carrot) {
                    child = new Element("carrot");
                }
                info = new Element("weight");
                info.setText(Double.toString(crosser.getWeight()));
                child.addContent(info);

                info = new Element("eatingRank");
                info.setText(Integer.toString(crosser.getEatingRank()));
                child.addContent(info);

                parent.addContent(child);

            }
            child = new Element("position");
            child.setText(Boolean.toString(boatPosition));
            parent.addContent(child);

            child = new Element("score");
            child.setText(Integer.toString(score));

            doc.getRootElement().addContent(child);

            XMLOutputter xmlOutput = new XMLOutputter();

            File file = new File(System.getProperty("user.home") + File.separator + "Documents" + File.separator + "River Crossing Game/Saves");
            if (file.mkdirs()) {
                file.createNewFile();
            }
            xmlOutput.setFormat(Format.getPrettyFormat());
            xmlOutput.output(doc, new FileWriter(file + "/level.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

