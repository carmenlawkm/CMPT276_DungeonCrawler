package GameObjects;

import java.awt.*;

public abstract class RewardCell extends GameObject{
    int value;

    RewardCell(Point location, ID id, int value) {
        super(location, id);
        this.value = value;
        this.setImage("/regularReward.png");
    }
}
