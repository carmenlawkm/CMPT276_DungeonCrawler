package GameObjects;

import state.Game;
import graphics.*;

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

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.player, location.x,location.y, 50,50,null);
    }

    //setters
    public void setSpawn(int x, int y){
        spawn.x = x;
        spawn.y = y;
    }
}
