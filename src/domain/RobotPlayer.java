package domain;

import domain.adapters.ColorAdapter;

public class RobotPlayer extends Player{
    /**
     * Create a new player with given name and color and default values
     *
     * @param name  The Player's name.
     * @param color The Player's color in RGB format.
     */
    public RobotPlayer(String name, ColorAdapter color) {
        super(name, color);
    }
}
