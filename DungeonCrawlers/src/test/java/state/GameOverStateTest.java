package state;

import org.junit.*;

import static org.junit.jupiter.api.Assertions.*;

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