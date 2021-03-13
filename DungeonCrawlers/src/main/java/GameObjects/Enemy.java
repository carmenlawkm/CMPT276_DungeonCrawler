package GameObjects;

import World.Tile;
import com.sun.tools.javac.Main;
import graphics.Assets;
import state.Game;

import java.awt.*;

public class Enemy extends GameObject{
    private int texturesize= Tile.TEXTUREHEIGHT;
    //MainCharacter player=MainCharacter.getInstance();
    MainCharacter player;
    private int deductionValue;

    public Enemy(Game game, Point location, int deductionValue, MainCharacter player) {
        super(location);
        this.deductionValue = deductionValue;
        this.image = Assets.enemy;
        this.player=player;
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

        }
        while(flag==0) {

            xtowardsplayer=0;
            ytowardsplayer=0;
            if (location.x == player.getX() && location.y==player.getY()) {
                xtowardsplayer = texturesize;
                ytowardsplayer = texturesize;
                flag=1;
                System.out.println("enemy is to the left of player");
                break;
            }
            else if (location.x > player.getX()) {
                xtowardsplayer = -texturesize;
                flag=1;
                System.out.println("enemy is to the right of player");
                break;
            }
            else if (location.y < player.getY()) {
                ytowardsplayer = texturesize;
                flag=1;
                System.out.println("enemy is above the player");
                break;
            }
            else if (location.y > player.getY()) {
                ytowardsplayer = -texturesize;
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
