package state;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class StateTest {
    private Game game;
    private WinState winState;


    @Before
    public void setup() {
        game = Game.getInstance();
        winState = new WinState();
    }

    @After
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
    public void setState() {
        State state = new MenuState();
        State.setState(state);
        assertEquals(state, State.getState());
    }
}
