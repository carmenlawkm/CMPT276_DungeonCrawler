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
    }

    @Override
    public void render() {

    }

    @Override
    public void initiateState() {
        world = new World("src/main/resources/Level1.txt");
        player = new MainCharacter(game,world,spawnPoint);
        enemy = new Enemy(game, spawnPoint2, 100);

        timer.start();
        player.start();
        enemy.start();
    }

    public void update() {
        world.tick();
        player.update();
    }

//    public void render(Graphics g) {
//        world.render(g);
//        player.render(g);
//        enemy.render(g);
//
//    }
}
