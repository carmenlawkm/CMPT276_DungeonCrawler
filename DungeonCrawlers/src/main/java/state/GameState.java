package state;

import GameObjects.Enemy;
import GameObjects.GameObject;
import GameObjects.ID;
import GameObjects.MainCharacter;

import java.awt.*;
import java.util.ArrayList;

public class GameState extends State{
    private Timer timer;
    private ArrayList<GameObject> objects = new ArrayList<GameObject>();

    public GameState(Game game){
        super(game);

        timer = game.timer;

        //design level here!
        objects.add(new MainCharacter(new Point(100, 100)));
        objects.add(new Enemy(new Point(800, 800), ID.Enemy, 50));
        objects.add(new Enemy(new Point(600, 600), ID.Enemy, 50));
        objects.add(new Enemy(new Point(800, 800), ID.Enemy, 50));
    }

    public void update() {
    }

    @Override
    public void render() {

    }

    @Override
    public void initiateState() {
        //start timer thread
        timer.start();

        //start threads for each game object
        for (GameObject object: objects){
            object.start();
        }
    }
}
