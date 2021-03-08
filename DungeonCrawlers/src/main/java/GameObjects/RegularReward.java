package GameObjects;

import java.awt.*;

public class RegularReward extends RewardCell{

    RegularReward(Point location, ID id, int value) {
        super(location, id, value);
        this.setImage("/regularReward.png");
    }

}

