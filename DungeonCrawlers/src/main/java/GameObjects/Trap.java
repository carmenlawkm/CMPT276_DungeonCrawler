package GameObjects;

import World.World;
import graphics.Assets;

import java.awt.*;

public class Trap extends GameObject {

    protected boolean steppedOn = false;
    private int deductionValue;
    private MainCharacter player;

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

    /**
     * Update reduces the player's score by the trap's deduction value if player location same as trap location
     * and trap has not yet been stepped on
     *
     */
    public void update() {
        if (player.getX() == location.x && player.getY() == location.y && !steppedOn) {
            player.score = player.score - deductionValue;
            this.image = Assets.trapgone;
            deductionValue = 0;
            steppedOn = true;
        }
    }
}
