package World;

import graphics.Assets;

/**
 * BarrierTile class defines a trap type of tile
 */

public class SpawnTile extends Tile{

    /**
     * TrapTile constructor
     * @param id defines the type of barrier
     */
    public SpawnTile(int id) {
        super(Assets.spawn, id);
    }
}
