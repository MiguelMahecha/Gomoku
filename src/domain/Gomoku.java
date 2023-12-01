package domain;

import domain.adapters.ColorAdapter;
import domain.adapters.PlayerAdapter;
import domain.adapters.StoneAdapter;
import domain.adapters.TileAdapter;

public class Gomoku {
    private final GameStrategy strategy;

    public Gomoku(PlayerAdapter player1, PlayerAdapter player2, int size) throws GomokuException {
        strategy = new NormalGame(player1, player2, size);
    }

    public PlayerAdapter getCurrentPlayer() {
        Player p = strategy.getCurrentPlayer();
        return new PlayerAdapter(p.getName(), p.getColor(), p.getScore(), p.getTimeLeft(), p.getStonesLeft(), p instanceof HumanPlayer);
    }

    public PlayerAdapter getPlayerByColor(ColorAdapter color) throws GomokuException {
        Player p = strategy.getPlayerByColor(color);
        return new PlayerAdapter(p.getName(), p.getColor(), p.getScore(), p.getTimeLeft(), p.getStonesLeft(), p instanceof HumanPlayer);
    }

    public TileAdapter[][] getBoard() {
        Board board = strategy.getBoard();
        TileAdapter[][] tiles = new TileAdapter[strategy.gameSize()][strategy.gameSize()];
        for (int i = 0; i < strategy.gameSize(); i++) {
            for (int j = 0; j < strategy.gameSize(); j++) {
                Tile t = board.getTile(i, j);
                Stone s = t.getStone();
                tiles[i][j] = new TileAdapter(t.row, t.col, t.getType(), new StoneAdapter(s.getType(), s.getColor()));
            }
        }
        return tiles;
    }

    public void play(int row, int col, int type) throws GomokuException {
        strategy.play(row, col, type);
    }

    public boolean gameWon() {
        return strategy.gameWon();
    }

    public boolean gameDraw() {
        return strategy.gameDraw();
    }

    public PlayerAdapter getWinner() {
        Player p = strategy.getWinner();
        return new PlayerAdapter(p.getName(), p.getColor(), p.getScore(), p.getTimeLeft(), p.getStonesLeft(), p instanceof HumanPlayer);
    }
}
