package GameObjects;

import graphics.Assets;

import java.awt.*;

public class BarrierCell extends GameObject{
    public BarrierCell(Point location) {
        super(location);
        this.image = Assets.barrier;
    }

    @Override
    public void update() {

    }
}
