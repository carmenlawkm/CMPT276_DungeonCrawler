package GameObjects;

import graphics.Assets;

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
    public RegularReward(Point location, int value, MainCharacter player) {
        super(location, value);
        this.image = Assets.regularReward;
        this.player=player;
    }

    @Override
    public void update() {
        if(player.getX()==location.x && player.getY()==location.y){
            player.score=player.score+value;
            this.image=Assets.rewardgone;
            value=0;
        }
        //System.out.println(player.score);

    }
}
