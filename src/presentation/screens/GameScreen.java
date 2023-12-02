package presentation.screens;

import domain.Gomoku;
import domain.adapters.TileAdapter;

import javax.swing.*;
import java.awt.*;

public class GameScreen extends JPanel {
    private final Gomoku gomoku;
    private JPanel board;
    private JPanel gameInfo;
    private final JButton[][] buttons;
    private Dimension frameDimension;
    private GridBagConstraints gbc;

    public GameScreen(Gomoku gomoku, Dimension dimension) {
        this.gomoku = gomoku;
        setLayout(new GridBagLayout());
        this.gbc = new GridBagConstraints();
        buttons = new JButton[gomoku.getBoard().length][gomoku.getBoard().length];
        this.frameDimension = dimension;
        prepareElements();
    }

    public void prepareElements() {
        prepareElementsBoard();
        prepareElementsGameInfo();
    }

    private void prepareElementsBoard() {
//        setLayout(new BorderLayout(gomoku.getBoard().length, gomoku.getBoard().length));
        board = new JPanel();
        board.setLayout(new GridBagLayout());
        board.setSize(new Dimension((int)frameDimension.getWidth() / 2, (int)frameDimension.getHeight()));
        GridBagConstraints gbc = new GridBagConstraints();
        for (int i = 0; i < gomoku.getBoard().length; i++) {
            for (int j = 0; j < gomoku.getBoard().length; j++) {
                JButton button = new JButton();
                int tileWidth = board.getWidth() / gomoku.getBoard().length;
                int tileHeight = board.getHeight() / gomoku.getBoard().length;
                int tileDim = Math.min(tileHeight, tileWidth);
                button.setSize(new Dimension(tileDim, tileDim));
                button.setBackground(Color.BLUE);
                int preferredSize = Math.min(board.getWidth() / gomoku.getBoard().length, board.getHeight() / gomoku.getBoard().length);
                gbc.gridx = j;
                gbc.gridy = i;
                gbc.fill = GridBagConstraints.BOTH;
                gbc.weightx = 1.0;
                gbc.weighty = 1.0;
                gbc.insets = new Insets(2, 2, 2, 2);
                button.setPreferredSize(new Dimension(preferredSize, preferredSize));
                buttons[i][j] = button;
                board.add(button, gbc);
            }
        }
        board.setVisible(true);
        this.gbc.gridx = 0;
        this.gbc.weightx = 0.7;
        add(board, this.gbc);
    }

    private void prepareElementsGameInfo() {
        gameInfo = new JPanel();
        gameInfo.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(1, 1, 1, 1);

        JLabel playerOne = new JLabel(String.format("%s", gomoku.getPlayerOne().name()));
        gbc.gridy = 0;
        gameInfo.add(playerOne, gbc);
        JLabel playerTwo = new JLabel(String.format("%s", gomoku.getPlayerTwo().name()));
        gbc.gridy = 1;
        gameInfo.add(playerTwo, gbc);

        gameInfo.setVisible(true);
        this.gbc.gridx = 1;
        this.gbc.weightx = 0.3;
        add(gameInfo, this.gbc);
    }
}
