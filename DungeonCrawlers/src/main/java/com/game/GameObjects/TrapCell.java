package main.java.com.game.GameObjects;

import java.awt.*;

public class TrapCell extends GameObject{
    int deductionValue;
    int disappearTimer;

    TrapCell(Point location, int deductionValue, int disappearTimer) {
        super(location);
        this.deductionValue = deductionValue;
        this.disappearTimer = disappearTimer;
        //this.setImage("/main/resources/trap.png");
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

    @Override
    public void render(Graphics g) {

    }
}
