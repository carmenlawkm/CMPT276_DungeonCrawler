package GameObjects;

import World.World;
import com.sun.tools.javac.Main;
import graphics.Assets;

import java.awt.*;

public class Trap extends GameObject{

    private int deductionValue;
    private MainCharacter player;
    protected boolean notSteppedOn = true;

    /**
     * GameObject constructor
     *
     * @param world
     * @param location defines the location of the object
     */
    public Trap(World world, Point location, int deductionValue, MainCharacter player) {
        super(world, location);
        this.image = Assets.trap;
        this.deductionValue = deductionValue;
        this.player = player;
    }

    public void update() {
        if(player.getX()==location.x && player.getY()==location.y && notSteppedOn){
            player.score=player.score-deductionValue;
            this.image=Assets.trapgone;
            deductionValue=0;
            notSteppedOn = false;
        }

    }
}
