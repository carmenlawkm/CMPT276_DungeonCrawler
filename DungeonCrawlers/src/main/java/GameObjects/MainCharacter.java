package GameObjects;

import com.sun.tools.javac.Main;
import state.Game;
import graphics.*;

import java.awt.*;

public class MainCharacter extends GameObject {
    private Point spawn;
    protected int score;
    private static MainCharacter instance=null;

    //constructor
    public MainCharacter(Point location) {
        super(location);
        score = 0;
        this.image = Assets.player;
    }
    public static MainCharacter getInstance(){

        if(instance == null){
            instance = new MainCharacter(new Point(100,100));
        }
        return instance;
    }


    @Override
    public void update() {
        game.getKeyInput().update();

        if (game.getKeyInput().up) {
            if((location.y-50<=800) && (location.y-50>=0)){
                location.y -= 50;
            }
        }
        if (game.getKeyInput().down) {
            if((location.y+50<=800) && (location.y+50>=0)){
                location.y += 50;
            }
        }
        if (game.getKeyInput().left) {
            if((location.x-50<=1200) && (location.x-50>=0)){
                location.x -= 50;
            }
        }
        if (game.getKeyInput().right) {
            if((location.x+50<=1200) && (location.x+50>=0)){
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
