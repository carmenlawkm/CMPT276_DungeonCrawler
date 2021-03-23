package World;

import graphics.Assets;

/**
 * BarrierTile class defines a trap type of tile
 */

public class TrapTile extends Tile{

    /**
     * TrapTile constructor
     * @param id defines the type of barrier
     */
    public TrapTile(int id) {
        super(Assets.trap, id);
    }
}
