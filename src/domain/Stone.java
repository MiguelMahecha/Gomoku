package domain;

import domain.adapters.ColorAdapter;

public class Stone {
    public static final int NORMAL = 0;
    public static final int HEAVY = 1;
    public static final int TEMPORAL = 2;
    protected final ColorAdapter color;
    protected final Tile tile;
    protected int type;

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
        return switch (this.type) {
            case HEAVY -> "Heavy";
            case TEMPORAL -> "Temporal";
            default -> "Normal";
        };
    }
}
