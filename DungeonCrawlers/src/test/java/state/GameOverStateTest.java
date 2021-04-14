package state;

import org.junit.*;

import static org.junit.Assert.assertFalse;

public class GameOverStateTest {

    public Game game;
    public GameOverState gameOverState;

    @Before
    public void setup(){
        game = Game.getInstance();
        gameOverState = new GameOverState();
    }

    @Test
    public void update() {
        gameOverState.update();
        assertFalse(game.getRunning());
    }
}