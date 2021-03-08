package main.java.com.game.GameObjects;

import main.java.com.game.Game;
import main.java.com.game.graphics.Assets;

import java.awt.*;

public class MainCharacter extends GameObject {
    private Point spawn;
    protected int score;
    private Game game;

    //constructor
    public MainCharacter(Game game, Point location) {
        super(location);
        score = 0;
        this.game = game;
    }

    @Override
    public void update() {
        if(game.getKeyInput().up){
            location.y -=3;
        }
        if(game.getKeyInput().down){
            location.y +=3;
        }
        if(game.getKeyInput().left){
            location.x -=3;
        }
        if(game.getKeyInput().right){
            location.x +=3;
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.player, location.x,location.y, 128,128,null);
    }

    //setters
    public void setSpawn(int x, int y){
        spawn.x = x;
        spawn.y = y;
    }
}
