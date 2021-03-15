package GameObjects;

import graphics.Assets;

import java.awt.*;

/**
 * BarrierCell class defines barrier locations on the map
 * Does not allow player to walk to these cell locations
 */

public class BarrierCell extends GameObject{
    /**
     * Barrier constructor
     * @param location defines the Point the barrier exists on the map
     */
    public BarrierCell(Point location) {
        super(location);
        this.image = Assets.barrier;
    }

    @Override
    public void update() {

    }
}