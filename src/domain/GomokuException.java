package domain;

public class GomokuException extends Exception {
    public static final String NO_PLAYER_WITH_COLOR = "No player with color: ";
    public static final String NOT_VALID_COORDINATE = "Coordinate is not valid: ";
    public static final String NOT_VALID_STONE_TYPE = "Stone type is not valid: ";
    public static final String INVALID_BOARD_SIZE = "Board size not valid: ";
    public static final String INVALID_STONE_AMOUNT = "Not a valid amount of stones for a player: ";
    public static final String INVALID_TIME_LIMIT = "No a valid time limit for a player: ";
    public static final String PLAYER_CANNOT_HAVE_TIME_LIMIT_ON_NORMAL_MODE = "Player can't have time limit on normal mode";
    public static final String PLAYER_CANNOT_HAVE_STONE_LIMIT_ON_NORMAL_MODE= "Player can't have stone limit on normal mode";
    public static final String PLAYER_CANNOT_HAVE_INITIAl_SCORE_ON_NORMAL_MODE = "Player can't have initial score on normal mode";
    public static final String INVALID_MOVE = "Invalid move";

    public GomokuException(String msg) {
        super(msg);
    }
}
