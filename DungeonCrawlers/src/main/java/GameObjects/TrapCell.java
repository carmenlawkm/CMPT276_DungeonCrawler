package GameObjects;

import com.sun.tools.javac.Main;
import graphics.Assets;

import java.awt.*;

/**
 * TrapCell defines non-moving cell the player must avoid
 * Deducts points when the player steps on it
 */
public class TrapCell extends GameObject{
    int deductionValue;
    int disappearTimer;
    MainCharacter player;

    /**
     * Trapcell constructor
     * @param location defines the location of the trap
     * @param deductionValue defines the points the player loses when stepping on the trap
     * @param disappearTimer defines the number of ticks before the trap disappears
     * @param player defines the player-controlled character on the map
     */
    public TrapCell(Point location, int deductionValue, int disappearTimer, MainCharacter player) {
        super(location);
        this.deductionValue = deductionValue;
        this.disappearTimer = disappearTimer;
        this.image = Assets.trap;
        this.player=player;
    }

    //getters
    public int getDeductionValue(){
        return deductionValue;
    }

    public int getDisappearTimer(){
        return disappearTimer;
    }

    //methods
    public void startTimer(){
        //method to start counting down to when it will disappear
    }

    /**
     * checks if the player is on the trap and deducts points if true
     */
    @Override
    public void update() {
        if(disappearTimer==2){
            this.image = Assets.trapgone;
        }
        if(player.getX()==location.x && player.getY()==location.y){
            player.score=player.score-deductionValue;
            this.image=Assets.trap;
            disappearTimer=0;
        }
        System.out.println(player.score);
        disappearTimer++;
    }
}
