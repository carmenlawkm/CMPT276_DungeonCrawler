package main.java.com.game.GameObjects;

import java.awt.*;

public class Enemy extends GameObject{
    private int deductionValue;

    Enemy(String image, Point location, ID id, int deductionValue) {
        super(image, location, id);
        this.deductionValue = deductionValue;
    }

    void setDeductionValue(int value){
        deductionValue = value;
    }

    void moveTowardsPlayer(Point playerLocation){
        //method to move towards player point
    }
}
