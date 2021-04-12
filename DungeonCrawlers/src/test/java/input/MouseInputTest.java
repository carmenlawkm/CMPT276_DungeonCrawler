package input;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;

import static org.junit.jupiter.api.Assertions.*;

class MouseInputTest {


    @Test
    void shouldSetMousePressed() throws AWTException{
        Robot bot = new Robot();
        MouseInput m = new MouseInput();
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        assertEquals(true,m.isLeftPressed());

    }

    @Test
    void shouldSetMouseReleased() throws AWTException{
        Robot bot = new Robot();
        MouseInput m = new MouseInput();
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        assertEquals(false,m.isLeftPressed());
    }


    @Test
    void mouseMoved() throws AWTException{
        MouseInput m = new MouseInput();
        JPanel frame = new JPanel();
        frame.addMouseListener(m);
        MouseEvent mouseEvent = new MouseEvent(frame, 0,0, 0, 100, 100, 0,false);
        m.mouseMoved(mouseEvent);
        assertEquals(100,m.getMouseX());
        assertEquals(100,m.getMouseY());
    }
}