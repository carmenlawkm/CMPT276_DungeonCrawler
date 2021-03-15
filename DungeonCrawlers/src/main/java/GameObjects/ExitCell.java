package GameObjects;

import graphics.Assets;

import java.awt.*;

/**
 * ExitCell defines cell the player must touch to complete the level
 */
public class ExitCell extends GameObject {

    /**
     * ExitCell constructor
     * @param location defines the location of the exit cell on the map
     */
    ExitCell(Point location) {
        super(location);
        this.image = Assets.exit;
    }

    @Override
    public void update() {

    }
}
