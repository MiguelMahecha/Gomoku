package domain;

import domain.adapters.PlayerAdapter;

public class NormalGame extends GameStrategy{
    /**
     * Create a new NORMAL Game
     * @param player1 The Adapter with Player One's information
     * @param player2 The Adapter with Player Two's information
     * @param size The size of the board
     */
    public NormalGame(PlayerAdapter player1, PlayerAdapter player2, int size) throws GomokuException {
        super();
        this.player1 = player1.human() ? new HumanPlayer(player1.name(), player1.color()) : new RobotPlayer(player1.name(), player1.color());
        this.player2 = player2.human() ? new HumanPlayer(player2.name(), player2.color()) : new RobotPlayer(player2.name(), player2.color());
        this.board = new Board(size);
    }

    @Override
    public void play(int row, int col, int type) throws GomokuException {
        if (!validCoordinate(row, col)) throw new GomokuException(GomokuException.NOT_VALID_COORDINATE + String.format("(%d, %d)", row, col));
        if (!validateStoneType(type)) throw new GomokuException(GomokuException.NOT_VALID_STONE_TYPE);

    }

    @Override
    public boolean gameWon() {
        return false;
    }

    @Override
    public boolean gameDraw() {
        return false;
    }

    @Override
    public Player getWinner() {
        return null;
    }
}
