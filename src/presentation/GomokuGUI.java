package presentation;

import domain.Gomoku;
import presentation.screens.ConfigScreen;
import presentation.screens.GameScreen;
import presentation.screens.WelcomeScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class GomokuGUI extends JFrame {
    public static final String CONFIG_SCREEN = "config";
    public static final String GAME_SCREEN = "game";
    public static final String WELCOME_SCREEN = "welcome";
    private Gomoku gomoku;
    private JMenuItem newBtn, saveBtn, openBtn, exitBtn;
    private JPanel screens, gameScreen, configScreen, welcomeScreen;
    private CardLayout cardLayout;
    public GomokuGUI() {
        prepareElements();
        prepareActions();
        setVisible(true);
    }

    private void prepareElements() {
        setTitle("GomokuPOOs");
        setSize(1000, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        prepareElementsMenu();
        prepareElementsScreens();
    }

    private void prepareElementsMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu file = new JMenu("File");
        newBtn = new JMenuItem("New Game");
        saveBtn = new JMenuItem("Save Game");
        openBtn = new JMenuItem("Open Game");
        exitBtn = new JMenuItem("Exit Game");
        file.add(newBtn);
        file.add(saveBtn);
        file.add(openBtn);
        file.add(exitBtn);
        menuBar.add(file);
        setJMenuBar(menuBar);
    }

    private void prepareElementsScreens() {
        welcomeScreen = new WelcomeScreen();
        configScreen = new ConfigScreen();
        gameScreen = new GameScreen();
        cardLayout = new CardLayout();
        Container container = getContentPane();
        container.setLayout(cardLayout);

        container.add(welcomeScreen, WELCOME_SCREEN);
        container.add(configScreen, CONFIG_SCREEN);
        container.add(gameScreen, GAME_SCREEN);

        cardLayout.show(container, WELCOME_SCREEN);
    }

    private void prepareActions() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                exitDialog();
            }
        });
        
        prepareActionsMenu();
    }

    private void prepareActionsMenu() {
        newBtn.addActionListener(ev -> {
            cardLayout.show(getContentPane(), CONFIG_SCREEN);
        });

        saveBtn.addActionListener(ev -> {});

        openBtn.addActionListener(ev -> {});

        exitBtn.addActionListener(ev -> {
            exitDialog();
        });
    }

    private void exitDialog() {
        int result = JOptionPane.showConfirmDialog(null, "Exit Game?", getTitle(), JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) System.exit(0);
    }

    public static void main(String[] args) {
        GomokuGUI app = new GomokuGUI();
        app.setVisible(true);
    }
}
