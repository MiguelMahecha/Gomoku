package presentation.screens;

import javax.swing.*;
import java.awt.*;

public class ConfigScreen extends JPanel {
    GridBagConstraints gbc;
    JButton pOneColorBtn, pTwoColorBtn;

    public ConfigScreen() {
        setLayout(new GridBagLayout());
        // Create constraints object for positioning components
        gbc = new GridBagConstraints();
        prepareElements();
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
        JTextField playerOneNameField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(playerOneNameField, gbc);

        JColorChooser playerOneColorField = new JColorChooser();
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(playerOneColorField, gbc);

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
        JTextField playerTwoNameField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(playerTwoNameField, gbc);

        JColorChooser playerTwoColorField = new JColorChooser();
        gbc.gridx = 1;
        gbc.gridy = 3;
        add(playerTwoColorField, gbc);
    }
}
