package input;

import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.event.KeyEvent;
import static org.junit.jupiter.api.Assertions.assertEquals;


class KeyInputTest {

    @Test
    void shouldSetKeyPressed() {
        KeyInput k = new KeyInput();
        //setting to true
        k.setKeyPressed(true);
        assertEquals(true,k.getKeyPressed());
        //setting to false
        k.setKeyPressed(false);
        assertEquals(false,k.getKeyPressed());
    }

    @Test
    void shouldStoreKeyPressed(){
        KeyInput k = new KeyInput();
        JPanel frame = new JPanel();
        frame.addKeyListener(k);
        //testing any keys pressed
        KeyEvent keyEvent = new KeyEvent(frame,KeyEvent.KEY_PRESSED,0,0, KeyEvent.VK_W);
        k.keyPressed(keyEvent);
        assertEquals(KeyEvent.VK_W,k.getKeyCode());
        assertEquals(true,k.getKeyPressed());

    }

}