package input;

import org.junit.Test;

import javax.swing.*;
import java.awt.event.MouseEvent;
import static org.junit.Assert.assertEquals;

public class MouseInputTest {
    @Test
    public void clickAndReleasingLeftClick(){
        MouseInput m = new MouseInput();
        JPanel frame = new JPanel();
        frame.addMouseListener(m);
        //testing left click
        MouseEvent mouseEvent = new MouseEvent(frame,MouseEvent.MOUSE_CLICKED, 0,MouseEvent.BUTTON1_MASK, 100, 100, 1,false);
        m.mousePressed(mouseEvent);
        assertEquals(true,m.isLeftPressed());

        //testing change to release for left
        mouseEvent = new MouseEvent(frame,MouseEvent.MOUSE_RELEASED, 0,MouseEvent.BUTTON1_MASK, 100, 100, 1,false);
        m.mouseReleased(mouseEvent);
        assertEquals(false,m.isLeftPressed());
    }

    @Test
    public void clickAndReleasingRightClick(){
        MouseInput m = new MouseInput();
        JPanel frame = new JPanel();
        frame.addMouseListener(m);

        //testing right click
        MouseEvent mouseEvent = new MouseEvent(frame,MouseEvent.MOUSE_CLICKED, 0,MouseEvent.BUTTON3_MASK, 100, 100, 1,false);
        m.mousePressed(mouseEvent);
        assertEquals(true,m.isRightPressed());

        //testing change to release for right
        mouseEvent = new MouseEvent(frame,MouseEvent.MOUSE_RELEASED, 0,MouseEvent.BUTTON3_MASK, 100, 100, 1,false);
        m.mouseReleased(mouseEvent);
        assertEquals(false,m.isRightPressed());
    }

    @Test
    public void shouldSetMouseXandY(){
        MouseInput m = new MouseInput();
        JPanel frame = new JPanel();
        frame.addMouseListener(m);
        MouseEvent mouseEvent = new MouseEvent(frame, 0,0, 0, 100, 100, 0,false);
        m.mouseMoved(mouseEvent);
        assertEquals(100,m.getMouseX());
        assertEquals(100,m.getMouseY());
    }
}