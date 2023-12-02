package domain.adapters;

/**
 * The Player Adapter can be used to allow Domain to talk to external layers
 * @param name
 * @param color
 * @param score
 * @param time
 * @param stonesLeft
 */
public record PlayerAdapter(String name, ColorAdapter color, int score, int time, int stonesLeft, boolean human) {
}
