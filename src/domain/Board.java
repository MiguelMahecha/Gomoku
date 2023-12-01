package domain;

public class Board {
    private Tile[][] tiles;
    private int size;
    private int percentageSpecialTiles;
    private int percentageSpecialStones;

    /**
     * Create a new Board
     *
     * @param size The Board size
     */
    public Board(int size) {
        this.size = size;
    }

    /**
     * Set the percentage of special tiles in the Board
     *
     * @param percentage Int from 0 to 100
     */
    public void percentageSpecialTiles(int percentage) {
        this.percentageSpecialTiles = percentage;
    }

    /**
     * Set the percentage of special stones in the game
     *
     * @param percentage Int from 0 to 100
     */
    public void percentageSpecialStones(int percentage) {
        this.percentageSpecialStones = percentage;
    }

    /**
     * TODO: Make a move on the board
     *
     * @param row  The row to place Stone
     * @param col  The col to place Stone
     * @param type The type of Stone to place
     */
    public void play(int row, int col, int type) {
    }

    /**
     * TODO: Check for a draw condition
     *
     * @return True if there is a draw condition, false otherwise
     */
    public boolean draw() {
        return false;
    }

    /**
     * TODO: Check for win condition
     *
     * @return True if win condition is met, false otherwise
     */
    public boolean won() {
        return false;
    }

    /**
     * Get the tile at the given position
     *
     * @param row The row
     * @param col The col
     * @return The tile if found
     */
    public Tile getTile(int row, int col) {
        return tiles[row][col];
    }
}
