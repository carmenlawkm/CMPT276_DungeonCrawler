package World;

import graphics.Assets;

/**
 * ExitTile class defines the tile the player must reach to exit the level
 */
public class ExitTile extends Tile{

    /**
     * ExitTile constructor
     * @param id defines the type of tile this is
     */
    public ExitTile(int id) {
        super(Assets.exit, id);
    }
}
