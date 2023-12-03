package presentation;

import domain.Gomoku;
import domain.GomokuException;
import domain.adapters.ColorAdapter;
import domain.adapters.PlayerAdapter;
import presentation.screens.ConfigScreen;
import presentation.screens.GameScreen;
import presentation.screens.WelcomeScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Objects;

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
        configScreen = new ConfigScreen(this);
        cardLayout = new CardLayout();
        Container container = getContentPane();
        container.setLayout(cardLayout);

        container.add(welcomeScreen, WELCOME_SCREEN);
        container.add(configScreen, CONFIG_SCREEN);

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

    public void createGame(String p1Name, Color p1Color, String p2Name, Color p2Color, int size) {
        try {
            ColorAdapter p1ColorAdapter = new ColorAdapter(p1Color.getRed(), p1Color.getGreen(), p1Color.getBlue());
            ColorAdapter p2ColorAdapter = new ColorAdapter(p2Color.getRed(), p2Color.getGreen(), p2Color.getBlue());
            PlayerAdapter p1 = new PlayerAdapter(p1Name, p1ColorAdapter, 0, 0, size*size, true);
            PlayerAdapter p2 = new PlayerAdapter(p2Name, p2ColorAdapter, 0, 0, size*size, true);
            gomoku = new Gomoku(p1, p2, size);
            gameScreen = new GameScreen(gomoku, getSize());
            getContentPane().add(gameScreen, GAME_SCREEN);
            cardLayout.show(getContentPane(), GAME_SCREEN);
        } catch (GomokuException e) {
            errorMessage(e.getMessage());
        }
    }

    private void errorMessage(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }

    private void exitDialog() {
        int result = JOptionPane.showConfirmDialog(null, "Exit Game?", getTitle(), JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) System.exit(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GomokuGUI app = new GomokuGUI();
            app.setVisible(true);
        });
    }
}
