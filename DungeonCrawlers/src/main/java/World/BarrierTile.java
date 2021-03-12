package World;

import graphics.Assets;

public class BarrierTile extends Tile {
    public BarrierTile(int id) {
        super(Assets.barrier, id);
    }

    @Override
    public boolean isWalkable() {
        return false;
    }
}
