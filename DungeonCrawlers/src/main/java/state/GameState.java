package state;

import GameObjects.*;
import GameObjects.Enemy;
import GameObjects.MainCharacter;
import World.World;

import java.awt.*;
import java.util.ArrayList;

public class GameState extends State{
    private Timer timer;
    private MainCharacter player;
    private World world;
    private static Point spawnPoint = new Point(100,100);
    private static Point spawnPoint2 = new Point(300,300);
    private Enemy enemy;

    public GameState(Game game){
        super(game);

        timer = game.getTimer();
        world = new World("src/main/resources/Level1.txt");
        player = new MainCharacter(game,world,spawnPoint);
        enemy = new Enemy(game, spawnPoint2, 100);
    }

    @Override
    public void render() {

    }

    @Override
    public void initiateState() {
        timer.start();
        world.start();
        player.start();
        enemy.start();
    }

    public void update() {
        player.update();
    }

}
