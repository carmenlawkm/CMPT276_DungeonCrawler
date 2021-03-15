package GameObjects;

import graphics.Assets;

import java.awt.*;

/**
 *Regular Reward class defines rewards players must collect to earn enough points to exit the level
 */
public class RegularReward extends RewardCell{

    /**
     * regular reward constructor
     * @param location defines the location of the reward
     * @param value defines points the player earns collecting the reward
     */
    RegularReward(Point location, int value) {
        super(location, value);
        this.image = Assets.regularReward;
    }

    @Override
    public void update() {

    }
}
