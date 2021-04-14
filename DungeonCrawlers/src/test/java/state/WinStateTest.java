package state;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

class WinStateTest {
    private Game game;
    private WinState winState;


    @BeforeEach
    void setup() {
        game = Game.getInstance();
        winState = new WinState();
    }

    @Test
    void update() {
        winState.update();
        assertFalse(game.getRunning());
    }
}
