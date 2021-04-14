package state;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;


public class WinStateTest {
    private Game game;
    private WinState winState;


    @Before
    public void setup() {
        game = Game.getInstance();
        winState = new WinState();
    }

    @Test
    public void update() {
        winState.update();
        assertFalse(game.getRunning());
    }
}
