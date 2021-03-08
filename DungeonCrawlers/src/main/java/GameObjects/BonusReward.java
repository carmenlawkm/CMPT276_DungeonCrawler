package GameObjects;

import java.awt.*;

public class BonusReward extends RewardCell{
    int disappearTimer;

    BonusReward(Point location, ID id, int value, int disappearTimer) {
        super(location, id, value);
        this.disappearTimer = disappearTimer;
        this.setImage("/specialReward.png");
    }

    //methods
    public void startTimer(){
        //method to startTimer and countdown to when reward disappears
    }
}