package domain;

import domain.adapters.ColorAdapter;
import domain.adapters.PlayerAdapter;
import domain.adapters.StoneAdapter;
import domain.adapters.TileAdapter;

public class Gomoku {
    public static final String NORMAL = "Normal";
    public static final String QUICKTIME = "QuickTime";
    public static final String STONE_LIMIT = "StoneLimit";
    private final GameStrategy strategy;

    /**
     * Create a new NORMAL game
     * @param player1 Player One Info
     * @param player2 Player Two Info
     * @param size Size of the board
     * @throws GomokuException If an error occurs on game initialization
     */
    public Gomoku(PlayerAdapter player1, PlayerAdapter player2, int size) throws GomokuException {
        strategy = new NormalGame(player1, player2, size);
    }

    /**
     * Get the current player
     * @return A Player Adapter
     */
    public PlayerAdapter getCurrentPlayer() {
        Player p = strategy.getCurrentPlayer();
        return new PlayerAdapter(p.getName(), p.getColor(), p.getScore(), p.getTime(), p.getStonesLeft(), p instanceof HumanPlayer);
    }

    /**
     * Get player by their color
     * @param color The color to search
     * @return A PlayerAdapter if player is found
     * @throws GomokuException If no player has that color
     */
    public PlayerAdapter getPlayerByColor(ColorAdapter color) throws GomokuException {
        Player p = strategy.getPlayerByColor(color);
        return new PlayerAdapter(p.getName(), p.getColor(), p.getScore(), p.getTime(), p.getStonesLeft(), p instanceof HumanPlayer);
    }

    /**
     * Get the board as a matrix of Tile Adapters
     * @return A 2D Array of Tile Adapters
     */
    public TileAdapter[][] getBoard() {
        Board board = strategy.getBoard();
        TileAdapter[][] tiles = new TileAdapter[strategy.gameSize()][strategy.gameSize()];
        for (int i = 0; i < strategy.gameSize(); i++) {
            for (int j = 0; j < strategy.gameSize(); j++) {
                Tile t = board.getTile(i, j);
                Stone s = t.getStone();
                if (s != null) tiles[i][j] = new TileAdapter(t.row, t.col, t.getType(), new StoneAdapter(s.getType(), s.getColor()));
                else tiles[i][j] = new TileAdapter(t.row, t.col, t.getType(), null);
            }
        }
        return tiles;
    }

    /**
     * Play a move
     * @param row The row to place the stone in
     * @param col The col to place the stone in
     * @param type The type of stone to place. Possible options available as static fields in Stone class
     * @throws GomokuException If col and row are invalid, or if stone type is invalid
     */
    public void play(int row, int col, String type) throws GomokuException {
        strategy.play(row, col, type.toLowerCase());
    }

    /**
     * Check if win condition has been met
     * @return True if win condition has been met, false otherwise
     */
    public boolean gameWon() {
        return strategy.checkIfWon();
    }

    /**
     * Check if draw condition has been met
     * @return True if draw condition has been met, false otherwise
     */
    public boolean gameDraw() {
        return strategy.gameDraw();
    }

    /**
     * Get the player who has won the game
     * @return The player who has won the game
     * @throws GomokuException If nobody has won the game
     */
    public PlayerAdapter getWinner() throws GomokuException {
        Player p = strategy.getWinner();
        return new PlayerAdapter(p.getName(), p.getColor(), p.getScore(), p.getTime(), p.getStonesLeft(), p instanceof HumanPlayer);
    }

    public String getType() {
        return strategy.getType();
    }
}
