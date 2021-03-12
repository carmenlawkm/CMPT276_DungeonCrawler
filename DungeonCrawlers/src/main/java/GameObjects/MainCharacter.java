package GameObjects;

import state.Game;
import graphics.*;

import java.awt.*;

public class MainCharacter extends GameObject {
    private Point spawn;
    protected int score;

    //constructor
    public MainCharacter(Point location) {
        super(location);
        score = 0;
        this.image = Assets.player;
    }

    @Override
    public void update() {

        //always update player
        imageChanged = true;
        game.getKeyInput().update();

        if (game.ifKeyPressed()){
            if (game.getKeyInput().up) {
                location.y -= 50;
            }
            if (game.getKeyInput().down) {
                location.y += 50;
            }
            if (game.getKeyInput().left) {
                location.x -= 50;
            }
            if (game.getKeyInput().right) {
                location.x += 50;
            }
        }
    }

    //setters
    public void setSpawn(int x, int y){
        spawn.x = x;
        spawn.y = y;
    }
}
