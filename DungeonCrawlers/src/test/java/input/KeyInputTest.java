package input;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

import static org.junit.jupiter.api.Assertions.*;

class KeyInputTest {

    @Test
    void setKeyPressed() {
    }

    @Test
    void keyPressed() throws AWTException {
        Robot bot = new Robot();
        bot.keyPress(KeyEvent.VK_A);
    }

    @Test
    void getKeyCode() {
    }
}