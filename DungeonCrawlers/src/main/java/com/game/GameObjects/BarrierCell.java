package main.java.com.game.GameObjects;

import java.awt.*;

public class BarrierCell extends GameObject{
    public BarrierCell(Point location, ID id) {
        super(location, id);
        this.setImage("/main/resources/barrier.png");
    }
}
