package GameObjects;

import graphics.Assets;
import state.Game;

import java.awt.*;

public class Enemy extends GameObject{
    private int deductionValue;

    public Enemy(Game game, Point location, int deductionValue) {
        super(location);
        this.deductionValue = deductionValue;
        this.image = Assets.enemy;
    }

    void setDeductionValue(int value){
        deductionValue = value;
    }

    public void moveTowardsPlayer(Point playerLocation){
    }

    @Override
    public void update() {
        setLocation(location.x, location.y + 100);
    }
}
