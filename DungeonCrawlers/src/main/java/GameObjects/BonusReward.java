package GameObjects;

import World.World;
import graphics.Assets;

import java.awt.*;

/**
 * BonusReward class defines cells where bonus rewards appear
 * bonus rewards disappear after a set time and reward the player extra points upon collection
 */
public class BonusReward extends RewardCell{
    int disappearTimer;
    MainCharacter player;

    /**
     * BonusReward constructor
     * @param location defines the Point the bonus reward resides on the map
     * @param value defines the amount of points the player earns when collecting this reward
     * @param disappearTimer defines the amount of ticks the player has to collect the reward before it disappears
     */
    public BonusReward(World world, Point location, int value, int disappearTimer, MainCharacter player) {
        super(world, location, value);
        this.disappearTimer = disappearTimer;
        this.image = Assets.specialReward;
        this.player=player;

    }


    @Override
    public void update() {
        if(disappearTimer==5){
            this.image = Assets.rewardgone;
        }
        if(player.getX()==location.x && player.getY()==location.y){
            player.score=player.score+value;
            this.image=Assets.rewardgone;
            value=0;
        }
        System.out.println(player.score);
        disappearTimer++;

    }
}
