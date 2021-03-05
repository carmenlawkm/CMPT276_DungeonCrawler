package main.java.com.game.GameObjects;

import java.awt.*;

public class RegularReward extends RewardCell{
    int disappearTimer;

    RegularReward(Image image, Point location, ID id, int value, int disappearTimer) {
        super(image, location, id, value);
        this.disappearTimer = disappearTimer;
    }

    //methods
    public void startTimer(){
        //method to startTimer and countdown to when reward disappears
    }

}
