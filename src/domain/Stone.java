package domain;

import domain.adapters.ColorAdapter;

public class Stone {
    public static final String NORMAL = "normal";
    public static final String HEAVY = "heavy";
    public static final String TEMPORAL = "temporal";
    protected final ColorAdapter color;
    protected final Tile tile;
    protected String type;

    /**
     * Create a new Stone
     * @param color The stone's color
     * @param tile The tile that contains the stone
     */
    public Stone(ColorAdapter color, Tile tile) {
        this.color = color;
        this.tile = tile;
        this.type = NORMAL;
    }

    /**
     * The Stone's color
     * @return A ColorAdapter (r, g, b)
     */
    public ColorAdapter getColor() {
        return this.color;
    }

    public String getType() {
        return this.type;
    }
}
