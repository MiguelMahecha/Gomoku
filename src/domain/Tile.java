package domain;

public class Tile {
    public static final int MINE = 0;
    public static final int TELEPORT = 1;
    public static final int GOLDEN = 2;
    protected int row;
    protected int col;
    protected Board board;
    protected Stone stone;

    /**
     * Create a new Tile
     * @param row The tile's row
     * @param col The tile's column
     * @param board The board that the Tile belongs to
     */
    public Tile(int row, int col, Board board) {
        this.row = row;
        this.col = col;
        this.board = board;
    }

    /**
     * Place the stone in the Tile
     * @param stone The stone to place
     */
    public void placeStone(Stone stone) {
        this.stone = stone;
    }

    /**
     * Check if the Tile has a stone
     * @return True if the Tile has a stone, false otherwise
     */
    public boolean hasStone() {
        return this.stone != null;
    }

    /**
     * The Stone contained in the tile.
     * @return The Tile's stone, if it has one. Null otherwise
     */
    public Stone getStone() {
        return this.stone;
    }

    /**
     * Does nothing on a normal Tile
     */
    public void execute() {}
}