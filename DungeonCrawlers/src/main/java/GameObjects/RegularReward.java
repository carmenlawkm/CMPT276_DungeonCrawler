package GameObjects;

import World.World;
import graphics.Assets;
import state.Game;

import java.awt.*;

/**
 *Regular Reward class defines rewards players must collect to earn enough points to exit the level
 */
public class RegularReward extends RewardCell{
    MainCharacter player;
    /**
     * regular reward constructor
     * @param location defines the location of the reward
     * @param value defines points the player earns collecting the reward
     */
    public RegularReward(World world, Point location, int value, MainCharacter player) {
        super(world, location, value);
        this.image = Assets.regularReward;
        this.player=player;
    }

    /**
     * update the status of regular rewards
     * Checks if taken by player
     */
    public void update() {
        if(player.getX()==location.x && player.getY()==location.y && notTaken){
            player.score=player.score+value;
            this.image=Assets.rewardgone;
            value=0;
            notTaken = false;
            player.addRewardCount();
        }

    }

}
