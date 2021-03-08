package main.java.com.game.GameObjects;

import java.awt.*;

public class ExitCell extends GameObject {

    ExitCell(Point location, ID id) {
        super(location, id);
        this.setImage("/main/resources/exit.png");
    }
}
