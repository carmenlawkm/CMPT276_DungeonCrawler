package GameObjects;

import com.sun.tools.javac.Main;
import state.Game;
import graphics.*;
import World.*;

import java.awt.*;

public class MainCharacter extends Creatures {
    private Point spawn;
    protected int score;
    private static MainCharacter instance=null;
    //private Game game;
    private World w;
    private Tile nextTile;
    private int tileSize = Tile.TEXTUREWIDTH;

    //constructor
    public MainCharacter(World world, Point location) {
        super(location);
        score = 100;
        this.image = Assets.player;
        this.game = Game.getInstance();
        this.w = world;
    }


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

    //setters
    public void setSpawn(int x, int y){
        spawn.x = x;
        spawn.y = y;
    }


}
