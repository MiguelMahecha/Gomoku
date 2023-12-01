package domain;

public class StoneLimitGame extends GameStrategy{
    @Override
    public void play(int row, int col, int type) throws GomokuException {

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
