package domain;

public class GomokuException extends Exception {
    public static final String NO_PLAYER_WITH_COLOR = "No player with color: ";
    public static final String NOT_VALID_COORDINATE = "Coordinate is not valid: ";
    public static final String NOT_VALID_STONE_TYPE = "Stone type is not valid: ";

    public GomokuException(String msg) {
        super(msg);
    }
}
