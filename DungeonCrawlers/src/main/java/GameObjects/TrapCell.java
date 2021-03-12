package GameObjects;

import graphics.Assets;

import java.awt.*;

public class TrapCell extends GameObject{
    int deductionValue;
    int disappearTimer;

    public TrapCell(Point location, int deductionValue, int disappearTimer) {
        super(location);
        this.deductionValue = deductionValue;
        this.disappearTimer = disappearTimer;
        this.image = Assets.trap;
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

    }
}
