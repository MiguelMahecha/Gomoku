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

        gameWon = false;
        gameDraw = false;

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

       if (!gameWon && !gameDraw) {
           board.play(row, col, type, getCurrentPlayer().getColor());

           if (gameDraw()) {
               this.gameDraw = true;
               System.out.println("DRAW!!");
               return;
           }
           else if (gameWon()) {
               this.gameWon = true;
               System.out.println("WON!!");
               return;
           }
           turn();
       }
    }

    private void turn() {
        for (Tile[] row : board.getBoard()) {
            for (Tile col : row) {
                if (col.getStone() instanceof TemporalStone) {
                    ((TemporalStone) col.getStone()).reduceLifespan();
                }
            }
        }
        currentPlayer = currentPlayer.equals(player1) ? player2 : player1;
    }

    @Override
    public boolean gameWon() {
        for (int i = 0; i < gameSize(); i++) {
            for (int j = 0; j < gameSize() - 4; j++) {
                if (horizontalChain(i, j)) return true;
                if (verticalChain(i, j)) return true;
            }
        }

        return false;
    }

    private boolean verticalChain(int row, int col) {
        int chain = 1;
        Tile[][] tiles = board.getBoard();
        for (int i = 0; i < gameSize() - 4; i++) {
            if (tiles[i][col].hasStone() && tiles[i+1][col].hasStone()) {
                if (tiles[i][col].getStone().getColor().equals(tiles[i + 1][col].getStone().getColor()))
                    chain++;
            } else {
                chain = 1;
            }
            if (chain == 5) return true;
        }
        return false;
    }

    private boolean horizontalChain(int row, int col) {
        int chain = 1;
        Tile[][] tiles = board.getBoard();
        for (int j = 0; j < gameSize() - 4; j++) {
            if (tiles[row][j].hasStone() && tiles[row][j + 1].hasStone()) {
                if (tiles[row][j].getStone().getColor().equals(tiles[row][j + 1].getStone().getColor()))
                    chain += 1;
            } else {
                chain = 1;
            }
            if (chain == 5) return true;
        }
        return false;
    }


    @Override
    public boolean gameDraw() {
        for (int i = 0; i < gameSize(); i++) {
            for (int j = 0; j < gameSize(); j++) {
                Tile t = board.getTile(i, j);
                if (!t.hasStone()) return false;
            }
        }
        return true;
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
