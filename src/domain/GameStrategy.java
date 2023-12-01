package domain;

import domain.adapters.ColorAdapter;

public abstract class GameStrategy {
    protected Player player1;
    protected Player player2;
    protected Player currentPlayer;
    protected Board board;

    /**
     * Get the current player
     * @return A Player object
     */
    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }

    /**
     * Get a player by their color
     * @param color The Player's color
     * @return The player is found
     * @throws GomokuException If no player has the given color
     */
    public Player getPlayerByColor(ColorAdapter color) throws GomokuException {
        if (player1.getColor().equals(color)) return player1;
        else if (player2.getColor().equals(color)) return player2;

        throw new GomokuException(GomokuException.NO_PLAYER_WITH_COLOR + color.toString());
    }

    /**
     * Get the board
     * @return A Board
     */
    public Board getBoard() {
        return this.board;
    }

    public int gameSize() {
        return board.size();
    }
    /**
     * Make a move on the board
     * @param row The row
     * @param col The col
     * @param type The Stone type. Available Stone types are available as static fields of Stone class
     * @throws GomokuException If the move or stone type are not valid
     */
    public abstract void play(int row, int col, String type) throws GomokuException;

    /**
     * Check if win condition has been met
     * @return True if the game has been one, false otherwise
     */
    public abstract boolean gameWon();

    /**
     * Check if draw condition has been met.
     * @return True if the game has ended in a draw, false otherwise.
     */
    public abstract boolean gameDraw();

    /**
     * Get the player who has won the game
     * @return A Player
     */
    public abstract Player getWinner();

    /**
     * Check if the given coordinates are valid
     * @param row The row
     * @param col The col
     * @return True if the coordinate is valid
     */
    protected boolean validCoordinate(int row, int col) {
        return row >= 0 && row <= board.size() && col >= 0 && col <= board.size();
    }

    /**
     * Check if the given type is a valid stone type
     * @param type The Stone type
     * @return True if stone type is valid
     */
    protected boolean validateStoneType(String type) {
        return switch (type) {
            case Stone.HEAVY, Stone.NORMAL, Stone.TEMPORAL -> true;
            default -> false;
        };
    }

    public abstract String getType();
}
