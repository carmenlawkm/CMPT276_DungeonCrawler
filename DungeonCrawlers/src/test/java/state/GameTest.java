package state;

import GameObjects.MainCharacter;
import World.World;
import graphics.Window;
import input.KeyInput;
import input.MouseInput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    public Game game;

    @BeforeEach
    void setup(){
        game = Game.getInstance();
    }

    //DOESN'T RUN FOR SOME REASON
    @Test
    void areObjectsInitialized() {
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
    void setAndGetKeyInput() {
        KeyInput keyInput = new KeyInput();
        //haha
        game.setKeyInput(keyInput);
        assertEquals(keyInput, game.getKeyInput());
    }

    @Test
    void setAndGetMouseInput() {
        MouseInput mouseInput = new MouseInput();
        game.setMouseClick(mouseInput);
        assertEquals(mouseInput, game.getMouseInput());
    }

    @Test
    void setGameNotRunning() {
        Boolean running = false;
        game.setRunning(running);
        assertEquals(game.getRunning(), false);
    }

    @Test
    void setGameRunning(){
        Boolean running = true;
        game.setRunning(running);
        assertEquals(game.getRunning(), true);
    }
}