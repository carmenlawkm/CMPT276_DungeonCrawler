package state;

import GameObjects.MainCharacter;

import java.awt.*;

public class GameState extends State{
    private MainCharacter player;
    private static Point spawnPoint = new Point(100,100);

    public GameState(Game game){
        super(game);
        player = new MainCharacter(game,spawnPoint);
    }

    public void update() {
        player.update();
    }

    public void render(Graphics g) {
        player.render(g);
    }
}
