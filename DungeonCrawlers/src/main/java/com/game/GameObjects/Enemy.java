package main.java.com.game.GameObjects;

import java.awt.*;

public class Enemy extends GameObject{
    private int deductionValue;

    public Enemy(Point location, ID id, int deductionValue) {
        super(location);
        this.deductionValue = deductionValue;

    }

    void setDeductionValue(int value){
        deductionValue = value;
    }

    public void moveTowardsPlayer(Point playerLocation){
        //method to move towards player point
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {

    }
}
