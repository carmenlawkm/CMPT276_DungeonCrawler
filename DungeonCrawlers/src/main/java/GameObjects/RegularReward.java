package GameObjects;

import graphics.Assets;

import java.awt.*;

public class RegularReward extends RewardCell{

    RegularReward(Point location, int value) {
        super(location, value);
        this.image = Assets.regularReward;
    }

    @Override
    public void update() {

    }
}
