package main.java.com.game.GameObjects;

import java.awt.*;

public class TrapCell extends GameObject{
    int deductionValue;
    int disappearTimer;

    TrapCell(Image image, Point location, ID id, int deductionValue, int disappearTimer) {
        super(image, location, id);
        this.deductionValue = deductionValue;
        this.disappearTimer = disappearTimer;
    }

    //getters
    public int getDeductionValue(){
        return deductionValue;
    }

    public int getDisappearTimer(){
        return disappearTimer;
    }

    //methods
    public void startTimer(int timer){
        //method to start counting down to when it will disappear
    }
}
