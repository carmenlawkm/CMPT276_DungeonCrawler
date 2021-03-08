package GameObjects;

import java.awt.*;

public class Enemy extends GameObject{
    private int deductionValue;

    public Enemy(Point location, ID id, int deductionValue) {
        super(location, id);
        this.deductionValue = deductionValue;
        this.setImage("/enemy.png");
    }

    void setDeductionValue(int value){
        deductionValue = value;
    }

    public void moveTowardsPlayer(Point playerLocation){
        //method to move towards player point
    }
}

