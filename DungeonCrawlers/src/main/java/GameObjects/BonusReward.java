package GameObjects;

import graphics.Assets;

import java.awt.*;

/**
 * BonusReward class defines cells where bonus rewards appear
 * bonus rewards disappear after a set time and reward the player extra points upon collection
 */
public class BonusReward extends RewardCell{
    int disappearTimer;

    /**
     * BonusReward constructor
     * @param location defines the Point the bonus reward resides on the map
     * @param value defines the amount of points the player earns when collecting this reward
     * @param disappearTimer defines the amount of ticks the player has to collect the reward before it disappears
     */
    BonusReward(Point location, int value, int disappearTimer) {
        super(location, value);
        this.disappearTimer = disappearTimer;
        this.image = Assets.specialReward;

    }

    //methods
    public void startTimer(){
        //method to startTimer and countdown to when reward disappears
    }

    @Override
    public void update() {

    }
}
