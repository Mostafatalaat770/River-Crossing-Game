package Interfaces.Factory;

import Levels.Level;
import Levels.Level1;

/**
 * @author Mostafa Talaat
 */
public class LevelCreator {
    public Level getLevel(int levelID) {
        if (levelID == 1) {
            return new Level1();
        }
        return null;
    }
}
