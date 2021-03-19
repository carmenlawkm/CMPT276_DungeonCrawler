package GameObjects;
import World.World;
import graphics.Assets;
import state.Game;

import java.awt.*;

/**
 * RewardCell defines reward interface
 * to be used by regular and bonus reward objects
 */
public abstract class RewardCell extends GameObject{
    int value;

    /**
     * RewardCell constructor
     * @param location defines the location of the reward
     * @param value defines the points the player earns when collecting the reward
     */
    RewardCell(Game game, World world, Point location, int value) {
        super(game, world, location);
        this.value = value;
    }


}
