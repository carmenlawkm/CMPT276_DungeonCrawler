package GameObjects;

import com.sun.tools.javac.Main;
import graphics.Assets;

import java.awt.*;

public class TrapCell extends GameObject{
    int deductionValue;
    int disappearTimer;
    MainCharacter player;
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

    @Override
    public void update() {
        if(player.getX()==location.x && player.getY()==location.y){
            player.score=player.score-deductionValue;
            System.out.println(player.score);
        }

    }
}
