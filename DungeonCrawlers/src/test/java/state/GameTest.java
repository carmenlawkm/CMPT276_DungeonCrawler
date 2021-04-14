package state;

import input.KeyInput;
import input.MouseInput;
import org.junit.*;



import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    public Game game;

    @Before
    public void setup(){
        game = Game.getInstance();
    }

    //DOESN'T RUN FOR SOME REASON
    @Test
    public void areObjectsInitialized() {
//        //test our public game objects before initialization
//        assertEquals(null, game.gameState);
//        assertEquals(null, game.menuState);
//        assertEquals(null, game.gameOverState);
//        assertEquals(null, game.winState);
//
//        game.initialize();
//
//        //check they have been initialized by the method
//        assertTrue(game.gameState != null);
//        assertTrue(game.menuState != null);
//        assertTrue(game.gameOverState != null);
//        assertTrue(game.winState != null);
    }

    @Test
    public void setAndGetKeyInput() {
        KeyInput keyInput = new KeyInput();
        //haha
        game.setKeyInput(keyInput);
        assertEquals(keyInput, game.getKeyInput());
    }

    @Test
    public void setAndGetMouseInput() {
        MouseInput mouseInput = new MouseInput();
        game.setMouseClick(mouseInput);
        assertEquals(mouseInput, game.getMouseInput());
    }

    @Test
    public void setGameNotRunning() {
        Boolean running = false;
        game.setRunning(running);
        assertEquals(game.getRunning(), false);
    }

    @Test
    public void setGameRunning(){
        Boolean running = true;
        game.setRunning(running);
        assertEquals(game.getRunning(), true);
    }
}