package state;

import GameObjects.Enemy;
import GameObjects.ID;
import GameObjects.MainCharacter;

import java.awt.*;
import java.util.ArrayList;

public class GameState extends State{
    private MainCharacter player;


    private ArrayList<Enemy> enemies = new ArrayList<Enemy>();

    public GameState(Game game){
        super(game);
        player = new MainCharacter(new Point(100, 100));

        enemies.add(new Enemy(new Point(500, 500), ID.Enemy, 10));
        enemies.add(new Enemy(new Point(200, 500), ID.Enemy, 10));
        enemies.add(new Enemy(new Point(500, 800), ID.Enemy, 10));
    }

    public void update() {
        player.update();

        for (Enemy enemy: enemies){
            enemy.update();
        }
    }

    public void render(Graphics g) {
        player.render(g);

        for (Enemy enemy: enemies){
            enemy.render(g);
        }
    }
}
