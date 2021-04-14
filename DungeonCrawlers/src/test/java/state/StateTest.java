package state;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StateTest {
    private Game game;
    private WinState winState;


    @BeforeEach
    void setup() {
        game = Game.getInstance();
        winState = new WinState();
    }

    @AfterEach
    void teardown() {
        State.setState(null);
    }

    @Test
    void update() {
        winState.update();
        assertFalse(game.getRunning());
    }

    @Test
    void getState() {
        assertNull(State.getState());
    }

    @Test
    void setState() {
        State state = new MenuState();
        State.setState(state);
        assertEquals(state, State.getState());
    }
}
