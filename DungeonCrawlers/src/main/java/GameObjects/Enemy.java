package GameObjects;

import graphics.Assets;
import state.Game;

import java.awt.*;

public class Enemy extends GameObject{
    private int deductionValue;

    public Enemy(Game game, Point location, int deductionValue) {
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
        g.drawImage(Assets.enemy, location.x,location.y, 100,100,null);
    }
}
