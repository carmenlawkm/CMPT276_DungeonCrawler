package GameObjects;

import graphics.Assets;

import java.awt.*;

public class ExitCell extends GameObject {

    ExitCell(Point location) {
        super(location);
        this.image = Assets.exit;
    }

    @Override
    public void update() {

    }
}
