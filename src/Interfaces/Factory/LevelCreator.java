package Interfaces.Factory;

import Levels.Level;
import Levels.Level1;
import Levels.Level2;

/**
 * @author Mostafa Talaat
 */
public class LevelCreator {
    public Level getLevel(int levelID) {
        if (levelID == 1) {
            return new Level1();
        } else if (levelID == 2) {
            return new Level2();
        }
        return null;
    }
}
