package Interfaces.Factory;

import Levels.Level;
import Levels.Level1;
import Levels.Level2;
import Levels.Level3;

/**
 * @author Mostafa Talaat
 */
public class LevelCreator {
    public Level getLevel(int levelID) {
        if (levelID == 1) {
            return new Level1();
        } else if (levelID == 2) {
            return new Level2();
        } else if (levelID == 3) {
            return new Level3();
        }
        return null;
    }
}
