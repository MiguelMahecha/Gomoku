package domain;

import domain.adapters.PlayerAdapter;

public class NormalGame extends GameStrategy {
    /**
     * Create a new NORMAL Game
     *
     * @param playerAdapter1 The Adapter with Player One's information
     * @param playerAdapter2 The Adapter with Player Two's information
     * @param size    The size of the board
     */
    public NormalGame(PlayerAdapter playerAdapter1, PlayerAdapter playerAdapter2, int size) throws GomokuException {
        super();

        int stonesForPlayers = size*size;
//        Player setup
        this.player1 = playerAdapter1.human() ? new HumanPlayer(playerAdapter1.name(), playerAdapter1.color()) : new RobotPlayer(playerAdapter1.name(), playerAdapter1.color());
        this.player1.assignStones(stonesForPlayers);

        this.player2 = playerAdapter2.human() ? new HumanPlayer(playerAdapter2.name(), playerAdapter2.color()) : new RobotPlayer(playerAdapter2.name(), playerAdapter2.color());
        this.player2.assignStones(stonesForPlayers);

        this.currentPlayer = this.player1;

//        Board setup
        this.board = new Board(size);
    }

    @Override
    public void play(int row, int col, String type) throws GomokuException {
        if (!validCoordinate(row, col))
            throw new GomokuException(GomokuException.NOT_VALID_COORDINATE + String.format("(%d, %d)", row, col));
        if (!validateStoneType(type)) throw new GomokuException(GomokuException.NOT_VALID_STONE_TYPE + type);

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

    @Override
    public String getType() {
        return Gomoku.NORMAL;
    }
}
