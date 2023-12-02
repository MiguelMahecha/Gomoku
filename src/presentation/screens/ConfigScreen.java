package presentation.screens;

import presentation.GomokuGUI;

import javax.swing.*;
import java.awt.*;

public class ConfigScreen extends JPanel {
    private GridBagConstraints gbc;
    private JButton pOneColorBtn, pTwoColorBtn, createGameBtn;
    private JTextField playerOneNameField, playerTwoNameField, boardSizeField;
    private Color p1Color, p2Color;
    private GomokuGUI gui;

    public ConfigScreen(GomokuGUI gui) {
        this.gui = gui;
        setLayout(new GridBagLayout());
        // Create constraints object for positioning components
        gbc = new GridBagConstraints();
        prepareElements();
        prepareActions();
    }

    private void prepareElements() {
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Create labels and add them to JPanel
        JLabel playerOneNameLabel = new JLabel("Player One:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(playerOneNameLabel, gbc);

        JLabel playerOneColorLabel = new JLabel("Player One Color:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(playerOneColorLabel, gbc);

        // Create text fields and add them to JPanel
        playerOneNameField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(playerOneNameField, gbc);

        this.pOneColorBtn = new JButton("Pick A Color");
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(this.pOneColorBtn, gbc);

        // Create labels and add them to JPanel
        JLabel playerTwoNameLabel = new JLabel("Player Two:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(playerTwoNameLabel, gbc);

        JLabel playerTwoColorLabel = new JLabel("Player Two Color:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(playerTwoColorLabel, gbc);

        // Create text fields and add them to JPanel
        playerTwoNameField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(playerTwoNameField, gbc);

        this.pTwoColorBtn = new JButton("PIck A Color");
        gbc.gridx = 1;
        gbc.gridy = 3;
        add(this.pTwoColorBtn, gbc);

        JLabel boardSizeLabel = new JLabel("Board Size:");
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(boardSizeLabel, gbc);

        boardSizeField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 4;
        add(boardSizeField, gbc);

        createGameBtn = new JButton("Start Game");
        gbc.gridx = 1;
        gbc.gridy = 5;
        add(createGameBtn, gbc);
    }

    private void prepareActions() {
        this.pOneColorBtn.addActionListener(ev -> {
            p1Color = JColorChooser.showDialog(this, "Color for Player One", Color.BLACK);
        });
        this.pTwoColorBtn.addActionListener(ev -> {
            p2Color = JColorChooser.showDialog(this, "Color for Player Two", Color.WHITE);
        });

        this.createGameBtn.addActionListener(ev -> {
            int size = Integer.parseInt(boardSizeField.getText());
            gui.createGame(playerOneNameField.getText(), p1Color, playerTwoNameField.getText(), p2Color, size);
        });
    }
}
