package presentation.screens;

import domain.Gomoku;
import domain.GomokuException;
import domain.Tile;
import domain.adapters.ColorAdapter;
import domain.adapters.TileAdapter;
import presentation.components.PlayerData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameScreen extends JPanel {
    private final Gomoku gomoku;
    private JPanel board;
    private JPanel gameInfo;
    private final JButton[][] buttons;
    private Dimension frameDimension;
    private GridBagConstraints gbc;
    private JLabel playerOne, playerOneStones, playerOneTime, playerOneScore;
    private JLabel playerTwo, playerTwoStones, playerTwoTime, playerTwoScore;

    public GameScreen(Gomoku gomoku, Dimension dimension) {
        this.gomoku = gomoku;
        setLayout(new GridBagLayout());
        this.gbc = new GridBagConstraints();
        buttons = new JButton[gomoku.getBoard().length][gomoku.getBoard().length];
        this.frameDimension = dimension;
        prepareElements();
        prepareActions();
    }

    public void prepareElements() {
        prepareElementsBoard();
        prepareElementsGameInfo();
    }

    private void prepareElementsBoard() {
        board = new JPanel();
        board.setLayout(new GridBagLayout());
        board.setSize(new Dimension((int)frameDimension.getWidth() / 2, (int)frameDimension.getHeight()));
        GridBagConstraints gbc = new GridBagConstraints();
        TileAdapter[][] tiles = gomoku.getBoard();
        for (int i = 0; i < gomoku.getBoard().length; i++) {
            for (int j = 0; j < gomoku.getBoard().length; j++) {
                JButton button = new JButton();
                button.setBackground(Color.BLUE);
                int preferredSize = Math.min(board.getWidth() / gomoku.getBoard().length, board.getHeight() / gomoku.getBoard().length);
                gbc.gridx = j;
                gbc.gridy = i;
                gbc.fill = GridBagConstraints.BOTH;
                gbc.weightx = 1.0;
                gbc.weighty = 1.0;
                button.setPreferredSize(new Dimension(preferredSize, preferredSize));
                if (tiles[i][j].stone() != null) {
                    ColorAdapter color = tiles[i][j].stone().color();
                    Color c = new Color(color.r(), color.g(), color.b());
                    button.setBackground(c);
                }
                buttons[i][j] = button;
                board.add(button, gbc);
            }
        }
        board.setVisible(true);
        this.gbc.gridx = 0;
        this.gbc.weightx = 0.7;
        add(board, this.gbc);
    }

    private void prepareActions() {
        prepareActionsBoard();
    }

    private void prepareActionsBoard() {
        for (int i = 0; i < gomoku.getBoard().length; i++) {
            for (int j = 0; j < gomoku.getBoard().length; j++) {
                final int row = i;
                final int col = j;
                buttons[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            gomoku.play(row, col, "normal");
                            refreshGameInfo();
                            refreshBoard();
                        } catch (GomokuException err) {
                            errorMessage(err.getMessage());
                        }
                    }
                });
            }
        }
    }

    private void refreshBoard() {
        TileAdapter[][] tiles = gomoku.getBoard();
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons.length; j++) {
                if (tiles[i][j].stone() != null) {
                    ColorAdapter color = tiles[i][j].stone().color();
                    Color c = new Color(color.r(), color.g(), color.b());
                    buttons[i][j].setBackground(c);
                }
            }
        }
    }

    private void prepareElementsGameInfo() {
        gameInfo = new JPanel();
        gameInfo.setLayout(new GridBagLayout());

        refreshGameInfo();

        gameInfo.setVisible(true);
        this.gbc.gridx = 1;
        this.gbc.weightx = 0.3;
        add(gameInfo, this.gbc);
    }

    private void refreshGameInfo() {
        GridBagConstraints gbc = new GridBagConstraints();
        JPanel playerOne = new PlayerData(gomoku.getPlayerOne());
        JPanel playerTwo = new PlayerData(gomoku.getPlayerTwo());
        gbc.gridy = 0;
        gameInfo.add(playerOne, gbc);
        gbc.gridy = 1;
        gameInfo.add(playerTwo, gbc);
    }

    private void errorMessage(String msg) {
        JOptionPane.showMessageDialog(null, String.format("Error: %s", msg));
    }
}
