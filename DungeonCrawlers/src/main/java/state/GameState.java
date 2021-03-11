package state;

import GameObjects.Enemy;
import GameObjects.ID;
import GameObjects.MainCharacter;

import java.awt.*;
import java.util.ArrayList;

public class GameState extends State{
    private MainCharacter player;
    private MainCharacter player2;


    private ArrayList<Enemy> enemies = new ArrayList<Enemy>();

    public GameState(Game game){
        super(game);
        player = new MainCharacter(game,new Point(100, 100));
        player2 = new MainCharacter(game,new Point(500, 100));


        enemies.add(new Enemy(new Point(500, 500), ID.Enemy, 10));
        enemies.add(new Enemy(new Point(200, 500), ID.Enemy, 10));
        enemies.add(new Enemy(new Point(500, 800), ID.Enemy, 10));
    }

    public void update() {
        player.update();
        player2.update();

        for (Enemy enemy: enemies){
            enemy.update();
        }
    }

    public void render(Graphics g) {
        player.render(g);
        player2.update();

        for (Enemy enemy: enemies){
            enemy.update();
        }
    }
}
