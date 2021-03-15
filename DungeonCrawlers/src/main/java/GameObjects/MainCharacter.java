package GameObjects;

import com.sun.tools.javac.Main;
import state.Game;
import graphics.*;
import World.*;

import java.awt.*;

/**
 * MainCharacter class defines the player-controlled character of the game
 */
public class MainCharacter extends Creatures {
    private Point spawn;
    protected int score;
    private static MainCharacter instance=null;
    //private Game game;
    private World w;
    private Tile nextTile;
    private int tileSize = Tile.TEXTUREWIDTH;

    /**
     * MainCharacter constructor
     * @param world defines the world the character is loaded in
     * @param location defines the spawning point of the player
     */
    public MainCharacter(World world, Point location) {
        super(location);
        score = 100;
        this.image = Assets.player;
        this.game = Game.getInstance();
        this.w = world;
    }

    /**
     * update method allows player to get key input
     * determines direction of key input and udpates player location
     */
    @Override
    public void update() {

        game.getKeyInput().update();

        if(game.getKeyInput().up){
            nextTile = w.getTile(location.x/tileSize , (location.y-tileSize)/tileSize);
            if(nextTile.getID() != 1)
                location.y -=tileSize;
        }
        if(game.getKeyInput().down){
            nextTile = w.getTile(location.x/tileSize , (location.y + tileSize)/tileSize);
            if(nextTile.getID() != 1)
                location.y +=tileSize;
        }
        if(game.getKeyInput().left ){
            nextTile = w.getTile((location.x - tileSize)/tileSize, location.y/tileSize);
            if(nextTile.getID() != 1)
            location.x -=tileSize;
        }
        if(game.getKeyInput().right){
            nextTile = w.getTile((location.x + tileSize)/tileSize, location.y/tileSize);
            if(nextTile.getID() != 1)
            location.x +=tileSize;
        }
    }

}
