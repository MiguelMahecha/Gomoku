package domain;

import domain.adapters.ColorAdapter;

public abstract class Player {
    protected String name;
    protected ColorAdapter color;
    protected int score;
    protected int timeLeft;
    protected int stonesLeft;

    /**
     * Create a new player with given name and color and default values
     * @param name The Player's name.
     * @param color The Player's color in RGB format.
     */
    public Player(String name, ColorAdapter color) {
        this.name = name;
        this.color = color;
    }

    /**
     * Assign the number of seconds a player has to use across the entire game
     * @param time The player's time
     * @return The Player
     */
    public Player assignTime(int time) {
        timeLeft = time;
        return this;
    }

    public Player assignStones(int amount) {
        if (stonesLeft == 0) stonesLeft = amount;
        return this;
    }

    /**
     * Player's name
     * @return A string, the player's name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Player's color
     * @return A String, the Player's color in RGB format
     */
    public ColorAdapter getColor() {
        return this.color;
    }

    /**
     * Player's score
     * @return An int
     */
    public int getScore() {
        return this.score;
    }

    /**
     * Increase the player's score by the given val
     * @param val The amount to increase
     */
    public void increaseScore(int val) {
        this.score += val;
    }

    /**
     * How much time the player has to win
     * @return An int
     */
    public int getTimeLeft() {
        return this.timeLeft;
    }

    /**
     * The amount of stones the player has
     * @return An int
     */
    public int getStonesLeft() {
        return this.stonesLeft;
    }

    /**
     * Remove one stone from the total number of stones the player has.
     */
    public void removeStone() {
        this.stonesLeft -= 1;
    }

}
