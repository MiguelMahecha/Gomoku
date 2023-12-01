package domain.adapters;

/**
 * The Stone Adapter allows Stones to be queried in external layers.
 * @param type
 * @param color
 */
public record StoneAdapter(String type, ColorAdapter color) {
}
