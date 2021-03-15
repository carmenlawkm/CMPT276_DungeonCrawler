package GameObjects;
import graphics.Assets;
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
    RewardCell(Point location, int value) {
        super(location);
        this.value = value;
    }
    public void update(){

    }

}
