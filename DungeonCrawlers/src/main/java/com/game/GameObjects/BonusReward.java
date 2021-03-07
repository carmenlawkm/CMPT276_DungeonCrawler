package main.java.com.game.GameObjects;

import java.awt.*;

public class BonusReward extends RewardCell{
    int disappearTimer;

    BonusReward(String image, Point location, ID id, int value, int disappearTimer) {
        super(image, location, id, value);
        this.disappearTimer = disappearTimer;
    }

    //methods
    public void startTimer(){
        //method to startTimer and countdown to when reward disappears
    }
}
