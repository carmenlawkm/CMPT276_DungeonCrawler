package state;

import graphics.Assets;

import java.awt.*;

/**
 * State to indicate the player has died
 */
public class GameOverState extends State{
    private Game game;

    /**
     * Constructor
     * @param game the game to render this to
     */
    public GameOverState(Game game){
        this.game = game;
    }

    /**
     * renders the special graphics of game over status
     * @param g Graphic to render on
     */
    public void render(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0,0,1200,800);
        g.setColor(Color.white);
        g.setFont(Assets.eightBit_over);
        g.drawString("GAME OVER!", 360, 400);

    }

    /**
     * sets the game to not running
     */
    public void update() {
        game.setRunning(false);
    }

}
