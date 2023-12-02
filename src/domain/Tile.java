package domain;

import domain.adapters.ColorAdapter;

public class Tile {
    public static final int MINE = 0;
    public static final int TELEPORT = 1;
    public static final int GOLDEN = 2;
    public static final int NORMAL = 3;
    protected int row;
    protected int col;
    protected Board board;
    protected Stone stone;
    private int type;

    /**
     * Create a new Tile
     *
     * @param row   The tile's row
     * @param col   The tile's column
     * @param board The board that the Tile belongs to
     */
    public Tile(int row, int col, Board board) {
        this.row = row;
        this.col = col;
        this.board = board;
        this.type = NORMAL;
    }

    /**
     * Place the stone in the Tile
     *
     * @param stone The stone to place
     */
    public void placeStone(String stone, ColorAdapter playerColor) {
        this.stone = switch (stone) {
            case Stone.HEAVY -> new HeavyStone(playerColor, this);
            case Stone.TEMPORAL -> new TemporalStone(playerColor, this);
            default -> new Stone(playerColor, this);
        };
    }

    /**
     * Check if the Tile has a stone
     *
     * @return True if the Tile has a stone, false otherwise
     */
    public boolean hasStone() {
        return this.stone != null;
    }

    /**
     * The Stone contained in the tile.
     *
     * @return The Tile's stone, if it has one. Null otherwise
     */
    public Stone getStone() {
        return this.stone;
    }

    /**
     * Does nothing on a normal Tile
     */
    public void execute() {
    }

    public String getType() {
        return switch (this.type) {
            case MINE -> "Mine";
            case TELEPORT -> "Teleport";
            case GOLDEN -> "Golden";
            default -> "Normal";
        };
    }

    public void removeStone() {
        this.stone = null;
    }
}
