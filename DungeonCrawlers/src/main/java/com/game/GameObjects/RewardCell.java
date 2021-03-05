package main.java.com.game.GameObjects;

import java.awt.*;

public abstract class RewardCell extends GameObject{
    int value;

    RewardCell(Image image, Point location, ID id, int value) {
        super(image, location, id);
        this.value = value;
    }




}
