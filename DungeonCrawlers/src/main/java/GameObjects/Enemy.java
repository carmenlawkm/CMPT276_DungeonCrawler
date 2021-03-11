package GameObjects;

import graphics.Assets;

import java.awt.*;

public class Enemy extends GameObject{
    private int deductionValue;

    public Enemy(Point location, ID id, int deductionValue) {
        super(location);
        this.deductionValue = deductionValue;
        this.image = Assets.enemy;
    }

    void setDeductionValue(int value){
        deductionValue = value;
    }

    public void moveTowardsPlayer(Point playerLocation){
        //TESTING MOVEMENT, TO BE REMOVED
        setLocation(location.x, location.y + 50);
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {

    }
}
