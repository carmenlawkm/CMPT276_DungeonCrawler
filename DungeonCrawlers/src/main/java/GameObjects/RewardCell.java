package GameObjects;
import graphics.Assets;
import java.awt.*;

public abstract class RewardCell extends GameObject{
    int value;

    RewardCell(Point location, int value) {
        super(location);
        this.value = value;
    }
    public void update(){

    }

}
