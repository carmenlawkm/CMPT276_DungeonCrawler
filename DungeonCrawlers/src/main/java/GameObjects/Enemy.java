package GameObjects;

import com.sun.tools.javac.Main;
import graphics.Assets;

import java.awt.*;

public class Enemy extends GameObject{
    //MainCharacter player=MainCharacter.getInstance();
    MainCharacter player=MainCharacter.getInstance();
    private int deductionValue;

    public Enemy(Point location, ID id, int deductionValue) {
        super(location);
        this.deductionValue = deductionValue;
        this.image = Assets.enemy;
    }

    void setDeductionValue(int value){
        deductionValue = value;
    }


    @Override
    public void update() {
        // enemy will prioritize moving in terms of left and right direction to
        // player then prioritizes moving up and down closer to player
        int flag=0;
        int xtowardsplayer=0;
        int ytowardsplayer=0;
        while(flag==0) {
            if (location.x < player.getX()) {
                xtowardsplayer = 40;
                flag=1;
                break;
            }
            if (location.x > player.getX()) {
                xtowardsplayer = -40;
                flag=1;
                break;
            }
            if (location.y < player.getY()) {
                ytowardsplayer = 40;
                flag=1;
                break;
            }
            if (location.y > player.getY()) {
                ytowardsplayer = -40;
                flag=1;
                break;
            }
        }
        setLocation(location.x+xtowardsplayer, location.y + ytowardsplayer);
    }
}
