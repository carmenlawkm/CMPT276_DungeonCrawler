package World;

import graphics.Assets;

/**
 * Implements a normal default floor tile with no special meaning
 */
public class FloorTile extends Tile{

    /**
     * FloorTile constructor
     * @param id defines the type of tile (floor)
     */
    public FloorTile(int id) {
        super(Assets.floor, id);
    }
}
