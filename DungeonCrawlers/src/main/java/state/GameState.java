package state;

import GameObjects.*;

import java.awt.*;
import java.util.ArrayList;

public class GameState extends State{
    private Timer timer;
    private ArrayList<GameObject> objects = new ArrayList<GameObject>();

    public GameState(Game game){
        super(game);

        timer = game.getTimer();

        //design level here!
        objects.add(MainCharacter.getInstance());
        objects.add(new Enemy(new Point(200, 200), ID.Enemy, 50));
        objects.add(new Enemy(new Point(400, 400), ID.Enemy, 50));
        objects.add(new Enemy(new Point(440, 440), ID.Enemy, 50));
        objects.add(new TrapCell(new Point(300, 300), 50, 50));
        objects.add(new TrapCell(new Point(220, 250), 50, 50));
        objects.add(new BarrierCell(new Point(600, 600)));
        objects.add(new BarrierCell(new Point(600, 640)));
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
