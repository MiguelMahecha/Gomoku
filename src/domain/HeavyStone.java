package domain;

import domain.adapters.ColorAdapter;

public class HeavyStone extends Stone {
    /**
     * Create a new Stone
     *
     * @param color The stone's color
     * @param tile  The tile that contains the stone
     */
    public HeavyStone(ColorAdapter color, Tile tile) {
        super(color, tile);
    }
}
