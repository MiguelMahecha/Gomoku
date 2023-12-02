package domain;

import domain.adapters.ColorAdapter;
import domain.adapters.PlayerAdapter;
import domain.adapters.TileAdapter;
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
        size = 10;
        colorPlayer1 = new ColorAdapter(0, 0, 0);
        colorPlayer2 = new ColorAdapter(205, 59, 59);
        p1 = new PlayerAdapter("Miguel", colorPlayer1, 0, 0, size * size, true);
        p2 = new PlayerAdapter("Daira", colorPlayer2, 0, 0, size * size, false);
    }

    /*
  / ____|  __ \|  ____|   /\|__   __|_   _/ __ \| \ | |
 | |    | |__) | |__     /  \  | |    | || |  | |  \| |
 | |    |  _  /|  __|   / /\ \ | |    | || |  | | . ` |
 | |____| | \ \| |____ / ____ \| |   _| || |__| | |\  |
  \_____|_|  \_\______/_/    \_\_|  |_____\____/|_| \_|
   */
    @Test
    public void shouldCreateAGameWithValidSize() {
        try {
            game = new Gomoku(p1, p2, size);
            assertEquals(size, game.getBoard().length);
        } catch (GomokuException e) {
            fail("Creation Failed: " + e.getMessage());
        }
    }

    @Test
    public void shouldNotCreateGameWithInvalidSize() {
        Exception negativeSize = assertThrows(GomokuException.class, () -> {
            game = new Gomoku(p1, p2, -5);
        });

        Exception sizeTooBig = assertThrows(GomokuException.class, () -> {
            game = new Gomoku(p1, p2, 100);
        });

        assertTrue(negativeSize.getMessage().contains(GomokuException.INVALID_BOARD_SIZE));
        assertTrue(sizeTooBig.getMessage().contains(GomokuException.INVALID_BOARD_SIZE));
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

    @Test
    public void shouldCorrectlyInitPlayerScore() {
        p1 = new PlayerAdapter("Miguel", colorPlayer1, 10, 0, size * size, true);
        try {
            game = new Gomoku(p1, p2, size);
            assertEquals(0, game.getCurrentPlayer().score());
        } catch (GomokuException e) {
            fail("Threw exception");
        }
    }

    @Test
    public void shouldCorrectlyInitPlayerTime() {
        p1 = new PlayerAdapter("Miguel", colorPlayer1, 0, 10, size * size, true);
        try {
            game = new Gomoku(p1, p2, size);
            assertEquals(0, game.getCurrentPlayer().time());
        } catch (GomokuException e) {
            fail("Threw exception");
        }
    }

    @Test
    public void shouldCorrectlyInitPlayerNumStones() {
        p1 = new PlayerAdapter("Miguel", colorPlayer1, 0, 0, 19, true);
        try {
            game = new Gomoku(p1, p2, size);
            assertEquals(size*size, game.getCurrentPlayer().stonesLeft());
        } catch (GomokuException e) {
            fail("Threw exception");
        }
    }

//    PLAY!

    @Test
    public void shouldPlaceStoneAtValidTile() {
        try {
            game = new Gomoku(p1, p2, size);
            game.play(0, 1, "normal");
            TileAdapter[][] board = game.getBoard();
            assertNotNull(board[0][1].stone());
            assertEquals("normal", board[0][1].stone().type());
        } catch (GomokuException e) {
            fail("Threw Exception");
        }
    }

    @Test
    public void shouldNotPlaceStoneAtValidTile() {
        try {
            game = new Gomoku(p1, p2, size);
            game.play(-3, 1, "normal");
            fail("Did not throw exception");
        } catch (GomokuException e) {
            assertEquals(GomokuException.INVALID_MOVE, e.getMessage());
        }
    }

    @Test
    public void shouldNotPlaceStoneOfInvalidType() {
        try {
            game = new Gomoku(p1, p2, size);
            game.play(-3, 1, "weird");
            fail("Did not throw exception");
        } catch (GomokuException e) {
            assertEquals(GomokuException.NOT_VALID_STONE_TYPE, e.getMessage());
        }
    }
}
