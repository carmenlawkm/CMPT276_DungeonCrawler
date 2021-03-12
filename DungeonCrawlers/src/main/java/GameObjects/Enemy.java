package GameObjects;

import com.sun.tools.javac.Main;
import graphics.Assets;

import java.awt.*;

public class Enemy extends GameObject{
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
        /*MainCharacter player=MainCharacter.getInstance();
        //int y=player.y;
        int xtowardsplayer=0;
        int ytowardsplayer=0;
        if(location.x<player.){
            xtowardsplayer=50;
        }
        if(location.x>player.x){
            xtowardsplayer=-50;
        }
        if(location.y<player.y){
            ytowardsplayer=50;
        }
        if(location.y>player.y){
            ytowardsplayer=-50;
        }*/
        setLocation(location.x, location.y + 40);
    }
}
