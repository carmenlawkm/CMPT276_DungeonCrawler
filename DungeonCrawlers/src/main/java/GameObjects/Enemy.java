package GameObjects;

import com.sun.tools.javac.Main;
import graphics.Assets;

import java.awt.*;

public class Enemy extends GameObject{
    //MainCharacter player=MainCharacter.getInstance();
    MainCharacter player=MainCharacter.getInstance();
    private int deductionValue;
    private int stunned=0;
    public Enemy(Point location, ID id, int deductionValue) {
        super(location);
        this.deductionValue = deductionValue;
        this.image = Assets.enemy;
    }

    void setDeductionValue(int value){
        deductionValue = value;
    }
    //public stunned

    @Override
    public void update() {
        // enemy will prioritize moving in terms of left and right direction to
        // player then prioritizes moving up and down closer to player
        int flag=0;
        //int stunned=0;
        int xtowardsplayer=0;
        int ytowardsplayer=0;
        if(location.x==player.getX() && location.y==player.getY()){
            flag=1;
            player.score=player.score-deductionValue;
            System.out.println("enemy is in same spot as player");

            stunned=1;
        }
        while(flag==0 && stunned==0) {
            xtowardsplayer=0;
            ytowardsplayer=0;
            if (location.x == player.getX() && location.y==player.getY()) {
                xtowardsplayer = 0;
                ytowardsplayer = 0;
                flag=1;
                System.out.println("enemy is to the left of player");
                break;
            }
            else if (location.x > player.getX()) {
                xtowardsplayer = -40;
                flag=1;
                System.out.println("enemy is to the right of player");
                break;
            }
            else if (location.y < player.getY()) {
                ytowardsplayer = 40;
                flag=1;
                System.out.println("enemy is above the player");
                break;
            }
            else if (location.y > player.getY()) {
                ytowardsplayer = -40;
                System.out.println("enemy is below the player");
                break;
            }
            else{
                xtowardsplayer=0;
                ytowardsplayer=0;
                System.out.println("did this trigger");
                break;
            }


        }
        setLocation(location.x+xtowardsplayer, location.y + ytowardsplayer);
    }
}
