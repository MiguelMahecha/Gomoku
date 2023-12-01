package domain.adapters;

/**
 * The TileAdapter can be used to allow Domain Tiles to interact with external layers
 * @param row
 * @param col
 * @param type
 * @param stone
 */
public record TileAdapter(int row, int col, String type, StoneAdapter stone) {
}
