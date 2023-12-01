package domain;

import domain.adapters.ColorAdapter;
import domain.adapters.PlayerAdapter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NormalGameTest {
    private Gomoku game;
    private int size;
    private ColorAdapter colorPlayer1;
    private ColorAdapter colorPlayer2;
    private PlayerAdapter p1;
    private PlayerAdapter p2;
    @BeforeEach
    public void setup() {
        int size = 10;
        colorPlayer1 = new ColorAdapter(0, 0,0);
        colorPlayer2 = new ColorAdapter(205, 59, 59);
        p1 = new PlayerAdapter("Miguel", colorPlayer1, 0, 1000, size*size, true);
        p2 = new PlayerAdapter("Daira", colorPlayer2, 0, 1000, size*size, false);
    }

    @Test
    public void shouldCreateAGameWithValidSettings() {
        try {
            game = new Gomoku(p1, p2, size);
            assertEquals(Gomoku.NORMAL, game.getType());
            assertEquals(p1, game.getCurrentPlayer());
            assertEquals(size, game.getBoard().length);
        } catch (GomokuException e) {
            fail("Creation Failed: " + e.getMessage());
        }
    }

    @Test
    public void shouldFindPlayerByColor() {
        try {
            game = new Gomoku(p1, p2, size);
            PlayerAdapter p_1 = game.getPlayerByColor(colorPlayer1);
            assertEquals(p1, p_1);
            PlayerAdapter p_2 = game.getPlayerByColor(colorPlayer2);
            assertEquals(p2, p_2);
        } catch (GomokuException e) {
            fail("Threw exception: " + e.getMessage());
        }
    }

    @Test
    public void shouldFailIfSearchingForNonExistentPlayerColor() {
        GomokuException exception = assertThrows(GomokuException.class, () -> {
            game = new Gomoku(p1, p2, size);
            PlayerAdapter p = game.getPlayerByColor(new ColorAdapter(1, 2, 3));
        });

        assertTrue(exception.getMessage().contains(GomokuException.NO_PLAYER_WITH_COLOR));
    }
}
