package input;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;

import static org.junit.jupiter.api.Assertions.*;

class MouseInputTest {
    //private Robot bot;
    private MouseInput m;

//    @BeforeEach
//    void setUp() throws AWTException{
//        Robot bot = new Robot();
//        m = new MouseInput();
//    }

    @Test
    void shouldGetLeftPressed() throws AWTException{

    }

    @Test
    void shouldSetMousePressed() throws AWTException{
        Robot bot = new Robot();
        MouseInput m = new MouseInput();
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        assertEquals(true,m.isLeftPressed());

    }

//    @Test
//    void shouldSetMouseReleased() {
//        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//    }
//
//
//    @Test
//    void mouseMoved() {
//        bot.mouseMove(100, 100);
//    }
}