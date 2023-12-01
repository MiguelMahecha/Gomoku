package domain;

import domain.adapters.ColorAdapter;

public class TemporalStone extends Stone {
    private int lifespan;

    /**
     * Create a new Stone
     *
     * @param color The stone's color
     * @param tile  The tile that contains the stone
     */
    public TemporalStone(ColorAdapter color, Tile tile) {
        super(color, tile);
        lifespan = 3;
    }
}
