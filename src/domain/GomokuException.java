package domain;

public class GomokuException extends Exception {
    public static final String NO_PLAYER_WITH_COLOR = "No player with color: ";

    public GomokuException(String msg) {
        super(msg);
    }
}
