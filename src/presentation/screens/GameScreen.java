package presentation.screens;

import domain.Gomoku;
import domain.adapters.TileAdapter;

import javax.swing.*;
import java.awt.*;

public class GameScreen extends JPanel {
    private final Gomoku gomoku;
//    private GridBagConstraints gbc;
    private JPanel board;
    private JPanel gameInfo;
    private final JButton[][] buttons;
    private Dimension frameDimension;

    public GameScreen(Gomoku gomoku, Dimension dimension) {
        this.gomoku = gomoku;
        setLayout(new BorderLayout(gomoku.getBoard().length, gomoku.getBoard().length));
        buttons = new JButton[gomoku.getBoard().length][gomoku.getBoard().length];
        this.frameDimension = dimension;
        prepareElements();
    }

    public void prepareElements() {
        prepareElementsBoard();
        prepareElementsGameInfo();
    }

    private void prepareElementsBoard() {
        setLayout(new BorderLayout(gomoku.getBoard().length, gomoku.getBoard().length));
        board = new JPanel();
        board.setLayout(new GridLayout(gomoku.getBoard().length, gomoku.getBoard().length));
        board.setSize(new Dimension((int)frameDimension.getWidth() / 2, (int)frameDimension.getHeight()));

        for (int i = 0; i < gomoku.getBoard().length; i++) {
            for (int j = 0; j < gomoku.getBoard().length; j++) {
                JButton button = new JButton();
                int tileWidth = board.getWidth() / gomoku.getBoard().length;
                int tileHeight = board.getHeight() / gomoku.getBoard().length;
                int tileDim = Math.min(tileHeight, tileWidth);
                button.setPreferredSize(new Dimension(tileDim, tileDim));
                button.setBackground(Color.BLUE);
                buttons[i][j] = button;
                board.add(button);
            }
        }
        board.setVisible(true);
        add(board);
    }

    private void prepareElementsGameInfo() {
        gameInfo = new JPanel();
        gameInfo.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;

        JLabel playerOne = new JLabel(String.format("%s", gomoku.getPlayerOne().name()));
        gbc.gridy = 0;
        gameInfo.add(playerOne, gbc);
        JLabel playerTwo = new JLabel(String.format("%s", gomoku.getPlayerTwo().name()));
        gbc.gridy = 1;
        gameInfo.add(playerTwo, gbc);
        gameInfo.setVisible(true);
        add(gameInfo);
    }
}
