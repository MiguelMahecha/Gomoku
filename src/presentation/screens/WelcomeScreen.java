package presentation.screens;

import javax.swing.*;

public class WelcomeScreen extends JPanel {
    public WelcomeScreen() {
        JButton hello = new JButton("Hello World");
        add(hello);
        setVisible(true);
    }
}
