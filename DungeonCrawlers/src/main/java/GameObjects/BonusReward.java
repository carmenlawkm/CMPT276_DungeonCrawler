package GameObjects;

import graphics.Assets;

import java.awt.*;

public class BonusReward extends RewardCell{
    int disappearTimer;

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
