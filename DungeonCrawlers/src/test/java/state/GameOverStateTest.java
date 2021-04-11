package state;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameOverStateTest {

    public Game game;
    public GameOverState gameOverState;

    @BeforeEach
    void setup(){
        game = Game.getInstance();
        gameOverState = new GameOverState();
    }

    @Test
    void update() {
        gameOverState.update();
        assertFalse(game.getRunning());
    }
}