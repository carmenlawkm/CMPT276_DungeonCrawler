package World;

import graphics.Assets;

/**
 * BarrierTile class defines a barrier type of tile
 */

public class BarrierTile extends Tile {
    /**
     * BarrierTile constructor
     * @param id defines the type of barrier
     */
    public BarrierTile(int id) {
        super(Assets.barrier, id);
    }

    /**
     * @return if BarrierTile is walkable, which it is not
     */
    @Override
    public boolean isWalkable() {
        return false;
    }
}
