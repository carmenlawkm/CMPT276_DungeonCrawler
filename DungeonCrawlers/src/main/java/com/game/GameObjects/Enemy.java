package main.java.com.game.GameObjects;

import java.awt.*;

public class Enemy extends GameObject{
    private int deductionValue;

    public Enemy(Point location, ID id, int deductionValue) {
        super(location, id);
        this.deductionValue = deductionValue;
        this.setImage("/main/resources/enemy.png");
    }

    void setDeductionValue(int value){
        deductionValue = value;
    }

    void moveTowardsPlayer(Point playerLocation){
        //method to move towards player point
    }
}
