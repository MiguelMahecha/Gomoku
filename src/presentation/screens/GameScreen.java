package presentation.screens;

import domain.Gomoku;

import javax.swing.*;

public class GameScreen extends JPanel {
    private Gomoku gomoku;
    public GameScreen(Gomoku gomoku) {
        this.gomoku = gomoku;
        JButton game = new JButton("Game!!!");
        add(game);
    }
}
