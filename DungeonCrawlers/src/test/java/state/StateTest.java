package state;

import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StateTest {
    private Game game;
    private WinState winState;


    @Before
    public void setup() {
        game = Game.getInstance();
        winState = new WinState();
    }

    @AfterEach
    public void teardown() {
        State.setState(null);
    }

    @Test
    public void update() {
        winState.update();
        assertFalse(game.getRunning());
    }

    @Test
    public void getState() {
        assertNull(State.getState());
    }

    @Test
    void setState() {
        State state = new MenuState();
        State.setState(state);
        assertEquals(state, State.getState());
    }
}
