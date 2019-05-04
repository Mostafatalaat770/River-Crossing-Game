package Levels;

import Interfaces.ICrossingStrategy;

public abstract class Level implements ICrossingStrategy {
    private boolean hasLables;

    public boolean isHasLables() {
        return hasLables;
    }

    public void setHasLables(boolean hasLables) {
        this.hasLables = hasLables;
    }
}