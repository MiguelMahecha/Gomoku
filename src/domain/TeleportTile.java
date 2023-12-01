package domain;

public class TeleportTile extends Tile {
    /**
     * Create a new Tile
     *
     * @param row   The tile's row
     * @param col   The tile's column
     * @param board The board that the Tile belongs to
     */
    public TeleportTile(int row, int col, Board board) {
        super(row, col, board);
    }
}
