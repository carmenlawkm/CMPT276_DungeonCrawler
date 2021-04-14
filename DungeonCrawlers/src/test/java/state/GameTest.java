package state;

import input.KeyInput;
import input.MouseInput;
import org.junit.*;


import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    public Game game;

    @Before
    public void setup(){
        game = Game.getInstance();
    }

    @Test
    public void setAndGetKeyInput() {
        //create arbiturary key event
        KeyInput k = new KeyInput();
        JPanel frame = new JPanel();
        frame.addKeyListener(k);
        //testing any keys pressed
        KeyEvent keyEvent = new KeyEvent(frame,KeyEvent.KEY_PRESSED,0,0, KeyEvent.VK_W);
        k.keyPressed(keyEvent);

        //set
        game.setKeyInput(k);
        //get
        assertEquals(k, game.getKeyInput());
    }

    @Test
    public void setAndGetMouseInput() {
        //create arbrituary mouse event
        MouseInput m = new MouseInput();
        JPanel frame = new JPanel();
        frame.addMouseListener(m);
        MouseEvent mouseEvent = new MouseEvent(frame, 0,0, 0, 100, 100, 0,false);
        m.mouseMoved(mouseEvent);

        //set
        game.setMouseClick(m);
        //get
        assertEquals(m, game.getMouseInput());
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