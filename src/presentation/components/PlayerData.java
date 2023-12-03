package presentation.components;

import domain.adapters.PlayerAdapter;

import javax.swing.*;
import java.awt.*;

public class PlayerData extends JPanel {
    private final GridBagConstraints gbc;
    public PlayerData(PlayerAdapter player) {
        setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        refresh(player);
    }

    public void refresh(PlayerAdapter player) {
        JLabel playerName = new JLabel(String.format("%s", player.name()));
        gbc.gridy = 0;
        add(playerName, gbc);
        JLabel playerStones = new JLabel(String.format("Stones left: %d", player.stonesLeft()));
        gbc.gridy = 1;
        add(playerStones, gbc);
        JLabel playerTime = new JLabel(String.format("Time: %d", player.time()));
        gbc.gridy = 2;
        add(playerTime, gbc);
        JLabel playerScore = new JLabel(String.format("Score: %d", player.score()));
        gbc.gridy = 3;
        add(playerScore, gbc);
    }
}
