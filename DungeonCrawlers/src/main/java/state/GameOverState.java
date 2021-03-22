package state;

import graphics.Assets;

import java.awt.*;

public class GameOverState extends State{
    private Game game;

    public GameOverState(Game game){
        this.game = game;
    }

    public void render(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0,0,1200,800);
        g.setColor(Color.white);
        g.setFont(Assets.eightBit_over);
        g.drawString("GAME OVER!", 360, 400);

    }

    public void update() {
        game.setRunning(false);
    }

}
